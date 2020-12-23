package com.user.service.impl;

import com.user.dto.Users;
import com.user.repository.UserRepository;
import com.user.repository.UserRepositoryIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepositoryImpl implements UserRepositoryIntf {

    @Autowired
    private UserRepository userRepository;

    public Users createUser(Users user) throws Exception {
        Users savedUsers = userRepository.save(user);
        return savedUsers;
    }

    public Users updateUser(Users users) throws Exception {
        return (userRepository.save(users));
    }

    @Override
    public void deleteUser(Users user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<Users> fetchUserDetails(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public Optional<Users> getUser(Users user) {
        return userRepository.findById(user.get_id());
    }

}
