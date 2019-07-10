package com.yidatec.admin.repository.mybatis;


import com.yidatec.admin.entity.SysPermission;
import com.yidatec.admin.entity.SysRole;
import com.yidatec.admin.entity.SysRolePermisson;
import com.yidatec.admin.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {

    /**
     * 通过username查找 user
     * username是唯一的前提
     *
     * @param username
     * @return SysUser
     */
    SysUser findUserByUsername(String username);

    /**
     * 通过用户名 查找·
     * @param username
     * @return List<SysRole>
     */
    List<SysRole> findRolesByUsername(String username);

    /**
     * 通过用户名 查找权限
     * @param username
     * @return List<SysPermission>
     */
    List<SysPermission> findPermissionsByUsername(String username);

    List<SysRolePermisson> findAllRolePermissoin();
}
