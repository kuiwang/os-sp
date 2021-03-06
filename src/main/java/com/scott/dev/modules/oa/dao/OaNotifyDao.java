/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.modules.oa.dao;

import com.scott.dev.common.persistence.CrudDao;
import com.scott.dev.common.persistence.annotation.MyBatisDao;
import com.scott.dev.modules.oa.entity.OaNotify;

/**
 * 通知通告DAO接口
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface OaNotifyDao extends CrudDao<OaNotify> {

    /**
     * 获取通知数目
     * 
     * @param oaNotify
     * @return
     */
    public Long findCount(OaNotify oaNotify);

}
