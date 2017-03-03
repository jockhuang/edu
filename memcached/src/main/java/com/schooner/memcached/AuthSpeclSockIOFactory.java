package com.schooner.memcached;

import java.io.DataInputStream;

import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;

import org.apache.log4j.Logger;

import cn.chineseall.memcached.MemcachedClient;

/**
 * * {@link AuthSpeclSockIOFactory} is used to create and destroy socket for connection pool with authorized
 * information.
 * 
 * @see AuthSpeclSockIOFactory
 */
public class AuthSpeclSockIOFactory extends SpeclSockIOFactory {

    // logger
    public static Logger log = Logger.getLogger(AuthSpeclSockIOFactory.class);

    public final static String NTLM = "NTLM";
    public final static String PLAIN = "PLAIN";
    public final static String LOGIN = "LOGIN";
    public final static String DIGEST_MD5 = "DIGEST-MD5";
    public final static String CRAM_MD5 = "CRAM-MD5";
    public final static String ANONYMOUS = "ANONYMOUS";

    public static final byte[] EMPTY_BYTES = new byte[0];

    private AuthInfo authInfo;

    public AuthSpeclSockIOFactory(String host, boolean isTcp, int bufferSize, int socketTO, int socketConnectTO,
            boolean nagle, AuthInfo authInfo) {
        super(host, isTcp, bufferSize, socketTO, socketConnectTO, nagle);
        this.authInfo = authInfo;
    }

    @Override
    public Object makeObject() throws Exception {
        SpeclSockIO socket = createSocket(host);
        auth(socket);
        return socket;
    }

    private void auth(SpeclSockIO socket) throws Exception {
        SaslClient saslClient = Sasl.createSaslClient(authInfo.getMechanisms(), null, "memcached", host, null,
                this.authInfo.getCallbackHandler());

        byte[] authData = saslClient.hasInitialResponse() ? saslClient.evaluateChallenge(EMPTY_BYTES) : EMPTY_BYTES;

        authData = sendAuthData(socket, MemcachedClient.OPCODE_START_AUTH, saslClient.getMechanismName(), authData);
        if (authData == null) {
            return;
        }
        authData = saslClient.evaluateChallenge(authData);
        if (sendAuthData(socket, MemcachedClient.OPCODE_AUTH_STEPS, saslClient.getMechanismName(), authData) == null) {
            return;
        }

        log.error("Auth Failed: mechanism = " + saslClient.getMechanismName());
        throw new Exception();
    }

    private byte[] sendAuthData(SpeclSockIO sock, byte opcode, String mechanism, byte[] authData) throws Exception {
        sock.writeBuf.clear();
        sock.writeBuf.put(MemcachedClient.MAGIC_REQ);
        sock.writeBuf.put(opcode);
        sock.writeBuf.putShort((short) mechanism.length());
        sock.writeBuf.putInt(0);
        sock.writeBuf.putInt(mechanism.length() + authData.length);
        sock.writeBuf.putInt(0);
        sock.writeBuf.putLong(0);
        sock.writeBuf.put(mechanism.getBytes());
        sock.writeBuf.put(authData);

        // write the buffer to server
        // now write the data to the cache server
        sock.flush();
        // get result code
        DataInputStream dis = new DataInputStream(new SockInputStream(sock, Integer.MAX_VALUE));
        dis.readInt();
        dis.readByte();
        dis.readByte();
        byte[] response = null;
        short status = dis.readShort();
        if (status == MemcachedClient.FURTHER_AUTH) {
            int length = dis.readInt();
            response = new byte[length];
            dis.readInt();
            dis.readLong();
            dis.read(response);
        } else if (status == MemcachedClient.AUTH_FAILED) {
            log.error("Auth Failed: mechanism = " + mechanism);
            throw new Exception();
        }

        return response;
    }
}
