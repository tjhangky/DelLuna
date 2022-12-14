package com.example.delluna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MerchandiseDetailPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView tvItemName, tvItemPrice, tvItemSold, tvItemDescription;
    EditText etItemQty;
    Button btnBuy;
    ImageView ivItemImage;
    Bundle extras;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;


    public void init() {
        tvItemName = findViewById(R.id.tv_item_detail_name);
        tvItemPrice = findViewById(R.id.tv_item_detail_price);
        tvItemSold = findViewById(R.id.tv_item_detail_sold);
        tvItemDescription = findViewById(R.id.tv_item_detail_description);
        ivItemImage = findViewById(R.id.iv_item_detail_image);
        etItemQty = findViewById(R.id.et_item_detail_qty);
        extras = getIntent().getExtras();
        btnBuy = findViewById(R.id.btn_buy);
    }

    public void setItem() {
        String itemName = extras.getString("itemName");
        String itemPrice = extras.getString("itemPrice");
        String itemSold = extras.getString("itemSold");
        String itemDescription = extras.getString("itemDescription");
        String itemImage = extras.getString("itemImage");

        tvItemName.setText(itemName);
        tvItemPrice.setText(itemPrice);
        tvItemSold.setText(itemSold);
        tvItemDescription.setText(itemDescription);

        int resourceId = getResources().getIdentifier(itemImage, "drawable", getPackageName());
        ivItemImage.setImageResource(resourceId);
    }

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
            case(R.id.i_home): {
                Intent intent = new Intent(this, HomePage.class);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchandise_detail_page);

        init();
        setDrawerLayout();
        setItem();
        // set button color
        btnBuy.setBackgroundColor(getResources().getColor(R.color.purple_200));

        btnBuy.setOnClickListener(e -> {
            // change color button temporaly
            btnBuy.setBackgroundColor(getResources().getColor(R.color.purple_700));
            // Delay of 2 seconds (200 ms) before changing back
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnBuy.setBackgroundColor(getResources().getColor(R.color.purple_200)); // change color back
                }
            }, 200);

            int qty;

            if(etItemQty.getText().toString().isEmpty()) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MerchandiseDetailPage.this);
                builder1.setMessage("Quantity must be filled!");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Try Again",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();


//                Toast.makeText(this, "Quantity must be filled!", Toast.LENGTH_SHORT).show();
                return;
            }

            qty = Integer.parseInt(etItemQty.getText().toString());
            if(qty <= 0){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MerchandiseDetailPage.this);
                builder1.setMessage("Quantity must be greater than 0!");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Try Again",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();


//                Toast.makeText(this, "Quantity must be greater than 0!", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, MerchandisePage.class);
            intent.putExtra("username", extras.getString("username"));
            startActivity(intent);
            finish();
        });
    }
}