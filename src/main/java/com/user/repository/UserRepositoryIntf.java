package com.user.repository;


import com.user.dto.Users;
import java.util.Optional;

public interface UserRepositoryIntf {
    Users createUser(Users user) throws Exception;
    Users updateUser(Users user) throws Exception;
    void deleteUser(Users user);
    Optional<Users> fetchUserDetails(String userName);
    Optional<Users> getUser(Users user);

}
