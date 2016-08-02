/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.enums;

import lombok.Getter;

/**
 * 国家
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-7-22 19:36:50
 * @copyright ©2016 马面 All Rights Reserved
 */
public enum CountryCode implements BaseEnum {

    AU("61", "澳大利亚"),
    RU("7", "俄罗斯"),
    FR("33", "法国"),
    CA("1", "加拿大"),
    KR("82", "韩国"),
    US("1", "美国"),
    MY("60", "马来西亚"),
    TH("66", "泰国"),
    TW("886", "台湾"),
    SG("65", "新加坡"),
    JP("81", "日本"),
    IN("91", "印度"),
    GB("44", "英国"),
    CN("86", "中国"),
    MO("853", "中国澳门特别行政区"),
    HK("852", "中国香港特别行政区"),
    CH("41", "瑞士"),
    IE("353", "爱尔兰"),
    SE("46", "瑞典"),
    AT("43", "奥地利"),
    NL("31", "荷兰"),
    FI("358", "芬兰"),
    BE("32", "比利时"),
    DE("49", "德国"),
    IT("39", "意大利"),
    ES("34", "西班牙"),
    PT("351", "葡萄牙"),
    DK("45", "丹麦"),
    NO("47", "挪威"),
    IS("354","冰岛"),
    NZ("64", "新西兰"),
    UA("380", "乌克兰"),
    TR("90", "土耳其"),
    ;
    
    @Getter
    private final String msg;
    
    @Getter
    private final String country;
    
    CountryCode(String msg, String country) {
        this.msg = msg;
        this.country = country;
    }
    
}
