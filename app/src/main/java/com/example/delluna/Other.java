package com.example.delluna;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.delluna.adapter.OtherAdapter;

import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Other#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Other extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Other() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Other.
     */
    // TODO: Rename and change types and number of parameters
    public static Other newInstance(String param1, String param2) {
        Other fragment = new Other();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other, container, false);
    }

    // list item
    RecyclerView rvOther;
    OtherAdapter otherAdapter;
    Vector<com.example.delluna.model.Other> vOther;
    //

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // RecycleView
        rvOther = view.findViewById(R.id.rv_other);
        otherAdapter = new OtherAdapter(this.getContext());
        loadData();
        otherAdapter.setvOther(vOther);

        rvOther.setAdapter(otherAdapter);
        rvOther.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //
    }

    private void loadData() {
        vOther = new Vector<>();
        vOther.add(new com.example.delluna.model.Other("M001", "NCT Lightstick", 50, 100, "Limited Edition NCT Lightstick", "lightstick_nct"));
        vOther.add(new com.example.delluna.model.Other("M002", "BlackPink Lightstick", 50, 100, "Limited Edition BlackPink Lightstick", "lightstick_bp"));
        vOther.add(new com.example.delluna.model.Other("M003", "TWICE Photocard", 50, 100, "Limited Edition Twice Photocard", "photocard_twice"));
        vOther.add(new com.example.delluna.model.Other("M004", "ST Poster", 50, 100, "Limited Edition ST Poster", "poster_st"));
        vOther.add(new com.example.delluna.model.Other("M005", "BTS Tumbler", 50, 100, "Limited Edition BTS Tumbler", "tumbler_bts"));
    }

}