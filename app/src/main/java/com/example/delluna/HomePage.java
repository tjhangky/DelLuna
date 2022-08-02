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
import android.widget.TextView;

import com.example.delluna.adapter.MyRecycleViewAdapter;
import com.google.android.material.tabs.TabLayout;
import com.example.delluna.model.Cloth;

import java.util.Vector;

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

//    list item
    RecyclerView rvCloth;
    MyRecycleViewAdapter myRecycleViewAdapter;
    Vector<Cloth> vCloth;
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        init();
        setUsername();

        rvCloth = findViewById(R.id.rv_cloth);
        myRecycleViewAdapter = new MyRecycleViewAdapter(this);
        loadData();
        myRecycleViewAdapter.setvCloth(vCloth);

        rvCloth.setAdapter(myRecycleViewAdapter);
        rvCloth.setLayoutManager(new LinearLayoutManager(this));

    };

    private void loadData() {
        vCloth = new Vector<>();
        vCloth.add(new Cloth("C001", "BlackPink Tee", 50, 100, "Lorem Ipsum", "tee_bp"));
        vCloth.add(new Cloth("C002", "EXO Tee", 50, 100, "Lorem Ipsum", "tee_exo"));
        vCloth.add(new Cloth("C003", "Treasure Sweater", 50, 100, "Lorem Ipsum", "sweater_treasure"));
        vCloth.add(new Cloth("C004", "RedVelvet Tee", 50, 100, "Lorem Ipsum", "tee_rv"));
        vCloth.add(new Cloth("C005", "SuperJunior Hoodie", 50, 100, "Lorem Ipsum", "hoodie_suju"));
    }
}
