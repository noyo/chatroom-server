package server.servlet.login;

import server.bean.UserEntity;
import server.Constant;
import server.helper.DbHelper;
import common.utils.StringUtils;
import server.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends BaseServlet<UserEntity> {

    private final String REGISTER_HQL = "from UserEntity where name = :" + Constant.USER_NAME;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter(Constant.USER_NAME);
        String pwd = request.getParameter(Constant.USER_PWD);
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)) {
            response(response, HttpServletResponse.SC_NO_CONTENT, Constant.NAME_PWD_NOTALLOW_NULL, null);
            return;
        }
        if (isExist(name)) {
            response(response, HttpServletResponse.SC_CREATED, Constant.NAME_REGISTERED, null);
            return;
        }
        save2Db(name, pwd);
        response(response, HttpServletResponse.SC_OK, Constant.REGISTER_SUCCESS, null);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /* 判断待注册用户是否已存在 */
    @SuppressWarnings("unchecked")
    private boolean isExist(String name) {
        Map map = new HashMap<String, String>();
        map.put(Constant.USER_NAME, name);
        return null != DbHelper.getInstance().findByHql(REGISTER_HQL, map);
    }

    /* 保存注册信息到数据库 */
    private void save2Db(String name, String pwd) {
        UserEntity entity = new UserEntity();
        entity.setName(name);
        entity.setPassword(pwd);
        DbHelper.getInstance().add(entity);
    }
}
