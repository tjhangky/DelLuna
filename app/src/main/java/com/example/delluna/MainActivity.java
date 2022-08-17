package com.example.delluna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin, btnTest;

    boolean validateEmail(String email){
//        if(email.matches("")){
//            Toast.makeText(this, "Email must be filled!", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if(!email.endsWith(".com")){
//            Toast.makeText(this, "Email must end with '.com'!", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if(!email.contains("@")){
//            Toast.makeText(this, "Email must contain '@'!", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if(email.contains(".@") || email.contains("@.") || email.contains(".@.")){
//            Toast.makeText(this, "Email must not contain '@' and '.' adjacent each other!", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        return true;
    }

    boolean validatePassword(String password){
//        if(password.matches("")){
//            Toast.makeText(this, "Password must be filled!", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if(!password.matches("[A-Za-z0-9]*")){
//            Toast.makeText(this, "Password must be alphanumeric, only alphabet and number allowed!", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if(!password.matches(".*[A-Za-z].*")){
//            Toast.makeText(this, "Password must contain alphabet!", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if(!password.matches(".*[0-9].*")){
//            Toast.makeText(this, "Password must contain number!", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        // set button color
        btnLogin.setBackgroundColor(getResources().getColor(R.color.purple_200));

        btnLogin.setOnClickListener(e -> {
            // change color button temporaly
            btnLogin.setBackgroundColor(getResources().getColor(R.color.purple_700));
            // Delay of 2 seconds (200 ms) before changing back
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnLogin.setBackgroundColor(getResources().getColor(R.color.purple_200)); // change color back
                }
            }, 200);

            String email, password;
            email = etEmail.getText().toString();
            password = etPassword.getText().toString();

            if (validateEmail(email) && validatePassword(password)) {
                Intent intent = new Intent(MainActivity.this, HomePage.class);
//                intent.putExtra("username", email.substring(0, email.indexOf("@")));
                intent.putExtra("username", email);
                startActivity(intent);
                finish();
            } else {
                return;
            }
        });

       //onhover?

    }
}