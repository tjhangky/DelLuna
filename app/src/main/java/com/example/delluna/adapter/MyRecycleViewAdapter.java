package com.example.delluna.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delluna.HomePage;
import com.example.delluna.MerchandiseDetailPage;
import com.example.delluna.MerchandisePage;
import com.example.delluna.R;
import com.example.delluna.model.Cloth;

import org.jetbrains.annotations.NotNull;

import java.util.Vector;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {
    private Context context;
    private Vector<Cloth> vCloth;

    public MyRecycleViewAdapter(Context context) {
        this.context = context;
    }

    public void setvCloth(Vector<Cloth> vCloth) {
        this.vCloth = vCloth;
    }

    @NonNull
    @NotNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
//        masukin layout ke dalam context di kelas ini
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
//      set variabel value dari view kita
        Cloth cloth = vCloth.get(position);
        holder.tvClothId.setText("ID: " + cloth.getClothId());
        holder.tvClothName.setText("Name: " + cloth.getClothName());
        holder.tvClothPrice.setText("Price: " + cloth.getClothPrice() + " K");
        holder.tvClothSold.setText("Sold: " + cloth.getClothSold());


        holder.cvItemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.cvItemCard.getContext(), MerchandiseDetailPage.class);
                intent.putExtra("itemId", "ID: " + cloth.getClothId());
                intent.putExtra("itemName", "Name: " + cloth.getClothName());
                intent.putExtra("itemPrice", "Price: " + cloth.getClothPrice() + " K");
                intent.putExtra("itemSold", "Sold: " + cloth.getClothSold());
                holder.cvItemCard.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vCloth.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvClothId, tvClothName, tvClothPrice, tvClothSold, tvClothDescription;
        CardView cvItemCard;

        public ViewHolder(@NonNull @NotNull View itemView) {
//            declare dan initialisasi variabel dari widged di layout
            super(itemView);
            cvItemCard = itemView.findViewById(R.id.cv_item_card);
            tvClothId = itemView.findViewById(R.id.tv_cloth_id);
            tvClothName = itemView.findViewById(R.id.tv_cloth_name);
            tvClothPrice = itemView.findViewById(R.id.tv_cloth_price);
            tvClothSold = itemView.findViewById(R.id.tv_cloth_sold);
        }
    }
}
