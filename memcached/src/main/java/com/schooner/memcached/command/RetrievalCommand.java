package com.schooner.memcached.command;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.schooner.memcached.AscIIUDPClient;
import com.schooner.memcached.MemcachedItem;
import com.schooner.memcached.NativeHandler;
import com.schooner.memcached.SpeclSockIO;
import com.schooner.memcached.TransCoder;

/**
 * Retrieve a item from memcached server.
 */
public class RetrievalCommand extends Command {

    private static Logger log = Logger.getLogger(RetrievalCommand.class);

    private static final byte[] B_END = "END\r\n".getBytes();
    private static final byte[] B_VALUE = "VALUE ".getBytes();
    private String key;
    private String cmd;

    /**
     * 
     * request: "get <key>*\r\n" or "gets <key>\r\n"
     * 
     * response: "[item]*END\r\n"
     * 
     * item: "VALUE <key> <flags> <bytes> [<cas unique>]\r\n<data block>\r\n"
     * 
     * 
     * @param get or gets
     * @param key
     * @param hashCode
     * 
     */
    public RetrievalCommand(String cmd, String key) {
        this.key = key;
        this.cmd = cmd;
        StringBuilder command = new StringBuilder(cmd).append(DELIMITER).append(key).append(RETURN);
        textLine = command.toString().getBytes();
    }

    public class Value {
        public int flags;
        public int bytes;
        public long casUnique;
        public byte[] dataBlock;
    }

    public class ResponseParser {
        public Value retvalue = null;

        public void exec(byte[] res) throws IOException {
            ByteArrayInputStream stream = new ByteArrayInputStream(res);
            StringBuilder sb = new StringBuilder();
            byte[] end = new byte[5];
            byte next;
            int length = 0;

            // check if it is the end.
            stream.mark(0);
            stream.read(end);
            if (Arrays.equals(end, B_END)) {
                return;
            }
            stream.reset();

            Value value = new Value();
            // skip "VALUE &lt;key&gt; "
            stream.skip(B_VALUE.length + key.length() + 1);

            // get the length of &lt;flags&gt; and build it.
            length = 0;
            while ((next = (byte) stream.read()) != AscIIUDPClient.B_DELIMITER) {
                length++;
                sb.append((char) next);
            }
            try {
                value.flags = Integer.valueOf(sb.toString());
            } catch (NumberFormatException e) {
                retvalue = null;
                return;
            }
            sb.delete(0, length);

            // get the length of &lt;byte&gt; and build it.
            length = 0;
            while (((next = (byte) stream.read()) != AscIIUDPClient.B_DELIMITER) && (next != B_RETURN)) {
                length++;
                sb.append((char) next);
            }

            try {
                value.bytes = Integer.valueOf(sb.toString());
            } catch (NumberFormatException e) {
                retvalue = null;
                return;
            }
            sb.delete(0, length);

            if (cmd.equals("gets")) {
                // if gets then get the length of &lt;casUnique&gt; and build it.
                length = 0;
                while ((next = (byte) stream.read()) != B_RETURN) {
                    length++;
                    sb.append((char) next);
                }
                try {
                    value.casUnique = Long.valueOf(sb.toString());
                } catch (NumberFormatException e) {
                    retvalue = null;
                    return;
                }
                sb.delete(0, length);
            }

            // skip "\n"
            stream.skip(1);

            // build datablock
            value.dataBlock = new byte[value.bytes];
            stream.read(value.dataBlock);

            // skip "\r\n"
            stream.skip(2);

            // check if it is the end.
            stream.mark(0);
            stream.read(end);
            if (Arrays.equals(end, B_END)) {
                retvalue = value;
            }
        }
    }

    public MemcachedItem response(SpeclSockIO sock, TransCoder transCoder, short rid) throws IOException {
        byte[] res = sock.getResponse(rid);
        MemcachedItem item = new MemcachedItem();

        if (res == null) {
            return item;
        }

        ResponseParser parser = new ResponseParser();
        parser.exec(res);
        if (parser.retvalue != null) {
            Value value = parser.retvalue;
            if (cmd.equals("gets")) {
                item.casUnique = value.casUnique;
            }
            try {
                if (NativeHandler.isHandled(value.flags)) {
                    item.value = NativeHandler.decode(value.dataBlock, value.flags);
                } else if (transCoder != null) {
                    // decode object with default transcoder.
                    item.value = transCoder.decode(new ByteArrayInputStream(value.dataBlock));
                }
            } catch (IOException e) {
                log.error("error happend in decoding the object");
                throw e;
            }
            return item;
        }
        // TODO: for get multi only.
        return item;
    }
}
