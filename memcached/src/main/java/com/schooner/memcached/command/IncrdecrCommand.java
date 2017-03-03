package com.schooner.memcached.command;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.schooner.memcached.SpeclSockIO;

/**
 * Increase a digital value in memcached server.
 */
public class IncrdecrCommand extends Command {

    public static Logger log = Logger.getLogger(IncrdecrCommand.class);
    public static final String NOTFOUND = "NOT_FOUND\r\n";

    private Long result;

    public IncrdecrCommand(String cmdname, String key, long inc, Integer hashCode) {
        String cmd = new StringBuffer().append(cmdname).append(" ").append(key).append(" ").append(inc).append("\r\n")
                .toString();
        textLine = cmd.getBytes();
    }

    public boolean response(SpeclSockIO sock, short rid) throws IOException {
        byte[] res = sock.getResponse(rid);
        String line = new String(res).split("\r\n")[0];
        if (line.matches("\\d+")) {
            // Sucessfully increase.
            // return sock to pool and return result
            try {
                result = Long.parseLong(line);
                return true;
            } catch (Exception ex) {
                log.error(new StringBuffer().append("Failed to parse Long value for key: ").toString());
            }
        }

        return false;
    }

    public Long getResult() {
        return result;
    }

}
