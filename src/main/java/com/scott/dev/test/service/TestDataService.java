/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scott.dev.common.persistence.Page;
import com.scott.dev.common.service.CrudService;
import com.scott.dev.test.dao.TestDataDao;
import com.scott.dev.test.entity.TestData;

/**
 * 单表生成Service
 * 
 * @author ThinkGem
 * @version 2015-04-06
 */
@Service
@Transactional(readOnly = true)
public class TestDataService extends CrudService<TestDataDao, TestData> {

    @Override
    @Transactional(readOnly = false)
    public void delete(TestData testData) {
        super.delete(testData);
    }

    @Override
    public List<TestData> findList(TestData testData) {
        return super.findList(testData);
    }

    @Override
    public Page<TestData> findPage(Page<TestData> page, TestData testData) {
        return super.findPage(page, testData);
    }

    @Override
    public TestData get(String id) {
        return super.get(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(TestData testData) {
        super.save(testData);
    }

}
