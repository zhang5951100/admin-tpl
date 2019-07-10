package com.yidatec.admin.config;


import com.yidatec.admin.entity.SysRole;
import com.yidatec.admin.entity.SysUser;
import com.yidatec.admin.repository.mybatis.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyCustomUserService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 将用的所有角色存储于用户信息中
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserMapper.findUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }

        //获取所有请求的url
        //List<SysPermission> sysPermissions = sysUserMapper.findPermissionsByUsername(user.getUsername());
        List<SysRole> sysRoles = sysUserMapper.findRolesByUsername(user.getUsername());

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (SysRole sysRole : sysRoles) {
            //封装用户信息和角色信息 到 SecurityContextHolder全局缓存中
            grantedAuthorities.add(new SimpleGrantedAuthority(sysRole.getName()));
        }
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}