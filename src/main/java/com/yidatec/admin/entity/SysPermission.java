package com.yidatec.admin.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name = "SYS_PERMISSION")
public class SysPermission implements Serializable {
    private static final long serialVersionUID = 4564404809812171792L;

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "PID")
    private String pid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "URL")
    private String url;

    @Column(name = "DESCRIPTION")
    private String description;
}
