package com.tyza66.talk.service;

import com.tyza66.talk.pojo.User;
import org.noear.solon.annotation.ProxyComponent;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;

import java.sql.SQLException;
import java.util.List;

@ProxyComponent
public class UserService {
    @Db
    DbContext db;

    public boolean login(String username, String password) throws Exception {
        return db.table("user")
                .whereEq("username", username)
                .andEq("password", password)
                .count() > 0;
    }

    public List<User> all() throws SQLException {
        return db.table("user")
                .select("*")
                .getList(User.class);
    }
}
