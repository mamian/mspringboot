/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mamian.mySpringboot.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-8-8 10:43:36
 * @copyright ©2016 马面 All Rights Reserved
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
public enum Privilege implements BaseEnum {
    /**
     * 用户权限
     */
    USER_LIST("列出用户", Realm.USER, "用户权限"),
    USER_DETAIL("查看用户详情", Realm.USER, "用户权限"),
    USER_ALTER("添加更改用户信息", Realm.USER, "用户权限"),
    USER_DELETE("禁用用户", Realm.USER, "用户权限"),
    
    /**
     * 员工权限
     */
    EMPLOYEE_LIST("列出员工", Realm.EMPLOYEE, "员工权限"),
    EMPLOYEE_DETAIL("查看员工详情", Realm.EMPLOYEE, "员工权限"),
    EMPLOYEE_ADD("添加员工", Realm.EMPLOYEE, "员工权限"),
    EMPLOYEE_ALTER("更改员工信息", Realm.EMPLOYEE, "员工权限"),
    EMPLOYEE_GRANT("调整员工权限", Realm.EMPLOYEE, "员工权限"),
    
    /**
     * 角色权限
     */
    ROLE_VIEW("查看角色权限配置", Realm.ROLE, "角色权限"),
    ROLE_ASSIGN("分配角色权限", Realm.ROLE, "角色权限"),
    
    ;
    

    private final String msg;

    private final Realm realm;

    private final String description;

    /**
     * realm所属的所有priviledges
     */
    private static final Map<Realm, List<Privilege>> realm2Privilege = new HashMap<>();

    static {
        for (Privilege privilege : Privilege.values()) {
            List<Privilege> privilegeList = realm2Privilege.get(privilege.getRealm());
            if (privilegeList == null) {
                privilegeList = new ArrayList<>();
                privilegeList.add(privilege);
                realm2Privilege.put(privilege.getRealm(), privilegeList);
            } else {
                realm2Privilege.get(privilege.getRealm()).add(privilege);
            }
        }
    }

    Privilege(String msg, Realm realm, String description) {
        this.msg = msg;
        this.realm = realm;
        this.description = description;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public Realm getRealm() {
        return realm;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 获得realm所有对应的priviledge
     *
     * @param realm
     * @return
     */
    public static List<Privilege> listByIncludedRealm(Realm... realms) {
        if (realms == null || realms.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Privilege> result = new ArrayList<>();
        for (Realm realm : realms) {
            List<Privilege> temp = realm2Privilege.get(realm);
            if (temp != null && !temp.isEmpty()) {
                result.addAll(temp);
            }
        }
        return result;
    }

    /**
     * 列出所有不属于realm的priviledge,主要给不同的客户权限管理显示不同的可用权限列表
     *
     * @param realms
     * @return
     */
    public static List<Privilege> listByExcludedRealm(Realm... realms) {
        List<Privilege> result = new ArrayList<>();
        Set excludedRealms = new HashSet(Arrays.asList(realms));
        for (Realm realm : realm2Privilege.keySet()) {
            if (!excludedRealms.contains(realm)) {
                List<Privilege> temp = realm2Privilege.get(realm);
                if (temp != null && !temp.isEmpty()) {
                    result.addAll(temp);
                }
            }
        }
        return result;
    }
}
