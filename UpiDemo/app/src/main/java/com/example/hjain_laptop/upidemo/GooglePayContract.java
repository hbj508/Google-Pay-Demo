package com.example.hjain_laptop.upidemo;

import android.content.Intent;

public interface GooglePayContract {

    interface View{

        void initView();
        void startAcitivyt(Intent intent);
    }

    interface Presenter{
        void onPayClick();
    }
}
