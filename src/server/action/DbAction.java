package server.action;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/17 15:47
 * @see server.action
 */
public interface DbAction {
    /**
     * 添加数据对象到数据库
     *
     * @param t 数据对象
     */
    void add(Object t);

//    void delete();
}
