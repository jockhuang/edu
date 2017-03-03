package com.schooner.memcached;

import java.io.IOException;
import java.io.OutputStream;

/**
 * {@link AbstractTransCoder} is nearly the same as the interface {@link TransCoder}, the only difference is that you
 * needn't return the written size for memcached set operation.
 * 
 * @see TransCoder
 * @see ObjectTransCoder
 */
public abstract class AbstractTransCoder implements TransCoder {

    /*
     * (non-Javadoc)
     * 
     * @seecom.schooner.MemCached.TransCoder#encode(com.schooner.MemCached. SockOutputStream, java.lang.Object)
     */
    public int encode(SockOutputStream out, Object object) throws IOException {
        out.resetCount();
        encode((OutputStream) out, object);
        return out.getCount();
    }

    /**
     * encode the java object into outputstream.
     * 
     * @param out outputstream to hold the data.
     * @param object object to be encoded.
     * @throws IOException
     */
    public abstract void encode(OutputStream out, Object object) throws IOException;

}
