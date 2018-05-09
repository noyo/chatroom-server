package server.servlet.contacts;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/21 10:54
 * @see server.servlet.contacts
 */
public enum ContactOpType {

    //添加联系人
    CONTACT_ADD("add"),
    //删除联系人
    CONTACT_DEL("delete"),
    //查找联系人
    CONTACT_FIND("find"),
    //更新联系人信息
    CONTACT_UPDATE("update");

    String name;

    ContactOpType(String name) {
        this.name = name;
    }

    public static ContactOpType getTypeByName(String name) {
        for (ContactOpType type : ContactOpType.values()) {
            if (type.name.equals(name)) {
                return type;
            }
        }
        return null;
    }

}
