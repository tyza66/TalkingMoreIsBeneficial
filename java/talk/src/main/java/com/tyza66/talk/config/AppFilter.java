package com.tyza66.talk.config;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;

@Slf4j
@Component
public class AppFilter implements Filter {
    @Override
    public void doFilter(Context ctx, FilterChain chain) throws Throwable {
        //1.开始计时（用于计算响应时长）
        long start = System.currentTimeMillis();
        try {
            chain.doFilter(ctx);
        } catch (Throwable e) {
            log.error(e.toString());
        }

        //5.获得接口响应时长
        long times = System.currentTimeMillis() - start;
        System.out.println("请求路径:"+ctx.path()+"、用时："+ times);
    }
}