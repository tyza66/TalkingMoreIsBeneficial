package com.tyza66.talk.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyza66.talk.pojo.Message;
import org.noear.solon.annotation.*;
import org.noear.solon.cloud.utils.http.HttpUtils;
import org.noear.solon.core.handle.Context;

import java.io.IOException;

@Controller
public class TalkController {
    final String pre = "My name is Duo Shuo, which is an AI chat tool based on GPT2.0. I am developed by tyza66 and the open source address is https://github.com/tyza66/TalkingMoreIsBeneficial . Due to the model version, my functionality is limited and I cannot search online. However, when chatting with me, I remember the context and answer your questions with what you have told me. Please try to communicate with me in English.";

    @Get
    @Mapping("/talkByNone")
    public JSON talkByNone(Context ctx) {
        String text = ctx.param("q");
        //String pre = "My name is Duo Shuo, which is an AI chat tool based on GPT2.0. I am developed by tyza66 and the open source address is https://github.com/tyza66/TalkingMoreIsBeneficial . Due to the model version, my functionality is limited and I cannot search online. However, when chatting with me, I remember the context and answer your questions with what you have told me. Please try to communicate with me in English.";
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.hasPermission("all")) {
            try {
                String s = HttpUtils.http("http://localhost:8000/qa?text=" + pre + "&q_text=" + text).get();
                s = s.replace("\"", "");
                end.set("status", "200");
                end.set("msg", s);
            } catch (IOException e) {
                end.set("status", "200");
                end.set("msg", "无");
                System.out.println(e);
            }
        }else{
            end.set("status", "201");
            end.set("msg", "权限不足");
        }
        return end;
    }

    @Post
    @Mapping("/talk")
    public JSON talk(@Body Message message){
        String text = message.getMessage();
        text = text.replace("&", "");
        String time = "The current time is" +message.getTime();
        text = text + " " + time;
        String q = message.getQuestion();
        q = q.replace("&", "");
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.hasPermission("all")) {
            try {
                String s = HttpUtils.http("http://localhost:8000/qa?text=" + pre+" "+ text + "&q_text=" + q).get();
                s = s.replace("\"", "");
                end.set("status", "200");
                end.set("msg", s);
            } catch (IOException e) {
                end.set("status", "200");
                end.set("msg", "无");
                System.out.println(e);
            }
        }else {
            end.set("status", "201");
            end.set("msg", "权限不足");
        }
        return end;
    }

    @Post
    @Mapping("/talk2")
    public JSON talk2(@Body Message message){
        String text = message.getMessage();
        text = text.replace("&", "");
        String time = "The current time is" +message.getTime();
        text = text + " " + time;
        String q = message.getQuestion();
        q = q.replace("&", "");
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.hasPermission("all")) {
            try {
                String s = HttpUtils.http("http://localhost:8000/use?text=" + pre+" "+ text + "&q_text=" + q).get();
                s = s.replace("\"", "");
                end.set("status", "200");
                end.set("msg", s);
            } catch (IOException e) {
                end.set("status", "200");
                end.set("msg", "无");
                System.out.println(e);
            }
        }else {
            end.set("status", "201");
            end.set("msg", "权限不足");
        }
        return end;
    }

}
