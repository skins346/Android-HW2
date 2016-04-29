/**
 Program for calculation.
 Author: Kim Young Song.
 E-mail Address: infall346@gmail.com.
 Programming homework #2
 Last Changed: April 27, 2016
 */
package com.example.user.androidhw2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Stack;

public class MiniCalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btn_plus, btn_minus, btn_multi, btn_div, btn_equal, btn_clear;
    EditText edit;
    static double l_operand ; //left operand
    static double r_operand; // right operand
    static String operator;
    static double result;
    static Stack<String> stack = new Stack<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_calculator);

        edit = (EditText) findViewById(R.id.edit);
        btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(this);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_minus.setOnClickListener(this);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_div.setOnClickListener(this);
        btn_multi = (Button) findViewById(R.id.btn_multi);
        btn_multi.setOnClickListener(this);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(this);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(this);

    }

    public void onClick(View view) {

        if (btn7.getId() == view.getId()) {

            if(stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/"))  //when operator is determined
                edit.setText("");

            edit.setText(edit.getText().toString() + 7);
        }
        else if (btn8.getId() == view.getId()) {

            if(stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/"))  //when operator is determined
                edit.setText("");

            edit.setText(edit.getText().toString() + 8);
        }
        else if (btn9.getId() == view.getId()) {

            if(stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/"))  //when operator is determined
                edit.setText("");

            edit.setText(edit.getText().toString() + 9);
        }
        else if (btn4.getId() == view.getId()) {

            if(stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/"))  //when operator is determined
                edit.setText("");

            edit.setText(edit.getText().toString() + 4);
        }
        else if (btn5.getId() == view.getId()) {

            if(stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/"))  //when operator is determined
                edit.setText("");

            edit.setText(edit.getText().toString() + 5);
        }

        else if (btn6.getId() == view.getId()) {

            if(stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/"))  //when operator is determined
                edit.setText("");

            edit.setText(edit.getText().toString() + 6);
        }
        else if (btn1.getId() == view.getId()) {

            if(stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/"))  //when operator is determined
                edit.setText("");

            edit.setText(edit.getText().toString() + 1);
        }
        else if (btn2.getId() == view.getId()) {

            if(stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/"))  //when operator is determined
                edit.setText("");

            edit.setText(edit.getText().toString() + 2);
        }
        else if (btn3.getId() == view.getId()) {

            if(stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/"))  //when operator is determined
                edit.setText("");

            edit.setText(edit.getText().toString() + 3);
        }
        else if (btn0.getId() == view.getId()) {

            if(stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/"))  //when operator is determined
                edit.setText("");

            edit.setText(edit.getText().toString() + 0);
        }

        ///////////////////////////operators
        //plus operator
        else if (btn_plus.getId() == view.getId()) {

            stack.add(edit.getText().toString());
            if(stack.size()==3)     //when you enter 3 + 2 + ,then calculate show 5.
                calculate();

            stack.add("+");
        }
        //minus operator
        else if (btn_minus.getId() == view.getId()) {

            stack.add(edit.getText().toString());
            if(stack.size()==3)
                calculate();

            stack.add("-");
        }
        //multi operator
        else if (btn_multi.getId() == view.getId()) {

            stack.add(edit.getText().toString());

            // If there are "*" or "/" , have to calculate them first
            if(stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/"))  //when operator is determined
                calculate();

            stack.add("*");
        }
        //divide operator
        else if (btn_div.getId() == view.getId()) {

            stack.add(edit.getText().toString());

            if(stack.contains("+") || stack.contains("-") || stack.contains("*") || stack.contains("/"))  //when operator is determined
                calculate();

            stack.add("/");
        }
        //equal operator
        else if (btn_equal.getId() == view.getId()) {

            stack.add(edit.getText().toString());
            calculate();   //"+" and "-" are calculated when "=" is entered( except this case(-> when 3 + 2  is entered and next '+' is entered, then calculate show 5)

            Intent myIntentA1A2 = new Intent(this, Description3.class);
            // create a container to ship data
            Bundle myData = new Bundle();
            // add <key,value> data items to the container
            myData.putDouble("val1", result);
            // attach the container to the intent
            myIntentA1A2.putExtras(myData);
           // call deacripation3, tell your local listener to wait for response
            startActivityForResult(myIntentA1A2, 101);
            finish();
        }
        //clear operator
        else if(btn_clear.getId() == view.getId()){
            edit.setText("");
            while(stack.isEmpty() == false)
                stack.pop();
        }
    }

    //In this method, you calculate expression by operator
    public void calculate() {

        r_operand = Double.parseDouble(stack.pop());
        operator = stack.pop();
        l_operand = Double.parseDouble(stack.pop());

        //divide by zero exception
        if(operator.equals("/") && r_operand == 0 ) {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            edit.setText("");
            while(stack.isEmpty() == false)
                stack.pop();

            return;
        }
        if (operator.equals("+") == true)
            result = l_operand + r_operand;
        else if (operator.equals("-") == true)
            result = l_operand - r_operand;
        else if (operator.equals("*") == true)
            result = l_operand * r_operand;
        else if (operator.equals("/") == true)
            result = l_operand / r_operand;

        edit.setText(String.valueOf(result));
        stack.add(String.valueOf(result));
    }


}










