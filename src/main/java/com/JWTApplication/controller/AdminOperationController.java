package com.JWTApplication.controller;

import com.JWTApplication.Model.RoleMaster;
import com.JWTApplication.Model.UserDetailsV1;
import com.JWTApplication.response.GenericResponse;
import com.JWTApplication.response.UserResponse;
import com.JWTApplication.service.RoleService;
import com.JWTApplication.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@RestController
public class AdminOperationController {
    private static final Logger logger = LogManager.getLogger(AdminOperationController.class);


    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public AdminOperationController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("/addUser")
    public UserResponse addUser(@RequestBody UserDetailsV1 userDetails) {
        logger.info("AdminOperationController /addUser api call with : {}", userDetails.toString());
        return userService.addUser(userDetails);
    }

    @PostMapping("/updateUser")
    public UserResponse updateUser(@RequestBody UserDetailsV1 userDetails) {
        logger.info("AdminOperationController /updateUser api call with : {}", userDetails.toString());
        return userService.updateUser(userDetails);
    }

    @PostMapping("/deactivate/{userId}")
    public UserResponse deActivateUser(@PathVariable int userId) {
        logger.info("AdminOperationController /deactivate api call with : {}", userId);
        return userService.deActivate(userId);
    }

    @PostMapping("/activate/{userId}")
    public UserResponse activateUser(@PathVariable int userId) {
        logger.info("AdminOperationController /activate api call with : {}", userId);
        return userService.activate(userId);
    }

    @GetMapping("/details")
    public UserResponse getUserDetails() {
        logger.info("AdminOperationController /deleteUser api call");
        return userService.getUserDetails();
    }

    @PostMapping("/addRole")
    public GenericResponse addRole(@RequestBody RoleMaster roleMaster) {
        logger.info("AdminOperationController /addRole api call with : {}", roleMaster.toString());
        return roleService.addRole(roleMaster);
    }

    @PostMapping("/updateRole")
    public GenericResponse updateRole(@RequestBody RoleMaster roleMaster) {
        logger.info("AdminOperationController /updateRole api call with : {}", roleMaster.toString());
        return roleService.updateRole(roleMaster);
    }

    @PostMapping("/deleteRole/{roleId}")
    public GenericResponse deleteRole(@PathVariable int roleId) {
        logger.info("AdminOperationController /deleteRole api call with : {}", roleId);
        return roleService.deleteRole(roleId);
    }

    @GetMapping("/allRoles")
    public GenericResponse getAllRoles() {
        logger.info("AdminOperationController /allRoles api call");
        return roleService.getAllRoles();
    }

}
