/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scott.dev.common.service.TreeService;
import com.scott.dev.test.dao.TestTreeDao;
import com.scott.dev.test.entity.TestTree;

/**
 * 树结构生成Service
 * 
 * @author ThinkGem
 * @version 2015-04-06
 */
@Service
@Transactional(readOnly = true)
public class TestTreeService extends TreeService<TestTreeDao, TestTree> {

    @Override
    @Transactional(readOnly = false)
    public void delete(TestTree testTree) {
        super.delete(testTree);
    }

    @Override
    public List<TestTree> findList(TestTree testTree) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(testTree.getParentIds())) {
            testTree.setParentIds("," + testTree.getParentIds() + ",");
        }
        return super.findList(testTree);
    }

    @Override
    public TestTree get(String id) {
        return super.get(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(TestTree testTree) {
        super.save(testTree);
    }

}
