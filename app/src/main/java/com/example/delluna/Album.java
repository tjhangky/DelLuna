package com.example.delluna;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.delluna.adapter.AlbumAdapter;

import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Album#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Album extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Album() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Album.
     */
    // TODO: Rename and change types and number of parameters
    public static Album newInstance(String param1, String param2) {
        Album fragment = new Album();
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
        return inflater.inflate(R.layout.fragment_album, container, false);
    }

    // list item
    RecyclerView rvAlbum;
    AlbumAdapter albumAdapter;
    Vector<com.example.delluna.model.Album> vAlbum;
    //

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // RecycleView
        rvAlbum = view.findViewById(R.id.rv_album);
        albumAdapter = new AlbumAdapter(this.getContext());
        loadData();
        albumAdapter.setvAlbum(vAlbum);

        rvAlbum.setAdapter(albumAdapter);
        rvAlbum.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //
    }

    private void loadData() {
        vAlbum = new Vector<>();
        vAlbum.add(new com.example.delluna.model.Album("A001", "Aespa", 50, 100, "Lorem Ipsum", "album_aespa"));
        vAlbum.add(new com.example.delluna.model.Album("A002", "Ateez", 50, 100, "Lorem Ipsum", "album_ateez"));
        vAlbum.add(new com.example.delluna.model.Album("A003", "NCT", 50, 100, "Lorem Ipsum", "album_nct"));
        vAlbum.add(new com.example.delluna.model.Album("A004", "EY", 50, 100, "Lorem Ipsum", "album_ey"));
        vAlbum.add(new com.example.delluna.model.Album("A005", "Red Velvet", 50, 100, "Lorem Ipsum", "album_rv"));
        vAlbum.add(new com.example.delluna.model.Album("A006", "SK", 50, 100, "Lorem Ipsum", "album_sk"));
        vAlbum.add(new com.example.delluna.model.Album("A007", "TXT", 50, 100, "Lorem Ipsum", "album_txt"));
    }
}