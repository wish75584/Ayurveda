 package com.blatantstubborn.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

 public class MainActivity extends Activity {


     LinearLayout history, remedy, yoga, beauty, meditation, carrier;

     private AdView mAdView;
     InterstitialAd interstitial;

     ImageView share;


     @Override
     protected void onCreate(Bundle savedInstanceState) {

         //added this line for removing status bar
         // requestWindowFeature(Window.FEATURE_NO_TITLE);

         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         history = findViewById(R.id.history);
         remedy = findViewById(R.id.remedy);
         yoga = findViewById(R.id.yoga);
         beauty = findViewById(R.id.beauty);
         meditation = findViewById(R.id.meditation);
         carrier = findViewById(R.id.carrier);

         //addview code
         mAdView = findViewById(R.id.mAdView);
         share = findViewById(R.id.share);
         //ca-app-pub-6079782771327529~4053047427
         MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
         AdRequest adRequest = new AdRequest.Builder().build();
         mAdView.loadAd(adRequest);

//hiding status bar

         //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


         //On click listeners
         share.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intent = new Intent(Intent.ACTION_SEND);
                 intent.setType("text/*");
                 intent.putExtra(Intent.EXTRA_TEXT, "Hi, I am using Ayurveda App. Why don't you check it out on your Android phone.\n" +
                         "https://play.google.com/store/apps/details?id=" + getPackageName());
                 startActivity(Intent.createChooser(intent, "Share via"));
             }
         });


         history.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, History.class);
                 startActivity(intent);
             }
         });

         remedy.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, Remedies.class);
                 startActivity(intent);

             }
         });

         yoga.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, YogaActivity.class);
                 startActivity(intent);
             }
         });

         beauty.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, BeautyActivity.class);
                 startActivity(intent);
             }
         });

         meditation.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, MeditationActivity.class);
                 startActivity(intent);
             }
         });
         carrier.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, CarrierActivity.class);
                 startActivity(intent);
             }
         });
         //showAds();
     }





    /* void showAds()
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
     }*/
     }



