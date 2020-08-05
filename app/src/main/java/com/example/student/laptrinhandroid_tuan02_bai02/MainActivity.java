package com.example.student.laptrinhandroid_tuan02_bai02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_Celcius, et_Fahrenheit;
    private Button bt_ConvertToC, bt_ConvertToF, bt_Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        ChuyenCSangF();
        ChuyenFSangC();
        Clear();
    }

    private void AnhXa(){
        et_Celcius = (EditText) findViewById(R.id.et_Celcius);
        et_Fahrenheit = (EditText) findViewById(R.id.et_Fahrenheit);

        bt_Clear = (Button) findViewById(R.id.bt_Clear);
        bt_ConvertToC = (Button) findViewById(R.id.bt_ConvertToC);
        bt_ConvertToF = (Button) findViewById(R.id.bt_ConvertToF);
    }
    private int convertCtoF(int doC){
        return doC * 9/5 + 32;
    }
    private int convertFtoC(int doF){
        return (doF - 32) * 5/9;
    }
    private void ChuyenFSangC(){
        bt_ConvertToC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_Fahrenheit.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Nhập độ F", Toast.LENGTH_SHORT).show();
                    return;
                }
                et_Celcius.setText(String.valueOf(convertFtoC(Integer.parseInt(et_Fahrenheit.getText().toString()))));
            }
        });
    }

    private void ChuyenCSangF(){
        bt_ConvertToF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_Celcius.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Nhập độ C", Toast.LENGTH_SHORT).show();
                    return;
                }
                et_Fahrenheit.setText(String.valueOf(convertCtoF(Integer.parseInt(et_Celcius.getText().toString()))));
            }
        });
    }
    private void Clear(){
        bt_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_Fahrenheit.setText("");
                et_Celcius.setText("");
            }
        });
    }
}
