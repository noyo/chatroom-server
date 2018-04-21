package server.servlet.login;

import server.action.DbAction;
import server.bean.ResponseEntity;
import server.bean.UserEntity;
import server.Constant;
import server.helper.GsonHelper;
import server.helper.SpringHelper;
import common.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private DbAction action = (DbAction) SpringHelper.getInstance().getBean(Constant.DB_ACTION);
    private final String REGISTER_HQL = "from UserEntity where name = :" + Constant.USER_NAME;

    /* 判断待注册用户是否已存在 */
    @SuppressWarnings("unchecked")
    private boolean isExist(String name) {
        Map map = new HashMap<String, String>();
        map.put(Constant.USER_NAME, name);
        return null != action.findByHql(REGISTER_HQL, map);
    }

    /* 保存注册信息到数据库 */
    private void save2Db(String name, String pwd) {
        UserEntity entity = new UserEntity();
        entity.setName(name);
        entity.setPassword(pwd);
        action.add(entity);
    }

    /* 返回信息到客户端 */
    private void response(HttpServletResponse response, int httpCode, String content, Object body) throws IOException {
        ResponseEntity result = new ResponseEntity(httpCode, content, body);
        response.setHeader("content-type", "text/plain;charset=utf-8");
        response.getWriter().print(GsonHelper.getInstance().getGson().toJson(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter(Constant.USER_NAME);
        String pwd = request.getParameter(Constant.USER_PWD);
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(name)) {
            response(response, HttpServletResponse.SC_NO_CONTENT, "用户名密码不能为空", null);
            return;
        }
        if (isExist(name)) {
            response(response, HttpServletResponse.SC_CREATED, "用户名已存在", null);
            return;
        }
        save2Db(name, pwd);
        response(response, HttpServletResponse.SC_OK, "注册成功", null);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
