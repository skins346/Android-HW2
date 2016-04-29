package com.example.user.androidhw2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

/**
 Program to check user password(login)
 Author: Kim Young Song.
 E-mail Address: infall346@gmail.com.
 Programming homework #2
 Last Changed: April 27, 2016
 */

public class LoginActivity extends Activity {

    EditText ps1,ps2,ps3,ps4;  //password editext
    Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getInit();

        intent = new Intent(this, MainActivity.class);   //from LoginActivity -> to MainActicity

        //When ps4 is entered, check password is valid
        ps4.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override  // when ps4 is entered
            public void afterTextChanged(Editable arg0) {

                if(ps4.getText().toString().equals(""))
                    return;

                // check all 4 edit text is entered
                if(ps1.getText().toString().equals("") == false  && ps2.getText().toString().equals("") == false
                        && ps3.getText().toString().equals("") == false && ps4.getText().toString().equals("") == false    )
                {
                    if(MainActivity.sh_Pref != null && MainActivity.sh_Pref.contains("Password")){
                        String input ="";
                        input = ps1.getText().toString() + ps2.getText().toString() + ps3.getText().toString() + ps4.getText().toString();

                        if(input.equals(MainActivity.sh_Pref.getString("Password","")))  //when  password is correct ;
                        {
                            MainActivity.logOn=1;
                            finish();
                            startActivity(intent);
                        }
                        else  //password incorrect
                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                            //reset password
                            ps1.setText("");
                            ps2.setText("");
                            ps3.setText("");
                            ps4.setText("");
                    }
                }

                //when password is not entered completely
                else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

                    if(ps1.getText().toString().equals("") == false)
                        ps1.setText("");
                    if(ps2.getText().toString().equals("") == false)
                        ps2.setText("");
                    if(ps3.getText().toString().equals("") == false)
                        ps3.setText("");
                    if(ps4.getText().toString().equals("") == false)
                        ps4.setText("");
                }
            }

        });

    }

    //initiate 4 password edit text
    public void getInit() {
        ps1 = (EditText) findViewById(R.id.ps1);
        ps2 = (EditText) findViewById(R.id.ps2);
        ps3 = (EditText) findViewById(R.id.ps3);
        ps4 = (EditText) findViewById(R.id.ps4);
    }

}
