package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    TextView tvLogin_head,tvSpan,tvErrorEmail,tvErrorPassword;
    EditText etEmail,etPassword;
    Button btn;
    public static int id;
    public static List<User> sUserDetails=new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Calling the initialiser function.
        init();

        //Spannable String.
        SpannableString ss = new SpannableString("Don't have an Account? REGISTER");
        ClickableSpan cs=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent=new Intent(LoginActivity.this,Register.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ForegroundColorSpan fcsBlue=new ForegroundColorSpan(getResources().getColor((android.R.color.holo_blue_dark)));
        ss.setSpan(cs,23,31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fcsBlue,23,31,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvSpan.setText(ss);
        tvSpan.setMovementMethod(LinkMovementMethod.getInstance());

        //Button Activity
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invisible();
                sUserDetails.add(new User("Kamlesh Pandey","12345","kamlesh123@gmail.com","Abcd@1234"));
                String email=etEmail.getText().toString();
                String password=etPassword.getText().toString();
                int lengthList=sUserDetails.size();
                if(email.isEmpty()){
                    tvErrorEmail.setVisibility(View.VISIBLE);
                    tvErrorEmail.setText(R.string.error_empty);
                }
                else if(password.isEmpty()){
                    tvErrorPassword.setVisibility(View.VISIBLE);
                    tvErrorPassword.setText(R.string.error_empty);
                }
                else{
                    // Loopp for checking if the user exists.
                    for(int i=0;i<lengthList;i++){
                        if(email.equals(sUserDetails.get(i).getEmail()) && password.equals(sUserDetails.get(i).getPassword())){
                            id=i;
                            Toast.makeText(LoginActivity.this, "Welcome User", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,Welcome.class));
                            finish();
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
                        }
                    }

                }

            }
        });

    }
    //Function for initialising the ui elements.
    public  void init(){
        tvLogin_head=findViewById(R.id.tv_login_head);
        etEmail=findViewById(R.id.et_email);
        etPassword=findViewById(R.id.et_password);
        btn=findViewById(R.id.btn);
        tvSpan=findViewById(R.id.tv_span);
        tvErrorEmail=findViewById(R.id.tv_error_email);
        tvErrorPassword=findViewById(R.id.tv_error_password);
    }
    //Function for setting the visibility of the error messages.
    public void invisible(){
        tvErrorEmail.setVisibility(View.INVISIBLE);
        tvErrorPassword.setVisibility(View.VISIBLE);
    }
}
