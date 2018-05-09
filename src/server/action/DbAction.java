package server.action;

import java.util.Map;

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
     * @param obj 数据对象
     */
    void add(Object obj);

//    void delete(Object obj);

    /**
     * 通过hql查询数据库
     *
     * @param hql
     */
    Object findByHql(String hql, Map<String, Object> params);

    /**
     * 数据库表更新
     *
     * @param obj 更新实体
     * @return 更新成功与否
     */
    boolean update(Object obj);
}
