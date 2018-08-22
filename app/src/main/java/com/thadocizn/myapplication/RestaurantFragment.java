package com.thadocizn.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment {

    public RestaurantFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] RestaurantList = getResources().getStringArray(R.array.restaurant);
        String[] RestaurantAddress = getResources().getStringArray(R.array.restaurant_address);
        String[] RestaurantCity = getResources().getStringArray(R.array.city_state);

        ArrayList<Place> placeList = new ArrayList<>();

        for (int i = 0; i < RestaurantList.length; i++){
            Place place = new Place(RestaurantList[i], RestaurantAddress[i],RestaurantCity[i], R.drawable.restaurant);
            placeList.add(place);
        }
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView)view;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        DividerItemDecoration itemDecor = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecor);
        recyclerView.setAdapter(new ViewRecyclerAdapter(placeList));
        return view;
    }

}
