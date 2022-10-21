package com.example.sos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.BufferUnderflowException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    EditText signup_user,signup_pwd;
    Button Btnsign;
    String regularExpression="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!#&%])[A-Za-z\\d@$!#&%]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signup_user=(EditText) findViewById(R.id.username);
        signup_pwd= (EditText) findViewById(R.id.password);
        Btnsign = (Button) findViewById(R.id.sign);

        Btnsign.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String Username = signup_user.getText().toString();
        String Password = signup_pwd.getText().toString();
        if(validatePassword(Password)){
            Toast.makeText(getBaseContext(),"valid Password",Toast.LENGTH_LONG).show();
            Bundle bundle = new Bundle();
            bundle.putString("user",Username);
            bundle.putString("pwd",Password);
            Intent it = new Intent(this,login.class);
            it.putExtra("data",bundle);
            startActivity(it);
        }
        else {
            Toast.makeText(getBaseContext(),"Invalid Password",Toast.LENGTH_LONG).show();
        }

    }

    private boolean validatePassword(String pw) {
        Pattern pat = Pattern.compile(regularExpression);
        Matcher matcher = pat.matcher(pw);
        return matcher.matches();
    }
}