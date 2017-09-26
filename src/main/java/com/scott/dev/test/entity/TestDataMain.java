/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.test.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.scott.dev.common.persistence.DataEntity;
import com.scott.dev.modules.sys.entity.Area;
import com.scott.dev.modules.sys.entity.Office;
import com.scott.dev.modules.sys.entity.User;

/**
 * 主子表生成Entity
 * 
 * @author ThinkGem
 * @version 2015-04-06
 */
public class TestDataMain extends DataEntity<TestDataMain> {

    private static final long serialVersionUID = 1L;

    private Area area; // 归属区域

    private Date inDate; // 加入日期

    private String name; // 名称

    private Office office; // 归属部门

    private String sex; // 性别

    private List<TestDataChild> testDataChildList = Lists.newArrayList(); // 子表列表

    private User user; // 归属用户

    public TestDataMain() {
        super();
    }

    public TestDataMain(String id) {
        super(id);
    }

    public Area getArea() {
        return area;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getInDate() {
        return inDate;
    }

    @Length(min = 0, max = 100, message = "名称长度必须介于 0 和 100 之间")
    public String getName() {
        return name;
    }

    public Office getOffice() {
        return office;
    }

    @Length(min = 0, max = 1, message = "性别长度必须介于 0 和 1 之间")
    public String getSex() {
        return sex;
    }

    public List<TestDataChild> getTestDataChildList() {
        return testDataChildList;
    }

    public User getUser() {
        return user;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTestDataChildList(List<TestDataChild> testDataChildList) {
        this.testDataChildList = testDataChildList;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
