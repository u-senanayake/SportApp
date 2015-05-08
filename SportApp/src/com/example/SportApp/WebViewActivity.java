package com.example.SportApp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Udayanga Senanayake on 5/8/2015.
 */
public class WebViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_activity);
        Bundle bundle=getIntent().getExtras();
        String value=bundle.getString("link");
        System.out.println(value);

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl(value);

    }
}