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

public class EventFragment extends Fragment {

    public EventFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] eventList = getResources().getStringArray(R.array.events);
        String[] eventAddress = getResources().getStringArray(R.array.event_dates);
        String[] eventCity = getResources().getStringArray(R.array.city_state);

        ArrayList<Place> placeList = new ArrayList<>();

        for (int i = 0; i < eventList.length; i++){
            Place place = new Place(eventList[i], eventAddress[i],eventCity[i], R.drawable.event);
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
