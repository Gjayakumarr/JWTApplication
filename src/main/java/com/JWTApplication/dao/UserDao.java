package com.JWTApplication.dao;

import com.JWTApplication.Model.UserDetailsV1;
import com.JWTApplication.response.UserResponse;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public UserDetailsV1 addUser(UserDetailsV1 userDetails);

    public UserDetailsV1 updateUser(UserDetailsV1 userDetails);

    public int deleteUser(int userId);

    public int activate(int userId);

    public List<Map<String, Object>> getUserDetails();

    public int updatePassword(String username, String oldPassword, String newPassword);

    public String forgotPassword(String username);
}
