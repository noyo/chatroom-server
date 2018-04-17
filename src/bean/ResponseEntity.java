package bean;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/17 16:45
 * @see bean
 */
public class ResponseEntity {

    private int code;
    private String content;

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "code=" + code +
                ", content='" + content + '\'' +
                '}';
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
}
