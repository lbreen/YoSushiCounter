package com.example.lbreen.yosushicounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.id.message;
import static com.example.lbreen.yosushicounter.R.styleable.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Double totalValue = 0.0;

    /**
     * Called when the user taps the Calculate button
     */
    public void addValue(View view) {
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        String[] array = buttonText.split("£");
        Double buttonValue = Double.parseDouble(array[1]);
        totalValue += buttonValue;
        displayValue(view);
    }

    public void displayValue(View view) {
        String formattedValue = String.format("%.2f", totalValue);
        TextView textView = (TextView) findViewById(R.id.displayedValue);
        textView.setText("£" + formattedValue);
    }

}