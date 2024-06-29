package com.example.sweet.ui;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweet.R;
import com.example.sweet.adapters.CartAdapter;
import com.example.sweet.models.CartModel;

import java.util.ArrayList;
import java.util.List;
public class MyCartFragment extends Fragment {
    List<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;
    public MyCartFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);
        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        list.add(new CartModel(R.drawable.milkyoolong,"Sipariş 1","100₺","3.9"));
        list.add(new CartModel(R.drawable.fav1,"Sipariş 2","40₺","4.0"));
        list.add(new CartModel(R.drawable.fav3,"Sipariş 3","40₺","3.7"));
        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);
        return view;
    }
}