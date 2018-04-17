package login.servlet;

import action.DbAction;
import bean.ResponseEntity;
import bean.UserEntity;
import com.google.gson.Gson;
import common.Constant;
import common.helper.SpringHelper;
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
        UserEntity entity = new UserEntity();
        entity.setName(name);
        entity.setPassword(pwd);
        ((DbAction) SpringHelper.getInstance().getBean(Constant.DB_ACTION)).add(entity);
        ResponseEntity result = new ResponseEntity();
        result.setCode(HttpServletResponse.SC_OK);
        result.setContent("注册成功");
        response.getWriter().print((new Gson()).toJson(result));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
