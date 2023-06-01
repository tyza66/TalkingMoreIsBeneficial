package com.tyza66.talk.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;

/**
 * Author: tyza66
 * Date: 2023/05/31 7:44
 * Github: https://github.com/tyza66
 **/
@Controller
public class RouteController {
    @Get
    @Mapping("/")
    public void index(Context ctx){
        boolean login = StpUtil.isLogin();
        if(login){
            ctx.redirect("./index.html");
        }else{
            ctx.redirect("./login.html");
        }

    }

    @Get
    @Mapping("/hello")
    public String hello(){
        return "Hello,World!";
    }
}
