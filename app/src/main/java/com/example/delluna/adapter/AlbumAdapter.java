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
import com.example.delluna.model.Album;

import org.jetbrains.annotations.NotNull;

import java.util.Vector;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{
    private Context context;
    private Vector<Album> vAlbum;

    public AlbumAdapter(Context context) {
        this.context = context;
    }

    public void setvAlbum(Vector<Album> vAlbum) {
        this.vAlbum = vAlbum;
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
    public void onBindViewHolder(@NonNull @NotNull AlbumAdapter.ViewHolder holder, int position) {
//      set variabel value dari view kita
        Album album = vAlbum.get(position);
        holder.tvItemName.setText(album.getAlbumName());
        holder.tvItemPrice.setText(album.getAlbumPrice() + " K");
        holder.tvItemSold.setText(album.getAlbumSold() + " pcs");

        int resourceId = this.context.getResources().getIdentifier(album.getAlbumImage(), "drawable", this.context.getPackageName());
        holder.ivItemImage.setImageResource(resourceId);

        holder.cvItemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.cvItemCard.getContext(), MerchandiseDetailPage.class);
                intent.putExtra("itemName", album.getAlbumName());
                intent.putExtra("itemPrice", "IDR " + album.getAlbumPrice() + " K");
                intent.putExtra("itemSold", "Sold: " + album.getAlbumSold());
                intent.putExtra("itemDescription", album.getAlbumDescription());
                intent.putExtra("itemImage", album.getAlbumImage());
                holder.cvItemCard.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vAlbum.size();
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
