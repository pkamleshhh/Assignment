package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class OTP extends AppCompatActivity {
    ImageButton backBtn;
    TextView tvOtp,tvEnter;
    EditText otp_1,otp_2,otp_3,otp_4;
    Button btnResend,btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        //Calling the initialiser function.
        init();

        //Calling the foucus player.
        focusShift();

        //Back Button Activity.
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OTP.this,Register.class));
                finish();
            }
        });

        //Resend Button functionality.
        btnResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OTP.this, "New OTP has been sent.", Toast.LENGTH_SHORT).show();
                otp_1.setText("");
                otp_2.setText("");
                otp_3.setText("");
                otp_4.setText("");
                otp_1.requestFocus();
            }
        });

        //Submit Event.
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otp_1.getText().toString().isEmpty() || otp_2.getText().toString().isEmpty() || otp_3.getText().toString().isEmpty() || otp_4.getText().toString().isEmpty()){
                    Toast.makeText(OTP.this, "Fill all the fields.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(OTP.this, "Successfully Registered.Please Login.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(OTP.this, LoginActivity.class));
                    finish();
                }

            }
        });
    }

    //Defining the initialiser function for the ui elements.
    public void init(){
        backBtn=findViewById(R.id.back_btn);
        tvOtp=findViewById(R.id.tv_otp);
        tvEnter=findViewById(R.id.tv_enter);
        otp_1=findViewById(R.id.otp_1);
        otp_2=findViewById(R.id.otp_2);
        otp_3=findViewById(R.id.otp_3);
        otp_4=findViewById(R.id.otp_4);
        btnResend=findViewById(R.id.btn_resend);
        btnSubmit=findViewById(R.id.btn_submit);
        otp_1.requestFocus();
    }

    //Defining the focus player.
    public void focusShift(){
        otp_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                otp_2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        otp_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                otp_3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        otp_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                otp_4.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }
}
