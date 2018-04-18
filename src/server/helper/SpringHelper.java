package server.helper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/17 15:25
 * @see server.helper
 */
public class SpringHelper {

    private static final Byte[] LOCK = new Byte[0];

    public static SpringHelper mInstance;
    private ApplicationContext mContext;

    private SpringHelper() {
        mContext = new FileSystemXmlApplicationContext("E:\\study\\student\\server\\chatroom-server" + "/web/WEB-INF/applicationContext.xml");
    }

    public static SpringHelper getInstance() {
        if (null == mInstance) {
            synchronized (LOCK) {
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
