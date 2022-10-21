package com.example.sos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {

    EditText login_user,login_pwd;
    Button BtnLogin;
    String user,pwd;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_user = (EditText) findViewById(R.id.username1);
        login_pwd = (EditText) findViewById(R.id.password1);
        BtnLogin = (Button) findViewById(R.id.login);

        BtnLogin.setOnClickListener(this);
        Bundle bundle = getIntent().getBundleExtra("data");
        user = bundle.getString("user");
        pwd = bundle.getString("pwd");
    }

    @Override
    public void onClick(View view) {
        String user1 = login_user.getText().toString();
        String pwd1 = login_pwd.getText().toString();
        if(user.equals(user1)&&pwd.equals(pwd1)){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(intent);
        }else{
            count++;
            if(count==3){
                BtnLogin.setEnabled(false);
                Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Login Failed"+count,Toast.LENGTH_SHORT).show();
            }
        }

    }
}