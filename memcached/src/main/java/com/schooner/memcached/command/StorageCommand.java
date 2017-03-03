package com.schooner.memcached.command;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.log4j.Logger;

import cn.chineseall.memcached.MemcachedClient;

import com.schooner.memcached.NativeHandler;
import com.schooner.memcached.ObjectTransCoder;
import com.schooner.memcached.SockOutputStream;
import com.schooner.memcached.SpeclSockIO;
import com.schooner.memcached.TransCoder;

/**
 * This command implements the set command using memcached UDP protocol.
 * 
 */
public class StorageCommand extends Command {

    public static Logger log = Logger.getLogger(StorageCommand.class);
    public static final byte[] STORED = "STORED\r\n".getBytes();
    public static final byte[] NOT_STORED = "NOT_STORED\r\n".getBytes();
    public final byte[] BLAND_DATA_SIZE = "       ".getBytes();
    public static final byte[] B_RETURN = "\r\n".getBytes();

    private int flags;

    private TransCoder transCoder = new ObjectTransCoder();

    private Object value;

    private int valLen = 0;

    private int offset;

    private Long casUnique;

    /**
     * set request textline: "set &lt;key&gt; &lt;key&gt; &lt;flags&gt; &lt;exptime&gt; &lt;bytes&gt; [noreply]\r\n"
     * 
     */
    public StorageCommand(String cmdname, String key, Object value, Date expiry, Integer hashCode, Long casUnique) {
        init(cmdname, key, value, expiry, hashCode, casUnique);
    }

    /**
     * set request textline: "set &lt;key&gt; &lt;key&gt; &lt;flags&gt; &lt;exptime&gt; &lt;bytes&gt; [noreply]\r\n"
     * 
     */
    public StorageCommand(String cmdname, String key, Object value, Date expiry, Integer hashCode, Long casUnique,
            TransCoder transCoder) {
        init(cmdname, key, value, expiry, hashCode, casUnique);
        this.transCoder = transCoder;
    }

    private void init(String cmdname, String key, Object value, Date expiry, Integer hashCode, Long casUnique) {
        // store flags
        flags = NativeHandler.getMarkerFlag(value);
        // construct the command
        String cmd = new StringBuffer().append(cmdname).append(" ").append(key).append(" ").append(flags).append(" ")
                .append(expiry.getTime() / 1000).append(" ").toString();

        textLine = cmd.getBytes();

        this.value = value;
        this.casUnique = casUnique;
    }

    private boolean writeDataBlock(SpeclSockIO sock) throws IOException {
        SockOutputStream output = new SockOutputStream(sock);
        if (flags != MemcachedClient.MARKER_OTHERS) {
            /*
             * Using NativeHandler to serialize the value
             */
            byte[] b = NativeHandler.encode(value);
            output.write(b);
            valLen = b.length;
        } else {
            /*
             * Using default object transcoder to serialize the non-primitive values.
             */
            valLen = transCoder.encode(output, value);
        }

        sock.writeBuf.put(B_RETURN);

        byte[] objectSize = new Integer(valLen).toString().getBytes();
        int oldPosition = sock.writeBuf.position();
        sock.writeBuf.position(offset);
        // put real object bytes size
        sock.writeBuf.put(objectSize);
        // return to correct position.
        sock.writeBuf.position(oldPosition);

        return true;
    }

    @Override
    public short request(SpeclSockIO sock) throws IOException {
        short rid = sock.preWrite();
        sock.writeBuf.put(textLine);

        offset = sock.writeBuf.position();
        // write blank bytes size.
        sock.writeBuf.put(BLAND_DATA_SIZE);
        if (casUnique != 0) {
            sock.writeBuf.put((" " + casUnique.toString()).getBytes());
        }

        sock.writeBuf.put(B_RETURN);

        if (value != null) {
            writeDataBlock(sock);
        }

        sock.writeBuf.flip();
        sock.getByteChannel().write(sock.writeBuf);

        return rid;
    }

    public boolean response(SpeclSockIO sock, short rid) throws IOException {
        byte[] temp = sock.getResponse(rid);// new
        // byte[sock.readBuf.position()];

        if (Arrays.equals(STORED, temp)) {
            /*
             * Successfully set here.
             */
            return true;
        }

        return false;
    }

}
