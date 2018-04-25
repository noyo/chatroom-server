package server.helper;

import com.google.gson.Gson;
import server.Constant;

/**
 * Copyright © 2018 Chris. All rights reserved.
 *
 * @author Chris
 * 2018/4/18 15:23
 * @see server.helper
 */
public class GsonHelper {

    private static GsonHelper mInstance;

    private Gson mGson;

    private GsonHelper() {
        mGson = new Gson();
    }

    public static GsonHelper getInstance() {
        if (null == mInstance) {
            synchronized (Constant.TAG_GSONHELPER) {
                mInstance = new GsonHelper();
            }
        }
        return mInstance;
    }

    public Gson getGson() {
        return mGson;
    }

}
