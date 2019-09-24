package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.assignment.LoginActivity.id;

public class Welcome extends AppCompatActivity {
    ImageButton backBtn,ibAvatar;
    TextView tvWelcome,tvInfo,tvFullName,tvEmail,tvDob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Initialising all the ui elements.
        init();

        //Assigning values to the Text Views.
        tvFullName.setText(String.format("Name: %s", LoginActivity.sUserDetails.get(id).getFullName()));
        tvEmail.setText(String.format("Email: %s", LoginActivity.sUserDetails.get(id).getEmail()));
        tvDob.setText(String.format("DOB: %s", LoginActivity.sUserDetails.get(id).getDate()));

        //Back button functionality.
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, LoginActivity.class));
                finish();
            }
        });
    }

    //Initialiser function Definition.
    public void init(){
        backBtn=findViewById(R.id.back_btn);
        tvWelcome=findViewById(R.id.tv_welcome);
        tvInfo=findViewById(R.id.tv_info);
        tvFullName=findViewById(R.id.tv_full_name);
        ibAvatar=findViewById(R.id.avatar);
        tvEmail=findViewById(R.id.tv_email);
        tvDob=findViewById(R.id.tv_dob);
    }
}
