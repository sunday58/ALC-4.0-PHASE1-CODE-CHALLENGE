package com.example.andriod.codechallenge;

import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {
    WebView aboutALC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    //web View
         aboutALC = findViewById(R.id.aboutAlc);
        WebSettings webSettings = aboutALC.getSettings();
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
            webSettings.setDatabasePath("/data/data/" + this.getPackageName() + "/databases/");
        }
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setAllowContentAccess(true);
        webSettings.setPluginState(WebSettings.PluginState.OFF);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);


        aboutALC.setInitialScale(1);
        aboutALC.setScrollbarFadingEnabled(false);
        aboutALC.setHorizontalScrollBarEnabled(false);
        aboutALC.setVerticalScrollBarEnabled(false);
        aboutALC.clearView();
        aboutALC.setWebViewClient(new WebViewClient());
        aboutALC.getSettings().setBuiltInZoomControls(true);
        aboutALC.setHorizontalScrollBarEnabled(false);
        aboutALC.loadUrl("https://andela.com/alc/");


        aboutALC.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    view.loadUrl(request.getUrl().toString());
                }
                return false;
            }

        });

        aboutALC.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });
    }

}
