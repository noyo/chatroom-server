package test;

import bean.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/16 15:42
 * @see test
 * @deprecated
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
        TestService ts = (TestService) ac.getBean("testService");
        ts.hello();
        UserTest ail = (UserTest)ac.getBean("user");
        UserEntity al = new UserEntity();
        al.setUserId("dsf");
        al.setName("kaka");
        al.setPhone("123456123");
        ail.add(al);
    }
}
