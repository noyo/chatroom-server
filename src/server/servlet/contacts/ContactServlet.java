package server.servlet.contacts;

import server.Constant;
import server.bean.FriendshipEntity;
import server.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContactServlet")
public class ContactServlet extends BaseServlet<FriendshipEntity> {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        ContactOpType type = ContactOpType.getTypeByName(uri.substring(uri.lastIndexOf("/") + 1));
        if (null == type) {
            response(response, HttpServletResponse.SC_NOT_FOUND, Constant.URI_NOT_FOUND, null);
            return;
        }

        //用户id
        int userId = Integer.parseInt(request.getParameter(Constant.USER_ID));
        //好友id
        int friendId = Integer.parseInt(request.getParameter(Constant.FRIEND_ID));
        //好友类型id
        int groupId = Integer.parseInt(request.getParameter(Constant.GROUP_ID));
        //是否为亲密关系
        int intimate = Integer.parseInt(request.getParameter(Constant.INTIMATE));

        switch (type) {
            case CONTACT_ADD:
                addContact(userId, friendId, groupId, intimate);
                break;
            case CONTACT_DEL:
                break;
            case CONTACT_UPDATE:
                break;
            case CONTACT_FIND:
                break;
            default:
                response(response, HttpServletResponse.SC_NOT_FOUND, Constant.URI_NOT_FOUND, null);
        }
    }

    /* 添加联系人 */
    private void addContact(int userId, int friendId, int groupId, int intimate) {

    }
}
