package com.schooner.memcached;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import cn.chineseall.memcached.ContextObjectInputStream;

/**
 * {@link ObjectTransCoder} is the default TransCoder used to handle the serialization and deserialization in memcached
 * operations.
 * 
 * @see AbstractTransCoder
 * @see TransCoder
 */
public class ObjectTransCoder extends AbstractTransCoder {

    /*
     * (non-Javadoc)
     * 
     * @see com.schooner.MemCached.TransCoder#decode(InputStream)
     */
    public Object decode(final InputStream input) throws IOException {
        Object obj = null;
        ObjectInputStream ois = new ObjectInputStream(input);
        try {
            obj = ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e.getMessage());
        }
        ois.close();
        return obj;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.schooner.MemCached.AbstractTransCoder#encode(java.io.OutputStream, java.lang.Object)
     */
    @Override
    public void encode(final OutputStream output, final Object object) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(output);
        oos.writeObject(object);
        oos.close();
    }

    /**
     * decode the object from the inputstream with your classloader
     * 
     * @param input inputstream.
     * @param classLoader speicified classloader created by you.
     * @return decoded java object.
     * @throws IOException error happened in decoding the input stream.
     */
    public Object decode(InputStream input, ClassLoader classLoader) throws IOException {
        Object obj = null;
        ContextObjectInputStream ois = new ContextObjectInputStream(input, classLoader);
        try {
            obj = ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e.getMessage());
        }
        ois.close();
        return obj;
    }
}
