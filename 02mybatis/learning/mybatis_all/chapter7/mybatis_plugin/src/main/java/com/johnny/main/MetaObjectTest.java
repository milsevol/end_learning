package com.johnny.main;

import com.johnny.pojo.Role;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

public class MetaObjectTest {

    public static void main(String[] args) {
        Role role = new Role();
        role.setId(23);
        role.setNote("mm");
        MetaObject metaObject = SystemMetaObject.forObject(role);
        metaObject.setValue("id",343);
        metaObject.hasGetter("id");
        System.out.println(role.getId());
    }
}
