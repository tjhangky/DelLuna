package com.example.delluna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class HomePage extends AppCompatActivity {

    TextView tvWelcome;
    TabLayout tlTab;
    ViewPager2 vpFragment;
    Bundle extras;
    FragmentAdapter fragmentAdapter;

    void init() {
        tvWelcome = findViewById(R.id.tv_welcome);
        tlTab = findViewById(R.id.tl_tab);
//        vpFragment = findViewById(R.id.vp_fragment);
        extras = getIntent().getExtras();
//        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
//        vpFragment.setAdapter(fragmentAdapter);
    }

    void setUsername() {
        String username = extras.getString("username");
        tvWelcome.setText("welcome, " + username);
    }

//    Sidebar Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case(R.id.i_merchandise): {
                Intent intent = new Intent(this, Merchandise.class);
                intent.putExtra("username", extras.getString("username"));
                startActivity(intent);
                finish();
                break;
            }

            case(R.id.i_about): {
                Intent intent = new Intent(this, About.class);
                intent.putExtra("username", extras.getString("username"));
                startActivity(intent);
                finish();
                break;
            }

            case(R.id.i_logout): {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
        return true;
    }
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        init();
        setUsername();
    }
}