package com.example.request;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class BaseApi {

    public final int method;
    /** http uri */
    public final String uri;
    /** 是否需要传递access token */
    public final boolean authRequired;
    /** 是否需要在map里设置请求参数，通常用于post和put方法，没有赋null即可 */
    public final Map<String, String> params;

    public BaseApi(int method, String uri, boolean authRequired,
            Map<String, String> params) {
        this.method = method;
        this.uri = uri;
        this.authRequired = authRequired;
        this.params = params;
    }

    public BaseApi(int method, StringBuilder uri, boolean authRequired,
            Map<String, String> params) {
        this.method = method;
        this.uri = uri.toString();
        this.authRequired = authRequired;
        this.params = params;
    }

    public static String encode(String string) {
        String encode = null;
        try {
            encode = URLEncoder.encode(string, "utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        return encode;
    }
}
