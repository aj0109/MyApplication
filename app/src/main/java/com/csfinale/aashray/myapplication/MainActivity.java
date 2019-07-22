package com.csfinale.aashray.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.notifications.NotificationCustomizationOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MarketingCloudSdk.init(this, MarketingCloudConfig.builder()
                .setApplicationId("ba550d70-8e4a-4289-ac64-f76702723c23")
                .setAccessToken("0EfECb2OqOToMrOJ8qRuXcbQ")
                .setSenderId("705634500209")
                .setMarketingCloudServerUrl("https://mc1zy4pnkd8f15-yhf3g0g1kl9l0.device.marketingcloudapis.com/")
                .setMid("6420638")
                .setNotificationCustomizationOptions(
                        NotificationCustomizationOptions.create(R.drawable.ic_launcher_foreground)
                )
                // Other configuration options
                .build(this), new MarketingCloudSdk.InitializationListener() {
            @Override public void complete(@NonNull InitializationStatus status) {
                // TODO handle initialization status
            }
        });

        MarketingCloudSdk.requestSdk(new MarketingCloudSdk.WhenReadyListener() {
            @Override public void ready(@NonNull MarketingCloudSdk sdk) {
                Log.d("TOKEN", sdk.getPushMessageManager().getPushToken());
            }
        });
        MarketingCloudSdk.requestSdk(new MarketingCloudSdk.WhenReadyListener() {
            @Override public void ready(@NonNull MarketingCloudSdk sdk) {
                Log.d("SDKSTATE", sdk.getSdkState().toString());
            }
        });
    }
    }
