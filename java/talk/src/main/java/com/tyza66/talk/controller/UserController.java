package com.tyza66.talk.controller;

import cn.hutool.json.JSON;
import org.noear.snack.core.Context;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;

@Controller
public class UserController {
    @Post
    @Mapping("/login")
    public JSON login(Context ctx) {
        return null;
    }
}
