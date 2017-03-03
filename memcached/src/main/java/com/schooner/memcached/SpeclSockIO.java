package com.schooner.memcached;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

import org.apache.commons.pool.impl.GenericObjectPool;

import cn.chineseall.memcached.SockIOPool;

/**
 * An adapter of com.danga.MemCached.SockIOPool.SockIO.
 * 
 * @see SpeclSockIO
 * @see com.meetup.memcached.SockIOPool.SockIO
 */
public abstract class SpeclSockIO extends SockIOPool.SockIO {

    protected GenericObjectPool sockets;

    public SpeclSockIO(GenericObjectPool sockets, int bufferSize) throws UnknownHostException, IOException {
        super(null, null, 0, 0, false);
        this.sockets = sockets;
        this.bufferSize = bufferSize;
    }

    private int bufferSize = 1024 * 1025;

    // the datagram sent from memcached mustn't beyond 1400 bytes.
    public ByteBuffer readBuf = ByteBuffer.allocateDirect(8 * 1024);
    public ByteBuffer writeBuf;

    public abstract short preWrite();

    public abstract byte[] getResponse(short rid) throws IOException;

    /**
     * get byte channel from this socket.
     * 
     * @return the backing SocketChannel
     */
    public abstract ByteChannel getByteChannel();

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
        writeBuf = ByteBuffer.allocateDirect(this.bufferSize);
    }

    public int getBufferSize() {
        return bufferSize;
    }

}
