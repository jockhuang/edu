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

public class MemcachedIncr {
    public static void main(String[] args) {
        // memcached should be running on port 11211 but NOT on 11212

        BasicConfigurator.configure();
        // String[] servers = { "192.168.1.1:1624", "192.168.1.1:1625" };
        String[] servers = { "192.168.0.48:11211","192.168.0.49:11211" };// { "10.0.10.11:12000", "10.0.10.12:12000", "10.0.10.11:12001" };
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
        //mcc.getCounter(key)
        String key = "cn.chineseall.model.org.OrgTree_accessCount_89843";
        //mcc.delete(key);
       mcc.addOrIncr(key,1L);
       // System.out.println("dd"+mcc.get("abc"));
       // System.out.println("cc"+mcc.getCounter("abc"));
        System.out.println(mcc.getCounter(key));
        //System.out.println(mcc.incr("cn.chineseall.model.org.OrgTree_accessCount_2",1L));
//        System.out.println(mcc.addOrIncr("cn.chineseall.model.org.OrgTree_accessCount_2",1L));
    }
}
