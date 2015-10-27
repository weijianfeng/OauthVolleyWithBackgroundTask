package com.example.request;

import android.content.Context;

public interface VolleyBackgroundTask<T> {

    void asyncProcess(Context context, T data) throws Exception;
}
