package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

//public class FragmentGridType1 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment_grid_type1);
//    }
//}



public class FragmentGridType1 extends Fragment
{


    View v;
    private RecyclerView myrecyclerView1;

    private List<IrrodGrid> lstirrod;


    public FragmentGridType1()
    {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstirrod = new ArrayList<>();
        lstirrod.add(new IrrodGrid("25","Irrod1",R.drawable.poultryicone));
        lstirrod.add(new IrrodGrid("41","Irrod2",R.drawable.henbreeda));
        lstirrod.add(new IrrodGrid("50","Irrod3",R.drawable.poultryiconi));
        lstirrod.add(new IrrodGrid("45","Irrod4",R.drawable.poultryiconj));
        lstirrod.add(new IrrodGrid("65","Irrod",R.drawable.irrodimg));
        lstirrod.add(new IrrodGrid("65","salemeg.",R.drawable.henbreedb));
        lstirrod.add(new IrrodGrid("2500","salemeg.",R.drawable.henbreedc));
        lstirrod.add(new IrrodGrid("3000","salemeg.",R.drawable.henbreedd));


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);


        v = inflater.inflate(R.layout.activity_fragment_grid_type1,null);


        myrecyclerView1 = (RecyclerView)v.findViewById(R.id.irrod_recyclergrid);//
        RecyclerViewAdapterGrid recyclerViewAdapterGrid = new RecyclerViewAdapterGrid(getContext(),lstirrod);

//        myrecyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
//        myrecyclerView1.setAdapter(recyclerViewAdapterGrid);

        myrecyclerView1.setLayoutManager(new GridLayoutManager(getContext(),2));
        myrecyclerView1.setAdapter(recyclerViewAdapterGrid);




//        return inflater.inflate(R.layout.activity_fragment_grid_type1,null);

        return v;

    }
}