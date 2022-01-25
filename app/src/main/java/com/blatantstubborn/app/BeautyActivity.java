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

public class BeautyActivity extends Activity {

    private AdView mAdView;
    WebView web3;
    AdView adView;
    InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty);

        web3 = findViewById(R.id.web3);
        adView=findViewById(R.id.adView);


        //addview code
        mAdView=findViewById(R.id.mAdView);
        //ca-app-pub-6079782771327529~4053047427
        MobileAds.initialize(this, "ca-app-pub-6079782771327529~4053047427");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        web3.loadUrl("file:///android_asset/beuty.html");

        web3.getSettings().setJavaScriptEnabled(true);

        web3.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        web3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                web3.loadUrl("file:///android_asset/beuty.html");
                return false;
            }
        });


    }
    @Override
    public void onBackPressed() {

        if(web3.canGoBack())
        {
            web3.goBack();
        }
        else {
            super.onBackPressed();
        }
    }


    }

