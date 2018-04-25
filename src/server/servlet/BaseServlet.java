package server.servlet;

import server.bean.ResponseEntity;
import server.helper.GsonHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/23 16:56
 * @see server.servlet
 */
public abstract class BaseServlet<T> extends HttpServlet implements Response<T> {

    @Override
    public final void response(HttpServletResponse response, int httpCode, String content, T body) throws IOException {
        ResponseEntity result = new ResponseEntity(httpCode, content, body);
        response.setHeader("content-type", "text/plain;charset=utf-8");
        response.getWriter().print(GsonHelper.getInstance().getGson().toJson(result));
    }
}
