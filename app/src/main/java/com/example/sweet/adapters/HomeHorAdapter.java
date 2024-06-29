package com.example.sweet.adapters;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sweet.R;
import com.example.sweet.models.HomeHorModel;
import com.example.sweet.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;
public class HomeHorAdapter extends
        RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {
    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;
    boolean check = true;
    boolean select = true;
    int row_index = -1;
    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec,
                          Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder
                (LayoutInflater.from(parent.getContext()).inflate
                        (R.layout.home_horizontal_item,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        if (check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.kurabiye
                    , "Çikolata Parçacıklı Kurabiye",
                    "10.00-23.00", "Kurabiye", "Min-100TL"));
            homeVerModels.add(new HomeVerModel(R.drawable.tarto,
                    "Meyveli Tartolet",
                    "10.00-23.00", "4.0", "Min-100TL"));
            homeVerModels.add(new HomeVerModel(R.drawable.elmalikurabiye,
                    "Elmalı Kurabiye",
                    "10.00-23.00", "3.0", "Min-100TL"));
            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                row_index = currentPosition;
                notifyDataSetChanged();
                ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                switch (currentPosition) {
                    case 0:
                        homeVerModels.add(new HomeVerModel(R.drawable.kurabiye,
                                "Çikolata Parçacıklı Kurabiye",
                                "10.00-23.00", "4.0", "Min-100TL"));
                        homeVerModels.add(new HomeVerModel(R.drawable.tarto,
                                "Meyveli Tartolet",
                                "10.00-23.00", "4.0", "Min-100TL"));
                        homeVerModels.add(new HomeVerModel(R.drawable.elmalikurabiye,
                                "Elmalı Kurabiye",
                                "10.00-23.00", "4.0", "Min-100TL"));
                        break;
                    case 1:
                        homeVerModels.add(new HomeVerModel(R.drawable.t1,
                                "Karamelli Trileçe",
                                "10.00-23.00", "4.0", "Min-100TL"));
                        homeVerModels.add(new HomeVerModel(R.drawable.sutlac1,
                                "Sütlaç",
                                "10.00-23.00", "4.0", "Min-100TL"));
                        homeVerModels.add(new HomeVerModel(R.drawable.soguk,
                                "Soğuk Baklava",
                                "10.00-23.00", "4.0", "Min-100TL"));
                        break;
                    case 2:
                        homeVerModels.add(new HomeVerModel(R.drawable.suffle,
                                "Sufle",
                                "10.00-23.00", "4.0", "Min-100TL"));
                        homeVerModels.add(new HomeVerModel(R.drawable.brownm,
                                "Browni ",
                                "10.00-23.00", "4.0", "Min-100TL"));
                        homeVerModels.add(new HomeVerModel(R.drawable.prof1,
                                "Fıstıklı Profiterol",
                                "10.00-23.00", "4.0", "Min-100TL"));
                        break;
                    case 3:
                        homeVerModels.add(new HomeVerModel(R.drawable.fstkl_baklava,
                                "Fıstıklı Baklava",
                                "10.00-23.00", "4.0", "Min-100TL"));
                        homeVerModels.add(new HomeVerModel(R.drawable.kunefe,
                                "Fıstıklı Künefe",
                                "10.00-23.00", "4.0", "Min-100TL"));
                        homeVerModels.add(new HomeVerModel(R.drawable.sekert,
                                "Fıstıklı Şekerpare",
                                "10.00-23.00", "4.0",
                                "Min-100TL"));
                        break;
                }
                updateVerticalRec.callBack(currentPosition, homeVerModels);
            }
        });
        if (row_index == position) {
            holder.cardView.setBackgroundResource(R.drawable.change_bg);
        } else {
            holder.cardView.setBackgroundResource(R.drawable.default_bg);
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
