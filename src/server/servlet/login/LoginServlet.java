package server.servlet.login;

import common.utils.StringUtils;
import server.Constant;
import server.bean.UserEntity;
import server.helper.DbHelper;
import server.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends BaseServlet<UserEntity> {

    private final String LOGIN_HQL = "from UserEntity where name = :" + Constant.USER_NAME;

    private String name;
    private String password;
    private UserEntity user;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        name = request.getParameter(Constant.USER_NAME);
        password = request.getParameter(Constant.USER_PWD);
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            response(response, HttpServletResponse.SC_NO_CONTENT, Constant.NAME_PWD_NOTALLOW_NULL, null);
            return;
        }
        user = find(name);
        if (null == user) {
            response(response, HttpServletResponse.SC_NO_CONTENT, Constant.NAME_NOT_FOUND, null);
            return;
        }
        if (!password.equals(user.getPassword())) {
            response(response, HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION, Constant.PWD_ERROR, null);
            return;
        }
        response(response, HttpServletResponse.SC_OK, Constant.LOGIN_SUCCESS, null);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /* 查找用户 */
    @SuppressWarnings("unchecked")
    private UserEntity find(String name) {
        Map map = new HashMap<String, String>();
        map.put(Constant.USER_NAME, name);
        return (UserEntity) DbHelper.getInstance().findByHql(LOGIN_HQL, map);
    }
}
