package com.JWTApplication.repository;

import com.JWTApplication.Model.UserDetailsV1;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<UserDetailsV1, Integer> {

    @Query(value = "SELECT u.*, r.role_code FROM users u LEFT JOIN role_master r ON u.role_id = r.role_id WHERE u.username = :username", nativeQuery = true)
    Map<String, Object> findByEmail(@Param("username") String username);

    @Query(value = "select u,r.roleName from users u left join role_master r on u.roleId=r.roleId order by u.createdOn desc", nativeQuery = true)
    List<Map<String, Object>> getUserDetails();

    @Modifying
    @Transactional
    @Query("UPDATE users u SET u.isDeleted = true, u.deletedOn = CURRENT_TIMESTAMP WHERE u.id = :userId")
    int deleteUser(int userId);

    @Modifying
    @Transactional
    @Query("UPDATE users u SET u.isDeleted = false WHERE u.id = :userId")
    int activateUser(@Param("userId") int userId);

    @Modifying
    @Transactional
    @Query("UPDATE users u SET u.password = :passWord WHERE u.id = :userId")
    int updatePassword(@Param("userId") int userId, @Param("passWord") String passWord);

    @Query(value = "SELECT password FROM users WHERE user_id = :userId", nativeQuery = true)
    String getOldPassword(@Param("userId") int userId);

}
