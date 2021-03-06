/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.modules.gen.dao;

import com.scott.dev.common.persistence.CrudDao;
import com.scott.dev.common.persistence.annotation.MyBatisDao;
import com.scott.dev.modules.gen.entity.GenTable;

/**
 * 业务表DAO接口
 * 
 * @author ThinkGem
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTableDao extends CrudDao<GenTable> {

}
