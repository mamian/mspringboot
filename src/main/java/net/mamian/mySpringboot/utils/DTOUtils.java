/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mamian.mySpringboot.utils;

import net.mamian.mySpringboot.entity.User;

/**
 *
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-7-29 14:35:24
 * @copyright ©2016 马面 All Rights Reserved
 */
public class DTOUtils {

    public static net.mamian.mySpringboot.model.User toModel(User entity) {
        return new net.mamian.mySpringboot.model.User(entity.getId(),
                                                      entity.getCountryCode(),
                                                      entity.getMobile(),
                                                      entity.getName(),
                                                      entity.getLoginName(),
                                                      entity.getAvatar(),
                                                      entity.isEnabled());
    }

}
