package com.example.moneytrack;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView mywebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mywebView =(WebView) findViewById(R.id.WebViewId);
        mywebView.setWebViewClient(new WebViewClient());
//        mywebView.loadUrl("https://cxfydhcg.github.io/moneytrack/");
        WebSettings webSettings= mywebView.getSettings();
        mywebView.getSettings().setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);
        mywebView.loadUrl("file:///android_asset/index.html");
//        simpleWebView.loadDataWithBaseURL(null, data, "text/html", "UTF-8", "");
 /*       mywebView.getSettings().setLoadsImagesAutomatically(true);
        mywebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        webView.getSettings().setDisplayZoomControls(true);
//        webView.getSettings().setBuiltInZoomControls(true);
        mywebView.getSettings().setLoadWithOverviewMode(true);
        mywebView.getSettings().setSupportMultipleWindows(true);
        mywebView.getSettings().setAllowFileAccess(true);

//        mywebView.loadUrl("file:///android_asset/index.html");
        mywebView.loadUrl("https://cxfydhcg.github.io/moneytrack/");
        mywebView.setWebChromeClient(new WebChromeClient());
//        mywebView.setWebViewClient(new myWebViewClient());*/
    }
    public class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }

}