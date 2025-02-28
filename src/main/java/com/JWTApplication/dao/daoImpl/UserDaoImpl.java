package com.JWTApplication.dao.daoImpl;

import com.JWTApplication.Model.UserDetailsV1;
import com.JWTApplication.dao.UserDao;
import com.JWTApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetailsV1 addUser(UserDetailsV1 userDetails) {
        return repository.save(userDetails);
    }

    @Override
    public UserDetailsV1 updateUser(UserDetailsV1 userDetails) {
        return repository.save(userDetails);
    }

    @Override
    public int deleteUser(int userId) {
        return repository.deleteUser(userId);
    }

    @Override
    public int activate(int userId) {
        return repository.activateUser(userId);
    }

    @Override
    public List<Map<String, Object>> getUserDetails() {
        return repository.getUserDetails();
    }

    @Override
    public int updatePassword(int userId, String oldPassword, String newPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String matcher = repository.getOldPassword(userId);
        return !passwordEncoder.matches(oldPassword, matcher) ? -1 : repository.updatePassword(userId, passwordEncoder.encode(newPassword));
    }
}
