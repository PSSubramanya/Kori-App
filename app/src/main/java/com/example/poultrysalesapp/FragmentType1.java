package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

//public class FragmentType1 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment_type1);
//    }
//}
public class FragmentType1 extends Fragment
{

    View v;
    private RecyclerView myrecyclerView;

    private List<Breed1> lstContact;



    public FragmentType1()
    {

    }



    //ImageView addchicken;

//    int[] IMAGES1 = {R.drawable.poultryicone, R.drawable.poultryiconf, R.drawable.poultryiconi,R.drawable.poultryiconj, R.drawable.poultryimg};
//
//    String[] PRICES1 = {"25", "35", "50", "25", "50"};
//
//    String[] NAMES1 = {"Irrod1", "Irrod2", "Irrod3", "Irrod4", "Irrod5"};


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstContact = new ArrayList<>();
        lstContact.add(new Breed1("25","Irrod1",R.drawable.poultryicone));
        lstContact.add(new Breed1("41","Irrod2",R.drawable.poultryiconf));
        lstContact.add(new Breed1("50","Irrod3",R.drawable.poultryiconi));
        lstContact.add(new Breed1("45","Irrod4",R.drawable.poultryiconj));
        lstContact.add(new Breed1("65","Irrod",R.drawable.irrodimg));
        lstContact.add(new Breed1("65","salemeg.",R.drawable.salem));
        lstContact.add(new Breed1("65","oordaeg",R.drawable.oordakori));


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);


        v = inflater.inflate(R.layout.activity_fragment_type1,null);


        myrecyclerView = (RecyclerView)v.findViewById(R.id.irrod_recycler);//
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstContact);
//
////        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
////        myrecyclerView.setLayoutManager(linearLayoutManager);
//
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerViewAdapter);
//


        //return inflater.inflate(R.layout.activity_fragment_type1,null);// working now



        return v;

//        v = inflater.inflate(R.layout.activity_fragment_type1,false);
//        return v;
//
//
//        v = inflater.inflate(R.layout.activity_fragment_type1,null);
//        return v;



    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        lstContact = new ArrayList<>();
//        lstContact.add(new Breed1("25","Irrod",R.drawable.poultryicone));
//        lstContact.add(new Breed1("41","Irrod",R.drawable.poultryiconf));
//        lstContact.add(new Breed1("50","Irrod",R.drawable.poultryiconi));
//
//    }
}