/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.modules.sys.dao;

import java.util.List;

import com.scott.dev.common.persistence.CrudDao;
import com.scott.dev.common.persistence.annotation.MyBatisDao;
import com.scott.dev.modules.sys.entity.User;

/**
 * 用户DAO接口
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface UserDao extends CrudDao<User> {

    /**
     * 删除用户角色关联数据
     * 
     * @param user
     * @return
     */
    public int deleteUserRole(User user);

    /**
     * 查询全部用户数目
     * 
     * @return
     */
    public long findAllCount(User user);

    /**
     * 通过OfficeId获取用户列表，仅返回用户id和name（树查询用户时用）
     * 
     * @param user
     * @return
     */
    public List<User> findUserByOfficeId(User user);

    /**
     * 根据登录名称查询用户
     * 
     * @param loginName
     * @return
     */
    public User getByLoginName(User user);

    /**
     * 插入用户角色关联数据
     * 
     * @param user
     * @return
     */
    public int insertUserRole(User user);

    /**
     * 更新登录信息，如：登录IP、登录时间
     * 
     * @param user
     * @return
     */
    public int updateLoginInfo(User user);

    /**
     * 更新用户密码
     * 
     * @param user
     * @return
     */
    public int updatePasswordById(User user);

    /**
     * 更新用户信息
     * 
     * @param user
     * @return
     */
    public int updateUserInfo(User user);

}