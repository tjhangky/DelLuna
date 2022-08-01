package com.example.delluna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin;

    void init() {
        etEmail = findViewById(R.id.et_email);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(e -> {
            Intent intent = new Intent(this, HomePage.class);
            intent.putExtra("email", etEmail.getText().toString());
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();



    }
}