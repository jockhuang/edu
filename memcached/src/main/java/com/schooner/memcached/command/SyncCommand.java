package com.schooner.memcached.command;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.schooner.memcached.SpeclSockIO;

/**
 * Sync specified item to flash. Only supported by Schooner memcached server.
 * 
 */
public class SyncCommand extends Command {

    public static Logger log = Logger.getLogger(SyncCommand.class);
    public static final String SYNCED = "SYNCED\r\n";
    public static final String NOTFOUND = "NOT_FOUND\r\n";

    private String key;

    public SyncCommand(String key, Integer hashCode) {
        // build command
        StringBuilder command = new StringBuilder("sync ").append(key);
        command.append("\r\n");
        textLine = command.toString().getBytes();
        this.key = key;
    }

    public boolean response(SpeclSockIO sock, short rid) throws IOException {
        String line;
        byte[] temp = sock.getResponse(rid);
        line = new String(temp);

        if (SYNCED.equals(line)) {
            if (log.isInfoEnabled()) {
                log.info(new StringBuffer().append("++++ sync of key: ").append(key)
                        .append(" from cache was a success").toString());
            }

            return true;
        } else if (NOTFOUND.equals(line)) {
            if (log.isInfoEnabled()) {
                log.info(new StringBuffer().append("++++ sync of key: ").append(key)
                        .append(" from cache failed as the key was not found").toString());
            }
        } else {
            log.error(new StringBuffer().append("++++ error sync key: ").append(key).toString());
            log.error(new StringBuffer().append("++++ server response: ").append(line).toString());
        }

        return false;
    }

}
