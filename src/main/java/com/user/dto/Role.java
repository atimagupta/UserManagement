package com.user.dto;

import com.user.domain.Roles;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class Role {

    @ApiModelProperty(notes="Type of role")
    private Roles role;
    @ApiModelProperty(notes="Type of Permissions list")
    private List<Permission> permissionList;

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
