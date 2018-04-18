package server.login.servlet;

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

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter(Constant.USER_NAME);
        String pwd = request.getParameter(Constant.USER_PWD);
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(name)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "用户名密码不能为空");
            return;
        }
        //保存注册信息到数据库
        UserEntity entity = new UserEntity();
        entity.setName(name);
        entity.setPassword(pwd);
        ((DbAction) SpringHelper.getInstance().getBean(Constant.DB_ACTION)).add(entity);
        //返回信息到客户端
        ResponseEntity result = new ResponseEntity(HttpServletResponse.SC_OK, "注册成功", null);
        response.setHeader("content-type", "text/plain;charset=utf-8");
        response.getWriter().print(GsonHelper.getInstance().getGson().toJson(result));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
