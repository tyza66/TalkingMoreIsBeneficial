package com.tyza66.talk.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyza66.talk.pojo.User;
import com.tyza66.talk.service.UserService;
import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.Context;

@Controller
public class UserController {
    @Inject
    private UserService userService;
    @Post
    @Mapping("/login")
    public JSON login(@Body User user,Context ctx) {
        JSONObject end = JSONUtil.createObj();
        //拿到post请求参数
        String username = user.getUsername();
        String password = user.getPassword();
        try {
            boolean login = userService.login(username, password);
            if (login) {
                StpUtil.login(96);
                end.set("status","200");
                end.set("msg","登录成功");
            } else {
                end.set("status","500");
                end.set("msg","登录失败");
            }
        } catch (Exception e) {
            end.set("status","501");
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

    @Get
    @Mapping("/logined")
    public JSON logined(){
        JSONObject end = JSONUtil.createObj();
        boolean all = StpUtil.hasPermission("all");
        if (all) {
            end.set("status","200");
            end.set("msg","已登录");
        } else {
            end.set("status","500");
            end.set("msg","未登录");
        }
        return end;
    }
}
