package com.example.hjain_laptop.upidemo;

import android.content.Intent;
import android.net.Uri;

public class GooglePayPresenter implements GooglePayContract.Presenter {

    GooglePayContract.View GooglePayView;

    public GooglePayPresenter(GooglePayContract.View payView) {
        this.GooglePayView=payView;
    }

    @Override
    public void onPayClick() {
        Uri uri =
                new Uri.Builder()
                        .scheme("upi")
                        .authority("pay")
                        .appendQueryParameter("pa", Constants.MERCHANT_VPA)
                        .appendQueryParameter("pn", Constants.MERCHANT_NAME)
                        .appendQueryParameter("mc", Constants.MERCHANT_CODE)
                        .appendQueryParameter("tr", Constants.TRANSACTION_REFID)
                        .appendQueryParameter("tn", Constants.TRANSACTION_NOTE)
                        .appendQueryParameter("am", Constants.ORDER_AMOUNT)
                        .appendQueryParameter("cu", Constants.CURRENCY)
                        .appendQueryParameter("url", Constants.URL)
                        .build();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        intent.setPackage(Constants.GOOGLE_TEZ_PACKAGE_NAME);
        GooglePayView.startAcitivyt(intent);
    }
}
