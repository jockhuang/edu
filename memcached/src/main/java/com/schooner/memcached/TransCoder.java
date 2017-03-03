package com.schooner.memcached;

import java.io.IOException;
import java.io.InputStream;

/**
 * {@link TransCoder} is used to customize the serialization and deserialization in memcached operations.
 * 
 * @see ObjectTransCoder
 * 
 * @author Xingen Wang
 * @since 2.5.0
 * @see TransCoder
 */
public interface TransCoder {
    /**
     * decode the object from the inputstream.
     * 
     * @param input inputstream.
     * @return decoded java object.
     * @throws IOException error happened in decoding the input stream.
     */
    Object decode(final InputStream input) throws IOException;

    /**
     * encode the java object into outputstream.
     * 
     * @param out outputstream, you can in get written length of bytes in {@link SockOutputStream}.
     * @param object object to be encoded.
     * @return written size, which is used in memcached set operation.
     * @throws IOException error happened in encoding the output stream.
     */
    int encode(final SockOutputStream out, final Object object) throws IOException;
}
