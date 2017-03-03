package cn.chineseall.memcached;

import java.io.IOException;

/**
 * Bridge class to provide nested Exceptions with IOException which has constructors that don't take Throwables.
 * 
 * @author &lt;a href="mailto:burton@rojo.com"&gt;Kevin Burton&lt;/a&gt;
 * @version 1.2
 */
public class NestedIOException extends IOException {

    private static final long serialVersionUID = 305761673292171137L;

    /**
     * Create a new &lt;code&gt;NestedIOException&lt;/code&gt; instance.
     * 
     * @param cause object of type throwable
     */
    public NestedIOException(Throwable cause) {
        super(cause.getMessage());
        super.initCause(cause);
    }

    public NestedIOException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }
}
