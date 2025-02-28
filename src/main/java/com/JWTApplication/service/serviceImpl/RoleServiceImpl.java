package com.JWTApplication.service.serviceImpl;

import com.JWTApplication.Model.RoleMaster;
import com.JWTApplication.repository.RoleMasterRepository;
import com.JWTApplication.response.GenericResponse;
import com.JWTApplication.service.RoleService;
import com.JWTApplication.util.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleServiceImpl implements RoleService {
    private static final Logger logger = LogManager.getLogger(RoleServiceImpl.class);

    @Autowired
    RoleMasterRepository repository;

    @Override
    public GenericResponse addRole(RoleMaster roleMaster) {
        GenericResponse response = new GenericResponse();
        RoleMaster result = repository.save(roleMaster);
        response.setMessage(Constant.RESPONSE_MESSAGES.CREATED);
        response.setStatusCode(Constant.RESPONSE_CODE.CREATED);
        response.setData(result);
        response.setSuccess(Constant.TRUE);
        logger.info("Response :: {}", response.toString());
        return response;
    }

    @Override
    public GenericResponse updateRole(RoleMaster roleMaster) {
        GenericResponse response = new GenericResponse();
        RoleMaster result = repository.save(roleMaster);
        response.setMessage(Constant.RESPONSE_MESSAGES.UPDATION);
        response.setStatusCode(Constant.RESPONSE_CODE.CREATED);
        response.setData(result);
        response.setSuccess(Constant.TRUE);
        logger.info("Response :: {}", response.toString());
        return response;
    }

    @Override
    public GenericResponse deleteRole(int roleId) {
        int result = repository.deleteRole(roleId);
        GenericResponse response = new GenericResponse();
        if (result > 0) {
            response.setStatusCode(Constant.RESPONSE_CODE.SUCCESS);
            response.setMessage(Constant.RESPONSE_MESSAGES.SUCCESS_DELETE);
            response.setSuccess(Constant.TRUE);
        } else {
            response.setStatusCode(Constant.RESPONSE_CODE.BAD_REQUEST);
            response.setMessage("Default Roles Can not be Deleted");
            response.setSuccess(Constant.FALSE);
        }
        logger.info("Response :: {}",response.toString());
        return response;
    }

    @Override
    public GenericResponse getAllRoles() {
        List<RoleMaster> roles = repository.getAllRoles();
        GenericResponse response = new GenericResponse();
        response.setStatusCode(Constant.RESPONSE_CODE.SUCCESS);
        response.setMessage(Constant.RESPONSE_MESSAGES.SUCCESS);
        response.setData(roles);
        response.setSuccess(Constant.TRUE);
        logger.info("Response :: {}",response.toString());
        return response;
    }

}
