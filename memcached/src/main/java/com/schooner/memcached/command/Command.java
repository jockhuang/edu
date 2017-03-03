package com.schooner.memcached.command;

import java.io.IOException;

import com.schooner.memcached.SpeclSockIO;

/**
 * The parent of all the command class.
 */
public abstract class Command {

    public static final String DELIMITER = " ";
    public static final String RETURN = "\r\n";

    public static final byte B_RETURN = (byte) 13;
    public static final byte B_NEXTLINE = (byte) 10;

    protected byte[] textLine = null;

    public short request(SpeclSockIO sock) throws IOException {
        short rid = sock.preWrite();
        sock.writeBuf.put(textLine);
        sock.writeBuf.flip();
        sock.getByteChannel().write(sock.writeBuf);
        return rid;
    }
}
