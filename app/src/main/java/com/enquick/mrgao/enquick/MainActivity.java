package com.enquick.mrgao.enquick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.enquick.mrgao.enquick.widget.WaveItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WaveItem wave = (WaveItem) findViewById(R.id.wave);
        wave.setAnimationDelay(1);
    }
}
