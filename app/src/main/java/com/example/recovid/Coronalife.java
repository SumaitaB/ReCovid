package com.example.recovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Coronalife extends AppCompatActivity {

    private WebView webView;
    private String webUrl="https://www.who.int/bangladesh/emergencies/coronavirus-disease-(covid-19)-update";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coronalife);

        webView=findViewById(R.id.webview);
        webView.loadUrl(webUrl);

    }
}
