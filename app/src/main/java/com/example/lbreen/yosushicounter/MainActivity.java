package com.example.lbreen.yosushicounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static com.example.lbreen.yosushicounter.R.styleable.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final String TAG = "MyActivity";

    int value = 0;

    /** Called when the user taps the Calculate button */
    public void addValue(View view) {
        Button b = (Button)view;
        String buttonText = b.getText().toString();
        int buttonValue = Integer.parseInt(buttonText);
        Log.i(TAG, Integer.toString(buttonValue));
    }
}

//    public void onClick(View v) {
//        // 1) Possibly check for instance of first
//        Button b = (Button)v;
//        String buttonText = b.getText().toString();
//    }