package com.yidatec.admin.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity(name = "SYS_USER")
public class SysUser implements UserDetails, Serializable {

    private static final long serialVersionUID = -2476551158093701699L;

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    /**
     * 状态: 0: 启用, 1: 禁止
     */
    @Column(name = "STATUS")
    private Integer status = 0;

    @ManyToMany
    @JoinTable(name = "SYS_USER_ROLE", joinColumns = @JoinColumn(name = "SYS_USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "SYS_ROLE_ID", referencedColumnName = "ID"))
    private List<SysRole> sysRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SysPermission> sysPermissions = new ArrayList<>();

        sysRoles.forEach(r -> sysPermissions.addAll(r.getPermissions()));

        LinkedHashSet<SysPermission> set = new LinkedHashSet<>(sysPermissions.size());
        set.addAll(sysPermissions);
        sysPermissions.clear();
        sysPermissions.addAll(set);

        return sysPermissions;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
