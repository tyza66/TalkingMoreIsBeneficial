package com.tyza66.talk.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.utils.http.HttpUtils;
import org.noear.solon.core.handle.Context;

import java.io.IOException;

@Controller
public class TalkController {
    @Get
    @Mapping("/talkByNone")
    public JSON talkByNone(Context ctx) {
        String text = ctx.param("q");
        String pre = "I have three Apple.";
        JSONObject end = JSONUtil.createObj();
        try {
            String s = HttpUtils.http("http://localhost:8000/qa?text="+pre+"&q_text="+text).get();
            s = s.replace("\"", "");
            end.set("status","200");
            end.set("msg",s);
        } catch (IOException e) {
            end.set("status","200");
            end.set("msg","无");
            System.out.println(e);
        }
        return end;

    }
}
