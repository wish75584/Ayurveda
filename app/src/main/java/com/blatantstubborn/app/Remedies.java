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

public class Remedies extends Activity {



    WebView web1;

    AdView adView;
    private AdView mAdView;
    InterstitialAd interstitial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedies);

            web1 = findViewById(R.id.web1);



        //addview code
        mAdView=findViewById(R.id.mAdView);
        //ca-app-pub-6079782771327529~4053047427
        MobileAds.initialize(this, "ca-app-pub-6079782771327529~4053047427");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

            web1.loadUrl("file:///android_asset/remedy.html");
            web1.getSettings().setJavaScriptEnabled(true);


        web1.setWebViewClient(new WebViewClient(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        web1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                web1.loadUrl("file:///android_asset/remedy.html");
                return false;
            }
        });
    }

    //code for back pressed button
    //if this code is not present in webview code will be not able to go on back page will directly goto main page

    @Override
    public void onBackPressed() {

        if(web1.canGoBack())
        {
            web1.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
