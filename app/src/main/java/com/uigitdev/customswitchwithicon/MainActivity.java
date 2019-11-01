package com.uigitdev.customswitchwithicon;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.uigitdev.customswitchwithicon.uigitdev.design.CustomSwitch;

public class MainActivity extends AppCompatActivity implements CustomSwitch.SwitchClickInterface {
    private RelativeLayout home_parent;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home_parent = findViewById(R.id.home_parent);
        textView = findViewById(R.id.textView);
        CustomSwitch customSwitch = new CustomSwitch(findViewById(R.id.customSwitch), MainActivity.this);
        customSwitch.setDefault(false);
    }

    @SuppressLint("ResourceType")
    @Override
    public void getSwitchValue(boolean value) {
        if (value) {
            home_parent.setBackgroundColor(Color.parseColor(getString(R.color.colorBackground)));
            textView.setVisibility(View.VISIBLE);
        } else {
            home_parent.setBackgroundColor(Color.parseColor(getString(R.color.colorWhite)));
            textView.setVisibility(View.GONE);
        }
    }
}
