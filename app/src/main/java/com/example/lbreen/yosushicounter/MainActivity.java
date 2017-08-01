package com.example.lbreen.yosushicounter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTempFile(Context context);
        setContentView(R.layout.activity_main);
    }

    Double totalValue = 0.0;

    HashMap dishQuantities = new HashMap();


//    public void getTempFile(){
//        String fileName = "dish_quantities";
//        File file = null;
//        try {
//           file = File.createTempFile(fileName, null, context.getCacheDir());
//        } catch (IOException e){
//
//        }
//
//        String string = "hello world";
//
//        try {
//            FileOutputStream outputStream;
//            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
//            outputStream.write(string.getBytes());
//            outputStream.close();
//        } catch (IOException e){
//
//        }
//
//        return file;
//    }


    /**
     * Called when the user taps the Calculate button
     */
    public void addValue(View view) {
        Button b = (Button) view;
        String[] buttonText = b.getText().toString().split("£"); // Retrieve the btn text and remove '£' symbol => [ , #{value}]
        Double dishValue = Double.parseDouble(buttonText[1]); // Retrieve the dish value from the button text

//        String buttonTag = b.getTag().toString();
//        if (buttonTag == null) {
//            dishQuantities.put(buttonTag, 1);
//        } else {
//            Integer currentQuantity = dishQuantities.get(buttonTag);
//            currentQuantity += 1;
//            dishQuantities.put(buttonTag, currentQuantity);
//        }
        totalValue += dishValue; // Increment the total value
        displayValue(totalValue); // Display value to screen
    }

    public void displayValue(Double totalValue) {
        String formattedValue = "£" + String.format("%.2f", totalValue); // Format to 2 d.p.
        TextView displayedValue = (TextView) findViewById(R.id.displayedValue); // Retrieve the target text view
        displayedValue.setText(formattedValue); // Set text of target text view
    }

    public void reset(View view) {
        totalValue = 0.00;
        displayValue(totalValue);
    }

    public void review(View view) {
        Intent intent = new Intent(this, ReviewActivity.class); // Initialise a new ReviewActivity instance
        dishQuantities.put("green", 2);
        dishQuantities.put("orange", 3);
        dishQuantities.put("blue", 4);
        dishQuantities.put("purple", 5);
        intent.putExtra("dishQuantitiesHash", dishQuantities);
        startActivity(intent); // Start ReviewActivity
    }

}