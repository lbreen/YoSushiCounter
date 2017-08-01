package com.example.lbreen.yosushicounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
    }

    public void changeText(View view) {
        Intent intent = getIntent();
        HashMap dishQuantities = (HashMap<String, Integer>) intent.getSerializableExtra("dishQuantitiesHash");
        Iterator<Map.Entry<String, Integer>> entries = dishQuantities.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            Integer value = entry.getValue();
            TextView testText = (TextView) findViewById(R.id.testText);
            testText.setText(Integer.toString(value));
        }

    }

}
