/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mamian.mySpringboot.job;

import lombok.extern.slf4j.Slf4j;
import net.mamian.mySpringboot.utils.ShellUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-12-24 9:17:53
 * @copyright ©2016 马面 All Rights Reserved DO NOT ALTER OR REMOVE COPYRIGHT
 * NOTICES OR THIS FILE HEADER.
 */
@Slf4j
@Component
public class ScheduleJob {

    /**
     * 每天17点，执行一次
     */
    @Scheduled(cron = "0 0 17 * * ?")
    public void executeJob() {

        int result = ShellUtils.exe("/home/test.sh");
        if (0 == result) {
            log.info("定时任务执行成功（每日17点执行1次）");
        } else {
            log.info("定时任务执行失败（每日17点执行1次）");
        }
    }

}
