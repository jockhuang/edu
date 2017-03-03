package com.specl.memcached.test;

import com.meetup.memcached.MemcachedClient;

public class OldClientThread extends Thread {
    private int no;
    private MemcachedClient mcc;

    public OldClientThread(int no, MemcachedClient mcc) {
        this.no = no;
        this.mcc = mcc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            // Map m = (HashMap)cache.get("key");
            String ss = (String) mcc.get("key");
            System.out.println("thread-" + no + ", read=" + i + ",ss=" + ss);
            // System.out.println("thread-"+no+", read ");
        }
        // System.out.println("old read from cache finish--"+no);
    }

}
