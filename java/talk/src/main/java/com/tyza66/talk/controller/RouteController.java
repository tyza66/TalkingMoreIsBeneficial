package com.tyza66.talk.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;

/**
 * Author: tyza66
 * Date: 2023/05/31 7:44
 * Github: https://github.com/tyza66
 **/
@Controller
public class RouteController {
    @Get
    @Mapping("/hello")
    public String hello(){
        return "Hello,World!";
    }
}
