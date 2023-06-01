package com.tyza66.talk;

import cn.dev33.satoken.SaManager;
import org.noear.snack.ONode;
import org.noear.solon.Solon;
import org.noear.wood.WoodConfig;

/**
 * Author: tyza66
 * Date: 2023/05/31 7:41
 * Github: https://github.com/tyza66
 **/
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args, (app) -> {
            if (Solon.cfg().isDebugMode() || Solon.cfg().isFilesMode()) {
                //执行后打印sql
                WoodConfig.onExecuteAft(cmd -> {
                    System.out.println("[Wood]" + cmd.text + "\r\n" + cmd.paramMap());
                });
            }
        });
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }
}
