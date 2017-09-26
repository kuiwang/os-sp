/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.test.dao;

import com.scott.dev.common.persistence.TreeDao;
import com.scott.dev.common.persistence.annotation.MyBatisDao;
import com.scott.dev.test.entity.TestTree;

/**
 * 树结构生成DAO接口
 * 
 * @author ThinkGem
 * @version 2015-04-06
 */
@MyBatisDao
public interface TestTreeDao extends TreeDao<TestTree> {

}
