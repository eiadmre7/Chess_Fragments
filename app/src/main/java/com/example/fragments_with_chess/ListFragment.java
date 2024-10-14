package com.example.fragments_with_chess;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private StoneAdapter adapter;
    private ArrayList<Stone> stones;
    private String[] names;
    private int[] images;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initImagesArray();
        initStonesArray();
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new StoneAdapter(getContext(),stones);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initImagesArray() {
        images=new int[6];
        images[0]=R.drawable.king_piece;
        images[1]=R.drawable.queen_piece;
        images[2]=R.drawable.bishop_piece;
        images[3]=R.drawable.knight_piece;
        images[4]=R.drawable.rook_piece;
        images[5]=R.drawable.pawn_piece;
    }

    private void initStonesArray() {
        stones=new ArrayList<>();
        names=getResources().getStringArray(R.array.stones);
        for (String name:names)
        {
            stones.add(new Stone(name));
        }
        for (int i = 0; i <images.length ; i++) {
            stones.get(i).setImg(images[i]);
        }
    }
}