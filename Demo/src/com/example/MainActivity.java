package com.example;

import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.example.R;
import com.example.request.BaseApi;
import com.example.request.BaseJsonObjectRequest;
import com.example.request.TestApi;
import com.example.request.VolleyBackgroundTask;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取全局的发送队列
        mRequestQueue = AppContext.getAppContext().getRequestQueue();

        new Thread() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                sendRequest();
            }
        }.start();

    }

    private void sendRequest() {
        // TODO Auto-generated method stub
        BaseApi api = TestApi.weatherInfo();
        BaseJsonObjectRequest req = new BaseJsonObjectRequest(
                MainActivity.this, api, new VolleyBackgroundTask<JSONObject>() {

                    @Override
                    public void asyncProcess(Context context, JSONObject data)
                            throws Exception {
                        // TODO Auto-generated method stub

                    }
                }, new Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // TODO Auto-generated method stub
                    }
                }, new ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                    }
                });

        mRequestQueue.add(req);
    }
}
