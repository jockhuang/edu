package com.schooner.memcached.command;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.schooner.memcached.SpeclSockIO;

/**
 * Sync all the data to flash. Only supported by Schooner memcached server.
 */
public class SyncAllCommand extends Command {

    public static Logger log = Logger.getLogger(SyncAllCommand.class);
    public static final String SYNCED = "SYNCED\r\n";

    public SyncAllCommand() {
        textLine = "sync_all\r\n".getBytes();
    }

    public boolean response(SpeclSockIO sock, short rid) throws IOException {
        String line;
        byte[] temp = sock.getResponse(rid);
        sock.readBuf.get(temp);
        line = new String(temp);
        if (SYNCED.equals(line)) {
            return true;
        }
        return false;
    }

}
