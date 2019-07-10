package com.yidatec.admin.service;


import com.github.pagehelper.Page;
import com.yidatec.admin.entity.SysUser;
import com.yidatec.admin.repository.SysRoleRepository;
import com.yidatec.admin.repository.SysUserRepository;
import com.yidatec.admin.repository.mybatis.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Page<SysUser> findAllSysUsers() {
        return adminMapper.findSysUsers();
    }
}
