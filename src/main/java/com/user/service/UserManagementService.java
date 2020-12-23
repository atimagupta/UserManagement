package com.user.service;


import com.user.dto.Role;
import com.user.dto.Users;
import org.springframework.http.ResponseEntity;

public interface UserManagementService {
    Users createUser(Users user) throws Exception;
    Users updateUserDetails(Users user) throws Exception;
    void deleteUser(Users user) throws Exception;
    Users fetchUserDetails(String userName) throws Exception;
    void updatePassword(String password, String userName) throws Exception;
    ResponseEntity login(String userName, String password);
    Users createPermission(String userName, Role role) throws Exception;
}
