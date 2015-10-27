package com.example.request;

import com.android.volley.Request.Method;

public class TestApi {

    private static final String BASE_URI = "XXXXXXXXXXX";

    public static BaseApi weatherInfo() {
        return new BaseApi(Method.GET, BASE_URI, true, null);
    }

}
