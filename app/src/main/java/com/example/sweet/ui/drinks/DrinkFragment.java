package com.example.sweet.ui.drinks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sweet.R;
import com.example.sweet.adapters.DrinkAdapter;
import com.example.sweet.models.DrinkModel;

import java.util.ArrayList;
import java.util.List;
public class DrinkFragment extends Fragment {
    RecyclerView recyclerView;
    List<DrinkModel> drinkModels;
    DrinkAdapter drinkAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.drink_fragment, container, false);
        recyclerView = root.findViewById(R.id.drink_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        drinkModels = new ArrayList<>();
        drinkModels.add(new DrinkModel(R.drawable.kahve,
                "Sıcak Kahve","30% İndirim",
                "White Chocolate Mocha,Pumpkin Spice Latte,Türk Kahvesi",
                "Sıcak Kahve"));
        drinkModels.add(new DrinkModel(R.drawable.bitki,
                "Bitki Çayı","20% İndirim",
                "Milky Oolong,Apricot Peach Oolong,Çay",
                "Bitki Çayı"));
        drinkModels.add(new DrinkModel(R.drawable.icedcoffee,
                "Soğuk Kahve","50% İndirim",
                "Kahve,Kahve,Kahve","Soğuk Kahve"));
        drinkModels.add(new DrinkModel(R.drawable.smootie,
                "Smootie","10% İndirim",
                "Kahve,Kahve,çağdaş","Smootie"));
        drinkAdapter = new DrinkAdapter(getContext(),drinkModels);
        recyclerView.setAdapter(drinkAdapter);
        drinkAdapter.notifyDataSetChanged();
        return root;
    }
}