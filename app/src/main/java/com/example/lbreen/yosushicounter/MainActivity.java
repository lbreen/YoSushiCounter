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
        String[] buttonText = b.getText().toString().split("£"); // Retrieve the btn text and remove '£' symbol => [ , #{value}]
        Double buttonValue = Double.parseDouble(buttonText[1]); // Convert btn value from string to double (float)
        totalValue += buttonValue; // Increment the total value
        displayValue(view); // Display value to screen
    }

    public void displayValue(View view) {
        String formattedValue = String.format("%.2f", totalValue); // Format to 2 d.p.
        TextView textView = (TextView) findViewById(R.id.displayedValue); // Retrieve the target text view
        textView.setText("£" + formattedValue); // Set text of target text view
    }

}