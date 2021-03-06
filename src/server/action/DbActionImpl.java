package server.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * TODO: 暂未考虑并发问题
 *
 * @author Chris
 * 2018/4/17 15:48
 * @see server.action
 */
public class DbActionImpl implements DbAction {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Object obj) {
        Session s = sessionFactory.openSession();
        Transaction ts= s.beginTransaction();
        s.save(obj);
        ts.commit();
        s.close();
    }

    @Override
    public Object findByHql(String hql, Map<String, Object> params) {
        Object obj;
        Session s = sessionFactory.openSession();
        Transaction ts = s.beginTransaction();
        Query query = s.createQuery(hql);
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        obj = query.uniqueResult();
        ts.commit();
        s.close();
        return obj;
    }

    @Override
    public boolean update(Object obj) {

        Session s = sessionFactory.openSession();
        Transaction ts = s.beginTransaction();

        ts.commit();
        s.close();

        return false;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
