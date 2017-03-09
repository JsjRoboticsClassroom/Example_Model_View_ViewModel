package com.jsjrobotics.examplemvvm.feature1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jsjrobotics.examplemvvm.R;

public class Feature1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, new Feature1Fragment())
                    .commit();
        }
    }
}
