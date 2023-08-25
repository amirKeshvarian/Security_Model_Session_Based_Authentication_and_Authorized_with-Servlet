package org.company.project.model.service;

import org.company.project.common.encryption.MD5;
import org.company.project.model.domain.User;
import org.company.project.model.repository.UserDA;

import java.sql.SQLException;

public class UserService {
    private static final UserService USER_SERVICE = new UserService();
    private UserService(){}

    public static UserService getInstance() {
        return USER_SERVICE;
    }
    public void login (User user) throws Exception {
        user.setPassword(MD5.getMD5(user.getPassword()));
        try(UserDA userDA = new UserDA()){
            userDA.selectByUsernameAndPassword(user);
        }
    }
}
