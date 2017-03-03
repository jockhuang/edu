package cn.chineseall.utils;

import ch.qos.logback.classic.html.HTMLLayout;

public class ChineseallLayout extends HTMLLayout {

    public ChineseallLayout() {
        super.getDefaultConverterMap().put("ip", IpConvert.class.getName());
    }

}
