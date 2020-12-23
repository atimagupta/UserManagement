package com.user.service.impl;

import com.user.dto.Role;
import com.user.dto.Users;
import com.user.repository.UserRepositoryIntf;
import com.user.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    private UserRepositoryIntf userRepositoryIntf;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Users createUser(Users user) throws Exception {
        Users newUser = new Users();
        newUser.setEmail(user.getEmail());
        newUser.setUserName(user.getUserName());
        newUser.setName(user.getName());
        newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Role role = new Role();
        role.setRole(user.getRole().getRole());
        role.setPermissionList(new ArrayList<>(user.getRole().getPermissionList()));
        newUser.setRole(role);
        return userRepositoryIntf.createUser(newUser);
    }

    @Override
    public Users updateUserDetails(Users user) throws Exception {
        Optional<Users> obj = userRepositoryIntf.getUser(user);
        if (obj.isPresent()) {
            Users storedUser = obj.get();
            storedUser.setEmail(user.getEmail());
            storedUser.setUserName(user.getUserName());
            storedUser.setName(user.getName());
            Role role = new Role();
            role.setRole(user.getRole().getRole());
            role.setPermissionList(new ArrayList<>(user.getRole().getPermissionList()));
            storedUser.setRole(role);
            return userRepositoryIntf.updateUser(storedUser);
        }
        return user;
    }

    @Override
    public void deleteUser(Users user) throws Exception {
        userRepositoryIntf.deleteUser(user);
    }

    @Override
    public Users fetchUserDetails(String userName) throws Exception {
        Optional<Users> obj = userRepositoryIntf.fetchUserDetails(userName);
        if (obj.isPresent())
            return obj.get();
        return new Users();
    }

    public void updatePassword(String password, String userName) throws Exception {
        Optional<Users> obj = userRepositoryIntf.fetchUserDetails(userName);
        if (obj.isPresent()) {
            Users storedUser = obj.get();
            storedUser.setPassword(bCryptPasswordEncoder.encode(password));
            userRepositoryIntf.updateUser(storedUser);
        }
    }

    public ResponseEntity login(String userName, String password) {
        Optional<Users> obj = userRepositoryIntf.fetchUserDetails(userName);
        if (obj.isPresent()) {
            Users storedUSer = obj.get();
             return bCryptPasswordEncoder.matches(password, storedUSer.getPassword())?
                     new ResponseEntity<>(HttpStatus.OK):
                     new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }


    @Override
    public Users createPermission(String userName, Role role) throws Exception {
        Optional<Users> obj = userRepositoryIntf.fetchUserDetails(userName);
        if (obj.isPresent()) {
            Users storedUser = obj.get();
            Role newRole = new Role();
            newRole.setRole(role.getRole());
            newRole.setPermissionList(new ArrayList<>(role.getPermissionList()));
            storedUser.setRole(newRole);
            return userRepositoryIntf.updateUser(storedUser);
        }
        return new Users();
    }
}
