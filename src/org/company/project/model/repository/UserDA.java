package org.company.project.model.repository;

import org.company.project.common.exception.InvalidUsernameOrPassword;
import org.company.project.common.jndi.ConnectionProvider;
import org.company.project.model.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public UserDA () throws SQLException {
        connection = ConnectionProvider.getConnection();
    }
    public void selectByUsernameAndPassword (User user) throws SQLException, InvalidUsernameOrPassword {
        preparedStatement = connection
                .prepareStatement("select * from users where lower(username)=lower(?) and password=?");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> roles = new ArrayList<>();
        boolean flag = false;
        while (resultSet.next()) {
            roles.add(resultSet.getString("role_name"));
            flag = true;
        }
        user.setRoleName(roles);
        if (!flag)
            throw new InvalidUsernameOrPassword();
    }
    @Override
    public void close() throws Exception {
        connection.close();
    }
}
