package com.user.dto;

import com.user.domain.Permissions;
import io.swagger.annotations.ApiModelProperty;

//@Document(collection = "permission")
public class Permission {

    @ApiModelProperty(notes="Type of permission")
    private Permissions permission;

    public Permissions getPermission() {
        return permission;
    }
    public void setPermission(Permissions permission) {
        this.permission = permission;
    }
}
