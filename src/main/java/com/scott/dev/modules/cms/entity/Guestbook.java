/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.modules.cms.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.scott.dev.common.persistence.DataEntity;
import com.scott.dev.common.utils.IdGen;
import com.scott.dev.modules.sys.entity.User;

/**
 * 留言Entity
 * 
 * @author ThinkGem
 * @version 2013-05-15
 */
public class Guestbook extends DataEntity<Guestbook> {

    private static final long serialVersionUID = 1L;

    private String content; // 留言内容

    private Date createDate;// 留言时间

    private String delFlag; // 删除标记删除标记（0：正常；1：删除；2：审核）

    private String email; // 邮箱

    private String ip; // 留言IP

    private String name; // 姓名

    private String phone; // 电话

    private String reContent;// 回复内容

    private Date reDate; // 回复时间

    private User reUser; // 回复人

    private String type; // 留言分类（咨询、建议、投诉、其它）

    private String workunit;// 单位

    public Guestbook() {
        this.delFlag = DEL_FLAG_AUDIT;
    }

    public Guestbook(String id) {
        this();
        this.id = id;
    }

    @Length(min = 1, max = 2000)
    public String getContent() {
        return content;
    }

    @Override
    @NotNull
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    @Length(min = 1, max = 1)
    public String getDelFlag() {
        return delFlag;
    }

    @Email
    @Length(min = 0, max = 100)
    public String getEmail() {
        return email;
    }

    @Length(min = 1, max = 100)
    public String getIp() {
        return ip;
    }

    @Length(min = 1, max = 100)
    public String getName() {
        return name;
    }

    @Length(min = 0, max = 100)
    public String getPhone() {
        return phone;
    }

    public String getReContent() {
        return reContent;
    }

    public Date getReDate() {
        return reDate;
    }

    public User getReUser() {
        return reUser;
    }

    @Length(min = 1, max = 100)
    public String getType() {
        return type;
    }

    @Length(min = 0, max = 100)
    public String getWorkunit() {
        return workunit;
    }

    public void prePersist() {
        this.id = IdGen.uuid();
        this.createDate = new Date();
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setReContent(String reContent) {
        this.reContent = reContent;
    }

    public void setReDate(Date reDate) {
        this.reDate = reDate;
    }

    public void setReUser(User reUser) {
        this.reUser = reUser;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit;
    }

}
