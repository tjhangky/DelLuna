package com.example.delluna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MerchandiseDetailPage extends AppCompatActivity {

    TextView tvItemId, tvItemName, tvItemPrice, tvItemSold;
    Bundle extras;


    public void init() {
        tvItemId = findViewById(R.id.tv_item_id);
        tvItemName = findViewById(R.id.tv_item_name);
        tvItemPrice = findViewById(R.id.tv_item_price);
        tvItemSold = findViewById(R.id.tv_item_sold);
        extras = getIntent().getExtras();

    }

    public void setItem() {
        String itemId = extras.getString("itemId");
        String itemName = extras.getString("itemName");
        String itemPrice = extras.getString("itemPrice");
        String itemSold = extras.getString("itemSold");

        tvItemId.setText(itemId);
        tvItemName.setText(itemName);
        tvItemPrice.setText(itemPrice);
        tvItemSold.setText(itemSold);
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
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchandise_detail);

        init();
        setItem();
    }
}