package com.schooner.memcached.command;

import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.schooner.memcached.SpeclSockIO;

/**
 * The command that remove all the items in memcached server.
 */
public class FlushAllCommand extends Command {

    public static Logger log = Logger.getLogger(FlushAllCommand.class);
    public static final byte[] OK = "OK\r\n".getBytes();

    public FlushAllCommand() {
        textLine = "flush_all\r\n".getBytes();
    }

    public boolean response(SpeclSockIO sock, short rid) throws IOException {
        byte[] res = sock.getResponse(rid);
        if (Arrays.equals(res, OK)) {
            return true;
        } else {
            return false;
        }
    }

}
