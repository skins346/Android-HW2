package com.example.user.androidhw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 Program to describe mini calculator
 Author: Kim Young Song.
 E-mail Address: infall346@gmail.com.
 Programming homework #2
 Last Changed: April 27, 2016
 */

public class Description3 extends AppCompatActivity implements View.OnClickListener{

    Button runBtn ;
    Bundle myBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description3);

        runBtn = (Button) findViewById(R.id.runBtn);
        runBtn.setOnClickListener(this);

        //receive result data form MiniCalculator
        Intent myLocalIntent = getIntent();
        // look into the bundle sent to description3 for data items
        if(myLocalIntent.getExtras() != null) {
            myBundle = myLocalIntent.getExtras();
            Double result = myBundle.getDouble("val1");
            Toast.makeText(getApplicationContext(),String.valueOf(result),Toast.LENGTH_SHORT).show();

        }
    }

    public void onClick(View view)
    {
        if(view.getId() == runBtn.getId())
            startActivity(new Intent(this,MiniCalculatorActivity.class));

    }
}
