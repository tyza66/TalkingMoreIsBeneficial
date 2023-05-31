package com.tyza66.talk.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.utils.http.HttpUtils;

import java.io.IOException;

@Controller
public class TalkController {
    @Get
    @Mapping("talkByNone")
    public String talkByNone(){

            try {
                String s = HttpUtils.http("localhost:8000").get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        return "";

    }
}
