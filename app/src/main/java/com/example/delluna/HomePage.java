package com.example.delluna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.delluna.adapter.MyRecycleViewAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.example.delluna.model.Cloth;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

import java.util.Vector;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView tvWelcome;
    TabLayout tlTab;
    Bundle extras;
    CarouselView carouselView;
    Button btnNext, btnPrev;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    int[] carouselImages = {
            R.drawable.banner_1,
            R.drawable.banner_2,
            R.drawable.banner_3,
            R.drawable.banner_4,
            };

    void init() {
        tvWelcome = findViewById(R.id.tv_welcome);
        tlTab = findViewById(R.id.tl_tab);
        extras = getIntent().getExtras();
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(carouselImages.length);
        carouselView.setImageListener(imageListener);
        btnPrev = findViewById(R.id.btn_prev);
        btnNext = findViewById(R.id.btn_next);
    }

    void setUsername() {
        String username = extras.getString("username");
        tvWelcome.setText("welcome, " + username);
    }
//    Carousel
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(carouselImages[position]);
        }
    };
//     Carousel End

//    Side Navigation
    public void setDrawerLayout() {
         drawerLayout = findViewById(R.id.drawer_layout);
         actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
         navigationView = findViewById(R.id.navigation_view);

         drawerLayout.addDrawerListener(actionBarDrawerToggle);
         actionBarDrawerToggle.syncState();

         getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
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
//    Side Navigation End

    ImageListener imageListenerNext = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(carouselImages[position+1]);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        init();
        setUsername();
        setDrawerLayout();

        btnPrev.setOnClickListener(e -> {
            carouselView.pauseCarousel();
            if(carouselView.getCurrentItem() == 0){
                carouselView.setCurrentItem(carouselView.getPageCount()-1);
            }else{
                carouselView.setCurrentItem(carouselView.getCurrentItem()-1);
            }
//            Animation animation = AnimationUtils.loadAnimation(HomePage.this, R.anim.to_right);
//            carouselView.startAnimation(animation);
//            overridePendingTransition(R.anim.to_left, R.anim.to_right);
            carouselView.playCarousel();
        });
        btnNext.setOnClickListener(e -> {
            carouselView.pauseCarousel();
            if(carouselView.getCurrentItem() == carouselView.getPageCount()-1){
                carouselView.setCurrentItem(0);
            }else{
                carouselView.setCurrentItem(carouselView.getCurrentItem()+1);
            }
//            Animation animation = AnimationUtils.loadAnimation(HomePage.this, R.anim.to_right);
//            carouselView.startAnimation(animation);
//            overridePendingTransition(R.anim.to_left, R.anim.to_right);
//            carouselView.setAnimation(animation);
            carouselView.playCarousel();
        });
    };
}