package server.bean;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/17 16:45
 * @see server.bean
 */
public class ResponseEntity {

    private int code;
    private String content;
    private Object body;

    public ResponseEntity() {

    }

    public ResponseEntity(int code, String content, Object body) {
        this.code = code;
        this.content = content;
        this.body = body;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "code=" + code +
                ", content='" + content + '\'' +
                ", body=" + body.toString() +
                '}';
    }
}
