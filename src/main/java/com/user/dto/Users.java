package com.user.dto;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Document(collection = "users")
public class Users {
    @Id
    @ApiModelProperty(notes = "The database generated property")
    private String _id;
    @ApiModelProperty(notes = "Name of the user")
    private String name;
    @ApiModelProperty(notes = "Login username of the user")
    private String userName;
    @ApiModelProperty(notes = "email id of the user")
    private String email;
    @ApiModelProperty(notes = "Login password of the user")
    private String password;
    @ApiModelProperty(notes = "Role assigned to the user")
    private Role role;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(name, users.name) && Objects.equals(userName, users.userName) && Objects.equals(email, users.email) && Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userName, email, password);
    }

//    @Override
//    public String toString() {
//        return "User [Id=" + _id +
//                ", name=" + name +
//                ", username=" + userName +
//                ", email=" + email +
//                ", password=" + password +
//                ", role =[role=" + role +
//                ", permissionList="
//                "]";
//    }
}
