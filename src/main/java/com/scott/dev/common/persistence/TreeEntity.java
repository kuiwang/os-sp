/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.common.persistence;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.scott.dev.common.utils.Reflections;

/**
 * 数据Entity类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class TreeEntity<T> extends DataEntity<T> {

    private static final long serialVersionUID = 1L;

    protected String name; // 机构名称

    protected T parent; // 父级编号

    protected String parentIds; // 所有父级编号

    protected Integer sort; // 排序

    public TreeEntity() {
        super();
        this.sort = 30;
    }

    public TreeEntity(String id) {
        super(id);
    }

    @Length(min = 1, max = 100)
    public String getName() {
        return name;
    }

    /**
     * 父对象，只能通过子类实现，父类实现mybatis无法读取
     * 
     * @return
     */
    @JsonBackReference
    @NotNull
    public abstract T getParent();

    public String getParentId() {
        String id = null;
        if (parent != null) {
            id = (String) Reflections.getFieldValue(parent, "id");
        }
        return org.apache.commons.lang3.StringUtils.isNotBlank(id) ? id : "0";
    }

    @Length(min = 1, max = 2000)
    public String getParentIds() {
        return parentIds;
    }

    public Integer getSort() {
        return sort;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 父对象，只能通过子类实现，父类实现mybatis无法读取
     * 
     * @return
     */
    public abstract void setParent(T parent);

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}
