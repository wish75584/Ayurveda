package com.blatantstubborn.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Main2Activity extends AppCompatActivity {

    AdView adView;
    InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MobileAds.initialize(this, "ca-app-pub-4945440279638756~3798657980");

        adView=findViewById(R.id.adView);

        showAds();

    }

    void showAds()
    {
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(getResources().getString(R.string.ADD_UNIT_ID));
        AdRequest adRequest = new AdRequest.Builder()
                // Add a test device to show Test Ads
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                //.addTestDevice("test")
                .build();

        // Load ads into Banner Ads
        adView.loadAd(adRequest);

        // Load ads into Interstitial Ads
        interstitial.loadAd(adRequest);
        Log.e("show DDS","HHHHHHHH");
        Log.e(" adRequest",adRequest+"");
    }

}
