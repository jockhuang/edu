/**
 * Copyright (c) 2008 Greg Whalin
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the BSD license
 *
 * This library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE.
 *
 * You should have received a copy of the BSD License along with this
 * library.
 *
 * @author greg whalin <greg@meetup.com> 
 */
package com.specl.memcached.test;

import org.apache.log4j.BasicConfigurator;

import com.meetup.memcached.MemcachedClient;
import com.meetup.memcached.SockIOPool;

public class TestMemcached {
    public static void main(String[] args) {
        // memcached should be running on port 11211 but NOT on 11212

        BasicConfigurator.configure();
        // String[] servers = { "192.168.1.1:1624", "192.168.1.1:1625" };
        String[] servers = { "10.0.10.34:12000" };// { "10.0.10.11:12000", "10.0.10.12:12000", "10.0.10.11:12001" };
        // <socketpool name="pool0" failover="true" initConn="5" minConn="5" maxConn="250" maintSleep="5000"
        // nagle="false" socketTO="3000" aliveCheck="true">

        SockIOPool pool = SockIOPool.getInstance();
        pool.setServers(servers);
        pool.setFailover(true);
        pool.setInitConn(5);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaintSleep(5000);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setAliveCheck(true);
        // pool.setHashingAlg(SockIOPool.CONSISTENT_HASH);
        pool.setAliveCheck(true);
        pool.initialize();

        MemcachedClient mcc = new MemcachedClient();
        //
        // // turn off most memcached client logging:
        // com.meetup.memcached.Logger.getLogger( MemcachedClient.class.getName() ).setLevel(
        // com.meetup.memcached.Logger.LEVEL_WARN );
        // com.meetup.memcached.Logger.getLogger( SockIOPool.class.getName() ).setLevel(
        // com.meetup.memcached.Logger.LEVEL_WARN);
        mcc.set("key", "wwwwwwwwwwww");

        long start = System.currentTimeMillis();

        OldClientThread[] cts = new OldClientThread[100];
        for (int i = 0; i < cts.length; i++) {
            cts[i] = new OldClientThread(i, mcc);
        }
        for (OldClientThread clientThread : cts) {
            clientThread.start();
        }

        while (true) {
            boolean done = true;
            for (OldClientThread clientThread : cts) {
                if (clientThread.getState() != Thread.State.TERMINATED) {
                    done = false;
                }
            }
            if (done) {
                break;
            }
        }

        // for(int i=0; i<100; i++){
        // Map m = (HashMap)mcc.get("key");
        // System.out.println("get ="+i);
        // }
        long end = System.currentTimeMillis();
        System.out.println("old take=" + (end - start));
        // for ( int i = 0; i < 1; i++ ) {
        // boolean success = mcc.set( "" + i, "hello, yue" );
        // String result = (String)mcc.get( "" + i );
        // // System.out.println( String.format( "set( %d ): %s", i, success ) );
        // System.out.println( String.format( "get( %d ): %s", i, result ) );
        // // mcc.delete(""+i);
        // }

        // try { Thread.sleep( 60000 ); } catch ( Exception ex ) { }
        // String result = (String)mcc.get( "" + 0 );
        // System.out.println( "get(0) ==="+result);
        //
        // try { Thread.sleep( 60000 ); } catch ( Exception ex ) { }
        // result = (String)mcc.get( "" + 0 );
        // System.out.println( "=====get(0) ==="+result);
        //
        // try { Thread.sleep( 60000 ); } catch ( Exception ex ) { }
        // boolean success = mcc.set( "" + 0, "hello, wangyue-----" );
        // System.out.println( "=====set(0) ==="+success);
        //
        //
        // try { Thread.sleep( 60000 ); } catch ( Exception ex ) { }
        // result = (String)mcc.get( "" + 0 );
        // System.out.println( "=====get(0) ==="+result);

        // System.out.println( "\n\t -- sleeping --\n" );
        // try { Thread.sleep( 10000 ); } catch ( Exception ex ) { }
        //
        // for ( int i = 0; i < 1; i++ ) {
        // boolean success = mcc.set( "" + i, "Hello!" );
        // String result = (String)mcc.get( "" + i );
        // System.out.println( String.format( "set( %d ): %s", i, success ) );
        // System.out.println( String.format( "get( %d ): %s", i, result ) );
        // }
    }
}
