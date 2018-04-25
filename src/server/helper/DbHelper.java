package server.helper;

import common.utils.StringUtils;
import server.Constant;
import server.action.DbAction;

import java.util.Map;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/23 16:25
 * @see server.helper
 */
public class DbHelper {

    private static DbHelper mInstance;

    private DbAction mDbAction;

    private DbHelper() {
        mDbAction = (DbAction) SpringHelper.getInstance().getBean(Constant.DB_ACTION);
    }

    public static DbHelper getInstance() {
        if (null == mInstance) {
            synchronized (Constant.TAG_DBHELPER) {
                mInstance = new DbHelper();
            }
        }
        return mInstance;
    }

    public DbAction getDbAction() {
        return mDbAction;
    }

    public void add(Object obj) {
        if (null != obj) {
            mDbAction.add(obj);
        }
    }

    public Object findByHql(String hql, Map<String, Object> params) {
        if (StringUtils.isEmpty(hql)) {
            return null;
        }
        return mDbAction.findByHql(hql, params);
    }

}
