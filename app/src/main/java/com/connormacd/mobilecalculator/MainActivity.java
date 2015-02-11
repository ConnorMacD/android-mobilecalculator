package com.connormacd.mobilecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    //Number + Decimal Buttons
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonDec;

    //Number variables for calculation
    TextView textResult;
    double result = 0.0; //Result of calculation
    String inStr = "0"; //current input string
    char lastOper = ' '; //last operator used.

    //Operator Buttons
    Button buttonEqual;
    Button buttonMinus;
    Button buttonMulti;
    Button buttonDivid;
    Button buttonPlus;
    Button buttonDel;
    Button buttonNeg;
    Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variable for the text result
        final TextView textResult = (TextView) findViewById(R.id.textResult);

        //variables for number and decimal buttons
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        button7 = (Button) findViewById(R.id.btn7);
        button8 = (Button) findViewById(R.id.btn8);
        button9 = (Button) findViewById(R.id.btn9);
        button0 = (Button) findViewById(R.id.btn0);
        buttonDec = (Button) findViewById(R.id.btnDec);

        //clearing buttons
        buttonClear = (Button) findViewById(R.id.btnClear);
        buttonDel = (Button) findViewById(R.id.btnDel);

        //Operator Variables
        buttonNeg = (Button) findViewById(R.id.btnNeg);
        buttonPlus = (Button) findViewById(R.id.btnPlus);
        buttonMinus = (Button) findViewById(R.id.btnSub);
        buttonDivid = (Button) findViewById(R.id.btnDiv);
        buttonMulti = (Button) findViewById(R.id.btnMulti);
        buttonEqual = (Button) findViewById(R.id.btnEqual);

        //Listener for all buttons to respond to presses
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //the main switch for all button presses
                switch (v.getId()) {
                    case R.id.btn1:
                    case R.id.btn2:
                    case R.id.btn3:
                    case R.id.btn4:
                    case R.id.btn5:
                    case R.id.btn6:
                    case R.id.btn7:
                    case R.id.btn8:
                    case R.id.btn9:
                    case R.id.btn0:
                        String inDigit = ((Button) v).getText().toString();
                        if (inStr == "0") {
                            inStr = inDigit;
                        } else if (inStr == "-0") {
                            inStr = "-" + inDigit;
                        } else if (inStr.length() < 10) {
                            inStr += inDigit;
                        }
                        textResult.setText(inStr);

                        //If enter was the last operator, then this is a new equation.
                        if (lastOper == '=') {
                            result = 0; //clear results
                            lastOper = ' ';//clear last operator
                        }
                        break;

                    case R.id.btnDec:
                        if (!inStr.contains(".")) {
                            inStr = Calculator.appendDecimal(inStr);
                        }
                        textResult.setText(inStr);
                        break;

                    case R.id.btnNeg:
                        inStr = !inStr.contains("-") ? Calculator.appendNegative(inStr) : Calculator.removeNegative(inStr);
                        textResult.setText(inStr);
                        break;

                    case R.id.btnPlus:
                        result = Calculator.calculate(inStr, lastOper, result);
                            textResult.setText(Double.toString(result));
                            inStr = "0";
                            lastOper = '+';
                            break;

                    case R.id.btnSub:
                        result = Calculator.calculate(inStr, lastOper, result);
                        textResult.setText(Double.toString(result));
                        inStr = "0";
                        lastOper = '-';
                        break;

                    case R.id.btnDiv:
                        result = Calculator.calculate(inStr, lastOper, result);
                        textResult.setText(Double.toString(result).toString());
                        inStr = "0";
                        lastOper = '/';
                        break;


                    case R.id.btnMulti:
                        result = Calculator.calculate(inStr, lastOper, result);
                        textResult.setText(Double.toString(result));
                        inStr = "0";
                        lastOper = '*';
                        break;

                    case R.id.btnEqual:
                        result = Calculator.calculate(inStr, lastOper, result);
                        textResult.setText(Double.toString(result));
                        inStr = "0";
                        lastOper = '=';
                        break;

                    //Clear button clears all used variables to simulate a clean slate
                    case R.id.btnClear:
                        result = 0.0;
                        inStr = "0";
                        lastOper = ' ';
                        textResult.setText(inStr);
                        break;

                    //Delete button only deletes if there's more than 1 number, and if there isn't, just replace it with 0.
                    case R.id.btnDel:
                        if (inStr != "0" && inStr != "NaN" && inStr.length() != 1) {
                            inStr = inStr.substring(0, inStr.length()-1);
                            textResult.setText(inStr);
                        } else if (inStr.length() == 1) {
                            inStr = "0";
                            textResult.setText(inStr);
                        } else if (textResult.getText() == "NaN") {
                            inStr = "0";
                            textResult.setText(inStr);
                        }

                }

            }
        };

        //setting listeners for buttons
        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDec.setOnClickListener(listener);
        buttonNeg.setOnClickListener(listener);
        buttonMulti.setOnClickListener(listener);
        buttonDivid.setOnClickListener(listener);
        buttonPlus.setOnClickListener(listener);
        buttonMinus.setOnClickListener(listener);
        buttonEqual.setOnClickListener(listener);
        buttonClear.setOnClickListener(listener);
        buttonDel.setOnClickListener(listener);



    }
}
