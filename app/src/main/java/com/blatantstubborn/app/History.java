package com.blatantstubborn.app;

import android.app.Activity;
import android.os.Build;
        import android.support.annotation.RequiresApi;
import android.os.Bundle;
        import android.view.View;
        import android.webkit.WebResourceRequest;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
        import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class History extends Activity {

    WebView web;
    AdView adView;
    private AdView mAdView;
    InterstitialAd interstitial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        web=findViewById(R.id.web);
        adView=findViewById(R.id.adView);


        //addview code
        mAdView=findViewById(R.id.mAdView);
        //ca-app-pub-6079782771327529~4053047427
        MobileAds.initialize(this, "ca-app-pub-6079782771327529~4053047427");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        web.loadUrl("file:///android_asset/history.html");

        web.getSettings().setJavaScriptEnabled(true);

        web.setWebViewClient(new WebViewClient(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        web.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                web.loadUrl("file:///android_asset/history.html");
                return false;
            }
        });
        //On click listeners


    }



}
