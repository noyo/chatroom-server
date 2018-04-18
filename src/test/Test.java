package test;

import org.apache.logging.log4j.LogManager;
import server.action.DbAction;
import server.bean.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import server.login.servlet.RegisterServlet;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/16 15:42
 * @see test
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
        TestService ts = (TestService) ac.getBean("testService");
        ts.hello();
        DbAction ail = (DbAction)ac.getBean("dbAction");
        UserEntity al = new UserEntity();
        al.setName("kaka2");
        al.setPhone("123456123");
        ail.add(al);
    }
}
