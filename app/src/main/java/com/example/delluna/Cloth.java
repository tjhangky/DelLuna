package com.example.delluna;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.delluna.adapter.ClothAdapter;
import com.example.delluna.adapter.MyRecycleViewAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cloth#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cloth extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Cloth() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cloth.
     */
    // TODO: Rename and change types and number of parameters
    public static Cloth newInstance(String param1, String param2) {
        Cloth fragment = new Cloth();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

//    list item
    RecyclerView rvCloth;
    ClothAdapter clothAdapter;
    Vector<com.example.delluna.model.Cloth> vCloth;
//

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
        return inflater.inflate(R.layout.fragment_cloth, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // RecycleView
        rvCloth = view.findViewById(R.id.rv_cloth);
        clothAdapter = new ClothAdapter(this.getContext());
        loadData();
        clothAdapter.setvCloth(vCloth);

        rvCloth.setAdapter(clothAdapter);
        rvCloth.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //
    }

    private void loadData() {
        vCloth = new Vector<>();
        vCloth.add(new com.example.delluna.model.Cloth("C001", "BlackPink Tee", 50, 100, "Lorem Ipsum", "tee_bp"));
        vCloth.add(new com.example.delluna.model.Cloth("C002", "EXO Tee", 50, 100, "Lorem Ipsum", "tee_exo"));
        vCloth.add(new com.example.delluna.model.Cloth("C003", "Treasure Sweater", 50, 100, "Lorem Ipsum", "sweater_treasure"));
        vCloth.add(new com.example.delluna.model.Cloth("C004", "RedVelvet Tee", 50, 100, "Lorem Ipsum", "tee_rv"));
        vCloth.add(new com.example.delluna.model.Cloth("C005", "SuperJunior Hoodie", 50, 100, "Lorem Ipsum", "hoodie_suju"));
    }
}