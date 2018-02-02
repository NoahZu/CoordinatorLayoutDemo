package com.example.zujinhao.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zujinhao.test.R;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;

public class OkHttpActivity extends BaseActivity {

    private Button sendRequest;
    private TextView contentText;
    private ExecutorService executorService;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);

        sendRequest = (Button) findViewById(R.id.btn_send);
        contentText = (TextView) findViewById(R.id.tv_content);


        executorService = Executors.newSingleThreadExecutor();

        client = new OkHttpClient.Builder().build();

        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendHttpRequest();
            }
        });
    }

    private void sendHttpRequest() {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                processResultOnUIThread(sendReq("https://github.com/NoahZu/TestDemo/blob/master/app/src/main/java/com/example/zujinhao/test/activity/AnimTextActivity.java"));
            }
        });
    }


    String sendReq(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }



    private void processResultOnUIThread(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                contentText.setText(response);
                contentText.setText(response);
            }
        });
    }


}
