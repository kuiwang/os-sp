/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.test.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.scott.dev.common.persistence.TreeEntity;

/**
 * 树结构生成Entity
 * 
 * @author ThinkGem
 * @version 2015-04-06
 */
public class TestTree extends TreeEntity<TestTree> {

    private static final long serialVersionUID = 1L;

    private String name; // 名称

    private TestTree parent; // 父级编号

    private String parentIds; // 所有父级编号

    private Integer sort; // 排序

    public TestTree() {
        super();
    }

    public TestTree(String id) {
        super(id);
    }

    @Override
    @Length(min = 1, max = 100, message = "名称长度必须介于 1 和 100 之间")
    public String getName() {
        return name;
    }

    @Override
    @JsonBackReference
    @NotNull(message = "父级编号不能为空")
    public TestTree getParent() {
        return parent;
    }

    @Override
    public String getParentId() {
        return (parent != null) && (parent.getId() != null) ? parent.getId() : "0";
    }

    @Override
    @Length(min = 1, max = 2000, message = "所有父级编号长度必须介于 1 和 2000 之间")
    public String getParentIds() {
        return parentIds;
    }

    @Override
    @NotNull(message = "排序不能为空")
    public Integer getSort() {
        return sort;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setParent(TestTree parent) {
        this.parent = parent;
    }

    @Override
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Override
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
