package com.example.huilv;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RateCalcActivity extends AppCompatActivity {

    float rate= 0f;
    String TAG= "rateCalc";
    EditText inp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_calc);
        String title = getIntent().getStringExtra("title");
        rate=getIntent().getFloatExtra("rate",0.0f);

        Log.i(TAG, "onCreate: title=" +title);
        Log.i(TAG, "onCreate: rate=" +rate);
        ((TextView)findViewById(R.id.title2)).setText(title);
        inp2=(EditText)findViewById(R.id.inp2);
        inp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable editable) {
                TextView show = findViewById(R.id.show2);
                if(editable.length()>0){
                    float val = Float.parseFloat(editable.toString());
                    show.setText(val + " RMB ==> "+ (val*100/rate));
                }else{
                    show.setText("");
                }
            }
        });
    }
}
