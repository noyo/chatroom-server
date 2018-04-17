package test;

import bean.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/16 17:23
 * @see test
 * @deprecated
 */
public class UserTest {

    @Qualifier("sessionFactory")//http://wiki.jikexueyuan.com/project/spring/annotation-based-configuration/spring-qualifier-annotation.html
    @Autowired
    private SessionFactory sessionFactory;

    public void add(UserEntity entity) {
        Session s = sessionFactory.openSession();
        Transaction tx= s.beginTransaction();
        s.save(entity);
        tx.commit();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
