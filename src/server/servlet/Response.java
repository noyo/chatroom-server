package server.servlet;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/23 16:53
 * @see server.servlet
 */
public interface Response<T> {

    /**
     * 返回信息到客户端
     *
     * @param httpCode 返回状态码
     * @param content 返回信息
     * @param body 返回实体
     */
    void response(HttpServletResponse response, int httpCode, String content, T body) throws IOException;
}
