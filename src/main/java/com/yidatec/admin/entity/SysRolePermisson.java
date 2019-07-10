package com.yidatec.admin.entity;

import lombok.Data;

@Data
public class SysRolePermisson {
    //角色
    private String roleId;
    private String roleName;

    //权限
    private String permissionId;
    private String url;
}
