package com.example.delluna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MerchandiseDetailPage extends AppCompatActivity {

    TextView tvItemId, tvItemName, tvItemPrice, tvItemSold, tvItemDescription;
    EditText etItemQty;
    Button btnBuy;
    ImageView ivItemImage;
    Bundle extras;


    public void init() {
//        tvItemId = findViewById(R.id.tv_item_id);
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
//        String itemId = extras.getString("itemId");
        String itemName = extras.getString("itemName");
        String itemPrice = extras.getString("itemPrice");
        String itemSold = extras.getString("itemSold");
        String itemDescription = extras.getString("itemDescription");
        String itemImage = extras.getString("itemImage");


//        tvItemId.setText(itemId);
        tvItemName.setText(itemName);
        tvItemPrice.setText(itemPrice);
        tvItemSold.setText(itemSold);
        tvItemDescription.setText(itemDescription);

        int resourceId = getResources().getIdentifier(itemImage, "drawable", getPackageName());
        ivItemImage.setImageResource(resourceId);
    }

//    Sidebar Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_merchandise, menu);
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
        setContentView(R.layout.activity_merchandise_detail_page);

        init();
        setItem();

        btnBuy.setOnClickListener(e -> {
            int qty;

            if(etItemQty.getText().toString().isEmpty()) {
                Toast.makeText(this, "Quantity must be filled!", Toast.LENGTH_SHORT).show();
                return;
            }

            qty = Integer.parseInt(etItemQty.getText().toString());
            if(qty <= 0){
                Toast.makeText(this, "Quantity must be greater than 0!", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, MerchandisePage.class);
            intent.putExtra("username", extras.getString("username"));
            startActivity(intent);
            finish();
        });
    }
}