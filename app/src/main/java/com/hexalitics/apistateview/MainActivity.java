package com.hexalitics.apistateview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import sakout.mehdi.StateViews.StateView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    StateView mStatusPage;
    Button mLoading, mError, mCustom;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoading = findViewById(R.id.button_loading);
        mError = findViewById(R.id.button_error);
        mCustom = findViewById(R.id.button_custom);

        mLoading.setOnClickListener(this);
        mError.setOnClickListener(this);
        mCustom.setOnClickListener(this);

        mStatusPage = findViewById(R.id.status_page);
        mStatusPage.displayState("error");
        type = "error";
        mStatusPage.setOnStateButtonClicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_loading) {
            mStatusPage.displayState("search");
            type = "search";
        } else if (view.getId() == R.id.button_error) {
            mStatusPage.displayState("error");
            type = "error";
        } else if (view.getId() == R.id.button_custom) {
            mStatusPage.displayState("archive");
            type = "archive";
        }
    }
}