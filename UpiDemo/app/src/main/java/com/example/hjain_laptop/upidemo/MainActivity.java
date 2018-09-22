package com.example.hjain_laptop.upidemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements GooglePayContract.View {

    private GooglePayContract.Presenter GooglePayinPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        GooglePayinPresenter = new GooglePayPresenter(this);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GooglePayinPresenter.onPayClick();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.TEZ_REQUEST_CODE) {
            // Process based on the data in response.
            Log.d("result", data.getStringExtra("Status"));
        }
    }

    Button payButton;

    @Override
    public void initView() {
        payButton = findViewById(R.id.pay_button);
    }

    @Override
    public void startAcitivyt(Intent payIntent) {
        startActivityForResult(payIntent, Constants.TEZ_REQUEST_CODE);
    }
}