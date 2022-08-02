package com.example.delluna.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delluna.MerchandiseDetailPage;
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
        holder.tvClothName.setText(cloth.getClothName());
        holder.tvClothPrice.setText(cloth.getClothPrice() + " K");
        holder.tvClothSold.setText(cloth.getClothSold() + " pcs");

        int resourceId = this.context.getResources().getIdentifier(cloth.getClothImage(), "drawable", this.context.getPackageName());
        holder.ivClothImage.setImageResource(resourceId);

        holder.cvItemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.cvItemCard.getContext(), MerchandiseDetailPage.class);
                intent.putExtra("itemName", cloth.getClothName());
                intent.putExtra("itemPrice", "IDR " + cloth.getClothPrice() + " K");
                intent.putExtra("itemSold", "Sold: " + cloth.getClothSold());
                intent.putExtra("itemDescription", cloth.getClothDescription());
                intent.putExtra("itemImage", cloth.getClothImage());
                holder.cvItemCard.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vCloth.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvClothName, tvClothPrice, tvClothSold, tvClothDescription;
        ImageView ivClothImage;
        CardView cvItemCard;

        public ViewHolder(@NonNull @NotNull View itemView) {
//            declare dan initialisasi variabel dari widged di layout
            super(itemView);
            cvItemCard = itemView.findViewById(R.id.cv_item_card);
            tvClothName = itemView.findViewById(R.id.tv_item_name);
            tvClothPrice = itemView.findViewById(R.id.tv_item_price);
            tvClothSold = itemView.findViewById(R.id.tv_item_sold);
            ivClothImage = itemView.findViewById(R.id.iv_item_image);
        }
    }
}
