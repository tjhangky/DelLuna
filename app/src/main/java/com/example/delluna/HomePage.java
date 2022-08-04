package com.example.delluna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.delluna.adapter.MyRecycleViewAdapter;
import com.google.android.material.tabs.TabLayout;
import com.example.delluna.model.Cloth;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.Vector;

public class HomePage extends AppCompatActivity {

    TextView tvWelcome;
    TabLayout tlTab;
    Bundle extras;
    CarouselView carouselView;
    int[] carouselImages = {R.drawable.album_aespa,
            R.drawable.album_ateez,
            R.drawable.album_ey,
            R.drawable.album_nct};

    void init() {
        tvWelcome = findViewById(R.id.tv_welcome);
        tlTab = findViewById(R.id.tl_tab);
        extras = getIntent().getExtras();
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(carouselImages.length);
        carouselView.setImageListener(imageListener);
    }

    void setUsername() {
        String username = extras.getString("username");
        tvWelcome.setText("welcome, " + username);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(carouselImages[position]);
        }
    };

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
                Intent intent = new Intent(this, MerchandisePage.class);
                intent.putExtra("username", extras.getString("username"));
                startActivity(intent);
                finish();
                break;
            }

            case(R.id.i_about): {
                Intent intent = new Intent(this, AboutPage.class);
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
    };
}
