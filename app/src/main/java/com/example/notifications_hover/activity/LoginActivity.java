package com.example.notifications_hover.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notifications_hover.R;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.login_username_input);
        password=findViewById(R.id.login_password_input);
        loginButton=findViewById(R.id.login_btn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String username_str=username.getText().toString();
        String password_str=password.getText().toString();

        if(TextUtils.isEmpty(username_str)){
            Toast.makeText(this,"please enter your username",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(password_str)){
            Toast.makeText(this,"please enter your password",Toast.LENGTH_LONG).show();
        }
        else if(!username_str.equals("hover") && !password_str.equals("hover")){
            Toast.makeText(this,"username or password is wrong !",Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
