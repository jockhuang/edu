package com.schooner.memcached.command;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.log4j.Logger;

import com.schooner.memcached.SpeclSockIO;

/**
 * The command that delete an item in memcached server.
 */
public class DeletionCommand extends Command {

    private static Logger log = Logger.getLogger(DeletionCommand.class);
    private static final byte[] DELETED = "DELETED\r\n".getBytes();
    private static final byte[] NOTFOUND = "NOT_FOUND\r\n".getBytes();

    /**
     * deletion request textline: "delete <key> [<time>] [noreply]\r\n"
     * 
     */
    public DeletionCommand(String key, Integer hashCode, Date expiry) {
        StringBuilder command = new StringBuilder("delete").append(DELIMITER).append(key);
        if (expiry != null) {
            command.append(" " + expiry.getTime() / 1000);
        }
        command.append("\r\n");
        textLine = command.toString().getBytes();
    }

    public boolean response(SpeclSockIO sock, short rid) throws IOException {
        byte[] res = sock.getResponse(rid);
        if (Arrays.equals(res, DELETED)) {
            if (log.isDebugEnabled()) {
                log.debug("DELETED!");
            }
            return true;
        } else if (Arrays.equals(res, NOTFOUND)) {
            // if (log.isDebugEnabled())
            log.debug("NOT_FOUND!");
        } else {
            log.error("error");
        }
        return false;
    }
}
