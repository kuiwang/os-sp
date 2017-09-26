/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.modules.sys.dao;

import com.scott.dev.common.persistence.CrudDao;
import com.scott.dev.common.persistence.annotation.MyBatisDao;
import com.scott.dev.modules.sys.entity.Role;

/**
 * 角色DAO接口
 * 
 * @author ThinkGem
 * @version 2013-12-05
 */
@MyBatisDao
public interface RoleDao extends CrudDao<Role> {

    /**
     * 维护角色与菜单权限关系
     * 
     * @param role
     * @return
     */
    public int deleteRoleMenu(Role role);

    /**
     * 维护角色与公司部门关系
     * 
     * @param role
     * @return
     */
    public int deleteRoleOffice(Role role);

    public Role getByEnname(Role role);

    public Role getByName(Role role);

    public int insertRoleMenu(Role role);

    public int insertRoleOffice(Role role);

}
