package com.example.user.androidhw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 Program to describe tip calculator
 Author: Kim Young Song.
 E-mail Address: infall346@gmail.com.
 Programming homework #2
 Last Changed: April 27, 2016
 */

public class Description2 extends AppCompatActivity implements View.OnClickListener{

    Button runBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description2);

        runBtn = (Button) findViewById(R.id.runBtn);
        runBtn.setOnClickListener(this);

    }

    public void onClick(View view)
    {
        if(view.getId() == runBtn.getId())
            startActivity(new Intent(this,TipCalculatorActivity.class));
    }
}
