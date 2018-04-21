package server.servlet.contacts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "AddContactServlet")
public class AddContactServlet extends HttpServlet {

    //用户id
    private int userId;
    //好友id
    private int friendId;
    //好友类型id
    private int groupId;
    //是否为亲密关系
    private int intimate;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
