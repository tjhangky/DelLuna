package com.example.delluna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_new extends AppCompatActivity {

    ImageView btnMenu;
    LinearLayout sideNav, content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);

        btnMenu = findViewById(R.id.btn_menu);
        sideNav = findViewById(R.id.side_nav);
        content = findViewById(R.id.main_content);

        btnMenu.setOnClickListener(e -> {
            if(sideNav.getVisibility() == LinearLayout.INVISIBLE) {
                sideNav.setVisibility(LinearLayout.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(MainActivity_new.this, R.anim.to_right);
                sideNav.startAnimation(anim);
                content.setVisibility(LinearLayout.INVISIBLE);

            } else {
                Animation anim = AnimationUtils.loadAnimation(MainActivity_new.this, R.anim.to_left);
                sideNav.startAnimation(anim);
                sideNav.setVisibility(LinearLayout.INVISIBLE);
                content.setVisibility(LinearLayout.VISIBLE);
            }


        });

    }
}