/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.modules.sys.dao;

import com.scott.dev.common.persistence.TreeDao;
import com.scott.dev.common.persistence.annotation.MyBatisDao;
import com.scott.dev.modules.sys.entity.Office;

/**
 * 机构DAO接口
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {

}
