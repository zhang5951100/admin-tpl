package com.yidatec.admin.repository.mybatis;

import com.github.pagehelper.Page;
import com.yidatec.admin.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    Page<SysUser> findSysUsers();
}
