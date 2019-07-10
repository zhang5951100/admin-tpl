package com.yidatec.admin.repository;

import com.yidatec.admin.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, String> {

    SysUser findByUsername(String username);
}
