package com.example.ajk_riset.slider;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by AJK-Riset on 8/11/2016.
 */
public class Login extends Activity{
    Button login;
    EditText username,password;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        login = (Button) findViewById(R.id.button3);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        if(pref.contains("username")){
            Intent intent = new Intent(Login.this,MainActivity.class);
            startActivity(intent);
        }
        else {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {

                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("username", username.getText().toString());
                        editor.putString("password", password.getText().toString());
                        editor.commit();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "username salah", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
