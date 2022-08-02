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
import com.example.delluna.model.Other;

import org.jetbrains.annotations.NotNull;

import java.util.Vector;

public class OtherAdapter extends RecyclerView.Adapter<OtherAdapter.ViewHolder>{
    private Context context;
    private Vector<Other> vOther;

    public OtherAdapter(Context context) {
        this.context = context;
    }

    public void setvOther(Vector<Other> vOther) {
        this.vOther = vOther;
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
    public void onBindViewHolder(@NonNull @NotNull OtherAdapter.ViewHolder holder, int position) {
//      set variabel value dari view kita
        Other other = vOther.get(position);
        holder.tvItemName.setText(other.getOtherName());
        holder.tvItemPrice.setText(other.getOtherPrice() + " K");
        holder.tvItemSold.setText(other.getOtherSold() + " pcs");

        int resourceId = this.context.getResources().getIdentifier(other.getOtherImage(), "drawable", this.context.getPackageName());
        holder.ivItemImage.setImageResource(resourceId);

        holder.cvItemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.cvItemCard.getContext(), MerchandiseDetailPage.class);
                intent.putExtra("itemName", other.getOtherName());
                intent.putExtra("itemPrice", "IDR " + other.getOtherPrice() + " K");
                intent.putExtra("itemSold", "Sold: " + other.getOtherSold());
                intent.putExtra("itemDescription", other.getOtherDescription());
                intent.putExtra("itemImage", other.getOtherImage());
                holder.cvItemCard.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vOther.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemName, tvItemPrice, tvItemSold;
        ImageView ivItemImage;
        CardView cvItemCard;

        public ViewHolder(@NonNull @NotNull View itemView) {
//            declare dan initialisasi variabel dari widged di layout
            super(itemView);
            cvItemCard = itemView.findViewById(R.id.cv_item_card);
            tvItemName = itemView.findViewById(R.id.tv_item_name);
            tvItemPrice = itemView.findViewById(R.id.tv_item_price);
            tvItemSold = itemView.findViewById(R.id.tv_item_sold);
            ivItemImage = itemView.findViewById(R.id.iv_item_image);
        }
    }
}
