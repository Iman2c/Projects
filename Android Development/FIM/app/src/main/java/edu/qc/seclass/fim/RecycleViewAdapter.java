package edu.qc.seclass.fim;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseUser;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<Floors> floorList;
    Context context;

    public RecycleViewAdapter(List<Floors> floorList, Context context) {
        this.floorList = floorList;
        this.context = context;
    }

    // method for filtering our recyclerview items.
    public void filterList(List<Floors> filterllist) {
        // below line is to add our filtered
        // list in our floor list.
        floorList = filterllist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.floor_filler, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvFloorType.setText(floorList.get(position).getFloorType());
        holder.tvColor.setText(floorList.get(position).getColor());
        holder.tvSize.setText(floorList.get(position).getSize());
        holder.tvBrand.setText(floorList.get(position).getBrand());
        holder.tvType.setText(floorList.get(position).getType());
        holder.tvPrice.setText(floorList.get(position).getPrice());
        holder.tvStock.setText(floorList.get(position).getStock());
        holder.tvSpecies.setText(floorList.get(position).getSpecies());
        holder.tvWaterResistant.setText(floorList.get(position).getWaterResistant());
        holder.tvWaterproof.setText(floorList.get(position).getWaterproof());

        Glide.with(context).load(floorList.get(position).getImageUrl()).into(holder.ivImg);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean employeeStatus = Boolean.valueOf(ParseUser.getCurrentUser().getBoolean("isEmployee"));

                if(employeeStatus) {
                    Intent intent = new Intent(context, AddEdit.class);
                    intent.putExtra("id", floorList.get(position).getId());
                    context.startActivity(intent);
                }
                else {
                    Toast.makeText(context, "Access Denied. Only Employees can Edit", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.parentLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return floorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImg;
        TextView tvFloorType;
        TextView tvColor;
        TextView tvSize;
        TextView tvBrand;
        TextView tvType;
        TextView tvPrice;
        TextView tvStock;
        TextView tvSpecies;
        TextView tvWaterResistant;
        TextView tvWaterproof;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImg = itemView.findViewById(R.id.ivImg);
            tvFloorType = itemView.findViewById(R.id.tvFloorType);
            tvColor = itemView.findViewById(R.id.tvColor);
            tvSize = itemView.findViewById(R.id.tvSize);
            tvBrand = itemView.findViewById(R.id.tvBrand);
            tvType = itemView.findViewById(R.id.tvType);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvStock = itemView.findViewById(R.id.tvStock);
            tvSpecies = itemView.findViewById(R.id.tvSpecies);
            tvWaterResistant = itemView.findViewById(R.id.tvWaterResistant);
            tvWaterproof = itemView.findViewById(R.id.tvWaterproof);
            parentLayout = itemView.findViewById(R.id.floorLayout);
        }
    }
}
