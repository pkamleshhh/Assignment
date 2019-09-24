package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.assignment.model.User;

public class Register extends AppCompatActivity {
    RadioGroup radioGroup;
    ImageButton backBtn,ibAvatar;
    TextView tvWelcome,tvInfo,tvDiffAcc,tvErrorFullName,tvErrorDob,tvErrorGender,tvErrorEmail,tvErrorPassword;
    EditText etFullName,etDob,etRegEmail,etRegPass;
    RadioButton radioMale,radioFemale;
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Calling the inialiser function.
        Init();

        //Calling the invisible function.
        invisible();

        //Back Button functionality.
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, LoginActivity.class));
                finish();
            }
        });

        //Continue button functionality.
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invisible();
                validate();
            }
        });
    }

    //Defining the initialiser function.
    public void Init(){
        backBtn=findViewById(R.id.back_btn);
        tvWelcome=findViewById(R.id.tv_welcome);
        tvInfo=findViewById(R.id.tv_info);
        ibAvatar=findViewById(R.id.avatar);
        etFullName=findViewById(R.id.et_full_name);
        etDob=findViewById(R.id.dob);
        radioGroup=findViewById(R.id.radioGroup);
        radioMale=findViewById(R.id.radio_male);
        radioFemale=findViewById(R.id.radio_female);
        etRegEmail=findViewById(R.id.et_reg_email);
        etRegPass=findViewById(R.id.et_reg_pass);
        tvDiffAcc=findViewById(R.id.tv_diff_acc);
        btnContinue=findViewById(R.id.btn_continue);
        tvErrorFullName=findViewById(R.id.tv_error_full_name);
        tvErrorDob=findViewById(R.id.tv_error_dob);
        tvErrorEmail=findViewById(R.id.tv_error_email);
        tvErrorPassword=findViewById(R.id.tv_error_password);
        tvErrorGender=findViewById(R.id.tv_error_gender);
        etFullName.requestFocus();
    }

    //Defining the visibility player.
    public void invisible(){
        tvErrorFullName.setVisibility(View.INVISIBLE);
        tvErrorDob.setVisibility(View.INVISIBLE);
        tvErrorEmail.setVisibility(View.INVISIBLE);
        tvErrorPassword.setVisibility(View.INVISIBLE);
        tvErrorGender.setVisibility(View.INVISIBLE);
    }

    //Defining the validate function.
    public void validate(){
        String fullName = etFullName.getText().toString();
        String regexFullName = ("^[a-zA-Z\\s]*$");
        String date = etDob.getText().toString();
        String email = etRegEmail.getText().toString();
        String regexEmail = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
        String password = etRegPass.getText().toString();
        String regexPassword = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
            if(fullName.isEmpty()){
                tvErrorFullName.setVisibility(View.VISIBLE);
                tvErrorFullName.setText(R.string.error_empty);
            }
            else if(!fullName.matches(regexFullName)){
                tvErrorFullName.setVisibility(View.VISIBLE);
                tvErrorFullName.setText(R.string.error_fullname);
            }
            else if(date.isEmpty()){
                tvErrorDob.setVisibility(View.VISIBLE);
                tvErrorDob.setText(R.string.error_empty);
            }
            else if(radioGroup.getCheckedRadioButtonId() == -1){
                tvErrorGender.setVisibility(View.VISIBLE);
                tvErrorGender.setText(R.string.gender);
            }
            else if(email.isEmpty()){
                tvErrorEmail.setVisibility(View.VISIBLE);
                tvErrorEmail.setText(R.string.error_empty);
            }
            else if(!email.matches(regexEmail)){
                tvErrorEmail.setVisibility(View.VISIBLE);
                tvErrorEmail.setText(R.string.error_email);
            }
            else if(password.isEmpty()){
                tvErrorPassword.setVisibility(View.VISIBLE);
                tvErrorPassword.setText(R.string.error_empty);
            }
            else if(!password.matches(regexPassword)){
                tvErrorPassword.setVisibility(View.VISIBLE);
                tvErrorPassword.setText(R.string.error_pass);
            }
            else{
                LoginActivity.sUserDetails.add(new User(fullName,date,email,password));
                startActivity(new Intent(Register.this,OTP.class));
                finish();
            }
        }
}
