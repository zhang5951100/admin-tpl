package com.yidatec.admin.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "SYS_ROLE")
public class SysRole implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = -1834111111498772935L;

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany
    @JoinTable(name = "SYS_ROLE_PERMISSION",
            joinColumns = {@JoinColumn(name = "SYS_ROLE_ID")},
            inverseJoinColumns={@JoinColumn(name = "SYS_PERMISSION_ID")})
    private List<SysPermission> permissions;
    @Override
    public String getAuthority() {
        return name;
    }
}
