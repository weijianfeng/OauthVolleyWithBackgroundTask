package com.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class AppContext extends Application {

    private static AppContext mAppContext;
    private static Map<String, String> sAuthHeaders;
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        mAppContext = this;
        mRequestQueue = Volley.newRequestQueue(this);
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    public static AppContext getAppContext() {
        return mAppContext;
    }

    public static Map<String, String> getAuthHeaders() {
        // 如果没有授权，返回null
        // 之前持久化的数据，需要在之前的登陆流程中进行持久化
        String accessToken = "test";
        if (accessToken == null) {
            return Collections.emptyMap();
        }

        if (sAuthHeaders == null) {
            sAuthHeaders = new HashMap<String, String>(1);
            sAuthHeaders.put("Authorization", "OAuth2 " + accessToken);
        }
        return sAuthHeaders;
    }

}
