/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.common.supcan.common.properties;

import com.scott.dev.common.supcan.annotation.common.properties.SupBackground;
import com.scott.dev.common.utils.ObjectUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 硕正TreeList Properties Background
 * 
 * @author WangZhen
 * @version 2013-11-04
 */
@XStreamAlias("Background")
public class Background {

    /**
     * 背景颜色
     */
    @XStreamAsAttribute
    private String bgColor = "#FDFDFD";

    public Background() {

    }

    public Background(String bgColor) {
        this();
        this.bgColor = bgColor;
    }

    public Background(SupBackground supBackground) {
        this();
        ObjectUtils.annotationToObject(supBackground, this);
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
}
