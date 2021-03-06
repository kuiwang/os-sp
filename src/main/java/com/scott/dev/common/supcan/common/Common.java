/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.common.supcan.common;

import java.util.List;

import com.google.common.collect.Lists;
import com.scott.dev.common.supcan.common.fonts.Font;
import com.scott.dev.common.supcan.common.properties.Properties;
import com.scott.dev.common.utils.IdGen;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 硕正Common
 * 
 * @author WangZhen
 * @version 2013-11-04
 */
public class Common {

    /**
     * 字体对象
     */
    @XStreamAlias("Fonts")
    protected List<Font> fonts;

    /**
     * 属性对象
     */
    @XStreamAlias("Properties")
    protected Properties properties;

    public Common() {
        properties = new Properties(IdGen.uuid());
        fonts = Lists.newArrayList(new Font("宋体", "134", "-12"),
                new Font("宋体", "134", "-13", "700"));
    }

    public Common(Properties properties) {
        this();
        this.properties = properties;
    }

    public List<Font> getFonts() {
        return fonts;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setFonts(List<Font> fonts) {
        this.fonts = fonts;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
