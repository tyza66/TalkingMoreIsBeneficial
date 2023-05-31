package com.tyza66.talk.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyza66.talk.service.UserService;
import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.Context;

@Controller
public class UserController {
    @Inject
    private UserService userService;
    @Post
    @Mapping("/login")
    public JSON login(Context ctx) {
        JSONObject end = JSONUtil.createObj();
        String username = ctx.param("username");
        String password = ctx.param("password");
        try {
            boolean login = userService.login(username, password);
            if (login) {
                end.set("status","200");
                end.set("msg","登录成功");
            } else {
                end.set("status","500");
                end.set("msg","登录失败");
            }
        } catch (Exception e) {
            end.set("status","500");
            end.set("msg","登录失败");
        }
        return end;
    }


    //整个get的方法查询一下测一下好不好使
    @Get
    @Mapping("/all")
    public JSON all(){
        JSONObject end = JSONUtil.createObj();
        try {
            end.set("data", userService.all());
        }catch (Exception e) {
            end.set("status","500");
            end.set("msg","获取失败");
        }
        return end;
    }
}
