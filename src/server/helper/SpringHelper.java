package server.helper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import server.Constant;

import java.io.File;
import java.io.IOException;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/17 15:25
 * @see server.helper
 */
public class SpringHelper {

    private static SpringHelper mInstance;
    private ApplicationContext mContext;
    private final String rootPath = SpringHelper.class.getResource("").getPath().replace("/classes/server/helper", "");

    private SpringHelper() {
        mContext = new FileSystemXmlApplicationContext(rootPath + "/applicationContext.xml");
    }

    public static SpringHelper getInstance() {
        if (null == mInstance) {
            synchronized (Constant.TAG_SPRINGHELPER) {
                mInstance = new SpringHelper();
            }
        }
        return mInstance;
    }

    /**
     * 获取实例对象
     *
     * @param s object.id
     * @return bean
     */
    @SuppressWarnings("unchecked")
    public Object getBean(String s) {
        return mContext.getBean(s);
    }
}
