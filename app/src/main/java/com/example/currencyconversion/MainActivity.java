package com.example.currencyconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    double dollarsEntered;
    double convertedCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText dollars = (EditText) findViewById(R.id.txtDollars);
        final RadioButton euros = (RadioButton) findViewById(R.id.radEuros);
        final RadioButton pesos = (RadioButton) findViewById(R.id.radPesos);
        final RadioButton canDollar = (RadioButton) findViewById(R.id.radCanDollars);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                dollarsEntered = Double.parseDouble(dollars.getText().toString());
                if(dollarsEntered <= 100000) {
                    if(euros.isChecked()) {
                        convertedCurrency = dollarsEntered * 0.916569; // Dollar to Euro Conversion
                        result.setText("$" + String.format("%,.2f", dollarsEntered) + " American Dollars is $" + String.format("%,.2f", convertedCurrency) + " Euros");
                    }
                    if(pesos.isChecked()) {
                        convertedCurrency = dollarsEntered * 23.6694; // Dollar to Mexican Peso Conversion
                        result.setText("$" + String.format("%,.2f", dollarsEntered) + " American Dollars is $" + String.format("%,.2f", convertedCurrency) + " Mexican Pesos");
                    }
                    if(canDollar.isChecked()) {
                        convertedCurrency = dollarsEntered * 1.39029; // Dollar to Canadian Dollar Conversion
                        result.setText("$" + String.format("%,.2f", dollarsEntered) + " American Dollars is $" + String.format("%,.2f", convertedCurrency) + " Canadian Dollars");
                    }
                } else {
                    Toast.makeText(MainActivity.this,"Dollars must be less than $100,000.00", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
