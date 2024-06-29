package com.example.sweet.activities;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sweet.R;
import com.example.sweet.adapters.DetailedDrinkAdapter;
import com.example.sweet.models.DetailedDrinkModel;

import java.util.ArrayList;
import java.util.List;
public class DetailedDrinkActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DetailedDrinkModel> detailedDrinkModelList;
    DetailedDrinkAdapter drinkAdapter;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_drink);
        String type = getIntent().getStringExtra("type");
        CollapsingToolbarLayout collapsingToolbarLayout
                = findViewById(R.id.collapsing_toolbar);
        if (type != null) {
            collapsingToolbarLayout.setTitle(type);
        }
        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDrinkModelList= new ArrayList<>();
        drinkAdapter = new DetailedDrinkAdapter(detailedDrinkModelList);
        recyclerView.setAdapter(drinkAdapter);

        if (type != null && type.equalsIgnoreCase("Sıcak Kahve")){
            detailedDrinkModelList.add(new DetailedDrinkModel(R.drawable.fav1,
                    "White Chocolate Mocha",
                    "Kahve,Kahve,Kahve","4.4","40TL",
                    "10.00-19.00"));
            detailedDrinkModelList.add(new DetailedDrinkModel(R.drawable.fav2,
                    "Pumpkin Spice Latte",
                    "Kahve,Kahve,Kahve","4.4","40TL",
                    "10.00-19.00"));
            detailedDrinkModelList.add(new DetailedDrinkModel(R.drawable.fav3,
                    "Türk Kahvesi",
                    "Kahve,Kahve,Kahve","4.4","40TL",
                    "10.00-19.00"));
            drinkAdapter.notifyDataSetChanged();
        }
        if (type != null && type.equalsIgnoreCase("Soğuk Kahve")){
            detailedDrinkModelList.add(new DetailedDrinkModel(R.drawable.icedlatte,
                    "Iced Latte",
                    "Kahve,Kahve,Kahve","4.4",
                    "40TL","10.00-19.00"));
            detailedDrinkModelList.add(new DetailedDrinkModel(R.drawable.coldbrew,
                    "Cold Brew",
                    "Kahve,Kahve,Kahve","4.4",
                    "40TL","10.00-19.00"));
            detailedDrinkModelList.add(new DetailedDrinkModel(R.drawable.icedmocha,
                    "Iced Mocha",
                    "Kahve,Kahve,Kahve","4.4","40TL",
                    "10.00-19.00"));
            drinkAdapter.notifyDataSetChanged();
        }

        if (type != null && type.equalsIgnoreCase("Smootie")){
            detailedDrinkModelList.add(new DetailedDrinkModel(R.drawable.berry,
                    "Berry Smootie",
                    "","4.4","40TL","10.00-19.00"));
            detailedDrinkModelList.add(new DetailedDrinkModel(R.drawable.rainbow,
                    "Rainbow Smootie",
                    "frambuaz,muz,çilek","4.4","40TL",
                    "10.00-19.00"));
            detailedDrinkModelList.add(new DetailedDrinkModel(R.drawable.karamel,
                    " Karamel Smootie",
                    "","4.4","40TL","10.00-19.00"));
            drinkAdapter.notifyDataSetChanged();
        }
        if (type != null && type.equalsIgnoreCase("Bitki Çayı")){

            imageView.setImageResource(R.drawable.bitki);
            detailedDrinkModelList.add(new DetailedDrinkModel(R.drawable.milkyoolong,
                    "Milky Oolong",
                    "Süt buharında fermente edilmiş, sınırlı üretim Tie Guan Yin yaprakları",
                    "4.4","100TL","10.00-19.00"));
            detailedDrinkModelList.add(new DetailedDrinkModel(R.drawable.apricotoolongjpg,
                    "Apricot Peach Oolong",
                    "Şeftali ve kayısının oolong'la tatlı birleşimi","4.4",
                    "100TL","10.00-19.00"));
            detailedDrinkModelList.add(new DetailedDrinkModel(R.drawable.fasnanlicay,
                    "Fas Nane Çayı",
                    " Fas'ın çay kültürüne has taze naneli yeşil çay",
                    "4.4","40TL","10.00-19.00"));
            drinkAdapter.notifyDataSetChanged();
        }
    }
}