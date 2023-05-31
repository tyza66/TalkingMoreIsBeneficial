package com.tyza66.talk.service;

import org.noear.solon.annotation.ProxyComponent;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;

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
}
