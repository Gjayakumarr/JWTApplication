package com.JWTApplication.repository;

import com.JWTApplication.Model.RoleMaster;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleMasterRepository extends JpaRepository<RoleMaster, Integer> {

    @Query(value = "SELECT * FROM role_master", nativeQuery = true)
    List<RoleMaster> getAllRoles();

    @Modifying
    @Transactional
    @Query(value = "UPDATE role_master SET is_deleted = true, deleted_on = CURRENT_TIMESTAMP WHERE role_id = :roleId AND is_default=0", nativeQuery = true)
    int deleteRole(@Param("roleId") int roleId);
}
