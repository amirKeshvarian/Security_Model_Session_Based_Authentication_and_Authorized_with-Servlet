package org.company.project.model.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    public String username;
    public String password;
    public List<String> roleName;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<String> getRoleName() {
        return roleName;
    }

    public User setRoleName(List<String> roleName) {
        this.roleName = roleName;
        return this;
    }
}
