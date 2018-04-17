package test;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/16 15:40
 * @see test
 * @deprecated
 */
public class TestService {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void hello() {
        System.out.println("hello " + getName());
    }
}
