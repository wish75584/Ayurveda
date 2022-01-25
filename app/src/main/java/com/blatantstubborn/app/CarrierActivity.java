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

public class CarrierActivity extends Activity {


    WebView web5;
    private AdView mAdView;
    AdView adView;
    InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrier);
        web5 = findViewById(R.id.web5);


        //addview code
        mAdView=findViewById(R.id.mAdView);
        //ca-app-pub-6079782771327529~4053047427
        MobileAds.initialize(this, "ca-app-pub-6079782771327529~4053047427");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        web5.loadUrl("file:///android_asset/carrier.html");

        web5.getSettings().setJavaScriptEnabled(true);

        web5.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        web5.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    web5.loadUrl("file:///android_asset/carrier.html");
                    return false;
                }
        });
        adView=findViewById(R.id.adView);


    }

    @Override
    public void onBackPressed() {

        if (web5.canGoBack()) {
            web5.goBack();
        } else {
            super.onBackPressed();
        }
    }



}