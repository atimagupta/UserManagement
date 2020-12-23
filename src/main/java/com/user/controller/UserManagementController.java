package com.user.controller;

import com.user.domain.Roles;
import com.user.dto.Role;
import com.user.dto.Users;
import com.user.service.UserManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value="userManagement", tags="Identity management Apis")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @ApiOperation(value = "create a user", response=ResponseEntity.class)
    @ApiResponses(value = {@ApiResponse(code=200,message="Successful"),
                           @ApiResponse(code=500,message="Internal Server Error"),
                           @ApiResponse(code=404,message="Not Found")
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody Users user) {

        Users newUser = new Users();
        try {
            newUser = userManagementService.createUser(user);
        } catch (Exception e) {
            return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(newUser, HttpStatus.OK);
    }

    @ApiOperation(value = "Update a user", response=ResponseEntity.class)
    @ApiResponses(value = {@ApiResponse(code=200,message="Successful"),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Not Found")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity updateUser(@RequestBody Users user) {

        Users updatedUser = new Users();
        try {
            updatedUser = userManagementService.updateUserDetails(user);
        } catch (Exception e) {
            return new ResponseEntity<>(updatedUser, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(updatedUser, HttpStatus.OK);
    }

    @ApiOperation(value = "Update Password for a user", response=ResponseEntity.class)
    @ApiResponses(value = {@ApiResponse(code=200,message="Successful"),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Not Found")
    })
    @RequestMapping(value = "/updatePassword/{userName}", method = RequestMethod.POST)
    public ResponseEntity updateUser(@RequestBody String password, @PathVariable String userName) {

        try {
            userManagementService.updatePassword(password,userName);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch user details", response=ResponseEntity.class)
    @ApiResponses(value = {@ApiResponse(code=200,message="Successful"),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Not Found")
    })
    @RequestMapping(value = "/read/{userName}", method = RequestMethod.GET)
    public ResponseEntity fetchUser(@PathVariable String userName) {

        Users user = new Users();
        try {
            user = userManagementService.fetchUserDetails(userName);
        } catch (Exception e) {
            return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a user", response=ResponseEntity.class)
    @ApiResponses(value = {@ApiResponse(code=200,message="Successful"),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Not Found")
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@RequestBody Users user) {
        try {
            userManagementService.deleteUser(user);
        } catch (Exception e) {
            return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @ApiOperation(value = "Login", response=ResponseEntity.class)
    @ApiResponses(value = {@ApiResponse(code=200,message="Successful"),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Not Found"),
            @ApiResponse(code=403,message="Unauthorized user")
    })
    @RequestMapping(value = "/login/{userName}", method = RequestMethod.POST)
    public ResponseEntity login(@PathVariable String userName, @RequestBody String password) {
        try {
             return userManagementService.login(userName, password);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "add permission for a user", response=ResponseEntity.class)
    @ApiResponses(value = {@ApiResponse(code=200,message="Successful"),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Not Found")
    })
    @RequestMapping(value = "/addPermission/{userName}", method = RequestMethod.POST)
    public ResponseEntity addPermission(@PathVariable String userName, @RequestBody Role role) {
        Users newUser = new Users();
        try {
            newUser = userManagementService.createPermission(userName,role);
        } catch (Exception e) {
           return new ResponseEntity<>(userName, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(newUser, HttpStatus.OK);
    }


}
