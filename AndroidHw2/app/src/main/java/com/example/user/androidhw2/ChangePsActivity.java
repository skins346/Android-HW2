package com.example.user.androidhw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 Program to change password
 Author: Kim Young Song.
 E-mail Address: infall346@gmail.com.
 Programming homework #2
 Last Changed: April 27, 2016
 */
public class ChangePsActivity extends AppCompatActivity implements View.OnClickListener {

    Button okayBtn,cancelBtn;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_ps);

        okayBtn = (Button)findViewById(R.id.okayBtn);
        cancelBtn = (Button)findViewById(R.id.cancelBtn);
        input = (EditText)findViewById(R.id.input);

        okayBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);

    }
    public void onClick(View view)
    {
        if(view.getId() == okayBtn.getId()) {

            if(input.getText().toString().length() != 4)    //Exception handling for new password input
            {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                input.setText("");
            }

            else
            {
                MainActivity.toEdit.remove("Password");     //Change the password
                MainActivity.toEdit.putString("Password", input.getText().toString());
                MainActivity.toEdit.commit();
                Toast.makeText(getApplicationContext(),"Changed",Toast.LENGTH_SHORT).show();
                finish();
            }


        }
        }
}

