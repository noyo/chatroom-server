package server;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/17 14:56
 * @see server
 */
public class Constant {
    /* login */
    public static final String USER_PWD = "password";
    public static final String USER_NAME = "name";

    /* contacts */
    public static final String USER_ID = "userId";
    public static final String FRIEND_ID = "friendId";
    public static final String GROUP_ID = "groupId";
    public static final String INTIMATE = "intimate";

    /* action */
    public static final String DB_ACTION = "dbAction";

    /* handler */

    /* tag */
    public static final String TAG_DBHELPER = "DbHelper";
    public static final String TAG_GSONHELPER = "GsonHelper";
    public static final String TAG_SPRINGHELPER = "SpringHelper";

    /* string-servlet */
    public static final String NAME_PWD_NOTALLOW_NULL = "用户名密码不能为空";
    public static final String NAME_NOT_FOUND = "您输入的用户名不存在，请重新输入";
    public static final String PWD_ERROR = "你输入密码不正确，请重新输入";
    public static final String LOGIN_SUCCESS = "登录成功";
    public static final String NAME_REGISTERED = "该用户名已被注册过";
    public static final String REGISTER_SUCCESS = "注册成功";
    public static final String URI_NOT_FOUND = "您请求的链接不存在";
}
