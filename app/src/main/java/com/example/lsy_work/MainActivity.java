package com.example.lsy_work;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment WeChatFragment = new WeChatFragment();
    private Fragment frirndFragment = new frirndFragment();
    private Fragment configFragment = new configFragment();
    private Fragment contastFragment = new contastFragment();


    private FragmentManager fragmentManager;
    private LinearLayout linearlayout_1, linearlayout_2, linearlayout_3, linearlayout_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        linearlayout_1 = findViewById(R.id.linearlayout_1);
        linearlayout_2 = findViewById(R.id.linearlayout_2);
        linearlayout_3 = findViewById(R.id.linearlayout_3);
        linearlayout_4 = findViewById(R.id.linearlayout_4);

        linearlayout_1.setOnClickListener(this);
        linearlayout_2.setOnClickListener(this);
        linearlayout_3.setOnClickListener(this);
        linearlayout_4.setOnClickListener(this);

        initfragment();
    }

    private void initfragment() {
        fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content, WeChatFragment);
        transaction.add(R.id.content, frirndFragment);
        transaction.add(R.id.content, contastFragment);
        transaction.add(R.id.content, configFragment);
        transaction.commit();
    }

    private void hidefragment(FragmentTransaction transaction) {

        transaction.hide(WeChatFragment);
        transaction.hide(frirndFragment);
        transaction.hide(contastFragment);
        transaction.hide(configFragment);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linearlayout_1:
                showfragment(0);
                break;
            case R.id.linearlayout_2:
                showfragment(1);
                break;
            case R.id.linearlayout_3:
                showfragment(2);
                break;
            case R.id.linearlayout_4:
                showfragment(3);
                break;
            default:
                break;
        }
    }

    private void showfragment(int i) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hidefragment(transaction);
        switch (i) {
            case 0:
                transaction.show(WeChatFragment);
                linearlayout_1.setBackgroundColor(Color.parseColor("#F5F5DC"));
                linearlayout_2.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                linearlayout_3.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                linearlayout_4.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;
            case 1:
                transaction.show(frirndFragment);
                linearlayout_2.setBackgroundColor(Color.parseColor("#F5F5DC"));
                linearlayout_1.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                linearlayout_3.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                linearlayout_4.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;
            case 2:
                transaction.show(contastFragment);
                linearlayout_3.setBackgroundColor(Color.parseColor("#F5F5DC"));
                linearlayout_1.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                linearlayout_2.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                linearlayout_4.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;
            case 3:
                transaction.show(configFragment);
                linearlayout_4.setBackgroundColor(Color.parseColor("#F5F5DC"));
                linearlayout_1.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                linearlayout_3.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                linearlayout_2.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                break;
            default:
                break;
        }
        transaction.commit();
    }
}
