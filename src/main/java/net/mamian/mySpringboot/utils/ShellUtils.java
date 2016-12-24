/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.utils;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.util.StringUtils;

/**
 * 执行shell命令
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-12-24 9:45:39
 * @copyright ©2016 马面 All Rights Reserved
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
@Slf4j
public class ShellUtils {
    
    /**
     * 
     * 
     * @param shPath shell脚本全路径
     * @param param 命令附加参数
     * @return 
     */
    public static int exe(String shPath, String... param){
        if(StringUtils.isEmpty(shPath)){
            log.info("shell命令不存在：shpath={}", shPath);
            return -1;
        }
        Process p;
        try {
            shPath = "chmod 755 "+shPath;
            if(null != param){
                for(String paramItem : param){
                    shPath += " "+paramItem;
                }
            }
            log.info("shell命令开始执行：shpath={}", shPath);
            p = Runtime.getRuntime().exec(shPath);
            p.waitFor();
            log.info("shell命令执行完毕：shpath={}", shPath);
        } catch (IOException | InterruptedException ex) {
            log.info("执行shell命令出错：shpath={} exception={}", shPath, ex);
            return -1;
        }
        return 0;
    }
    
}
