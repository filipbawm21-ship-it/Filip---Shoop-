package com.filipshoop.app;

import android.app.*;import android.os.*;import android.content.*;import android.net.*;import android.webkit.*;import android.view.*;import android.graphics.Color;

public class MainActivity extends Activity {
    WebView webView;
    @Override public void onCreate(Bundle b){super.onCreate(b);setContentView(R.layout.activity_main); webView=findViewById(R.id.webview);
        WebSettings s=webView.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setAllowFileAccess(true); s.setAllowContentAccess(true); s.setSupportZoom(false); s.setBuiltInZoomControls(false); s.setDisplayZoomControls(false); s.setMediaPlaybackRequiresUserGesture(false);
        webView.setBackgroundColor(Color.rgb(8,11,16));
        webView.setWebViewClient(new WebViewClient(){@Override public boolean shouldOverrideUrlLoading(WebView v,WebResourceRequest r){Uri u=r.getUrl(); if(!u.getScheme().equals("file")){startActivity(new Intent(Intent.ACTION_VIEW,u)); return true;} return false;}});
        webView.setWebChromeClient(new WebChromeClient()); webView.loadUrl("file:///android_asset/index.html"); }
    @Override public void onBackPressed(){ if(webView.canGoBack()) webView.goBack(); else super.onBackPressed(); }
}
