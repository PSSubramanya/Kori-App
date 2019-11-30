package com.example.poultrysalesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EggsBreedViewPage extends AppCompatActivity {

//    int[] IMAGES = {R.drawable.eggicons, R.drawable.korilogo, R.drawable.eggicons, R.drawable.korilogo, R.drawable.eggicons, R.drawable.korilogo};

    int[] IMAGES = {R.drawable.eggbreedicons, R.drawable.eggbreediconb, R.drawable.eggbreedicons, R.drawable.eggbreediconb, R.drawable.eggbreedicons, R.drawable.eggbreediconb};

    String[] NAMES = {"Egg1", "Egg2", "Egg3", "Egg4", "Egg5", "Egg6"};


    private ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eggs_breed_view_page);


        ListView listView2 = (ListView)findViewById(R.id.listView2);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fadein);

        CustomAdapter customAdapter = new CustomAdapter();
        listView2.setAdapter(customAdapter);
        listView2.startAnimation(animation);
    }

    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout2,null);

            ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
            TextView textView = (TextView)view.findViewById(R.id.textViewkori);

            imageView.setImageResource(IMAGES[i]);
            textView.setText(NAMES[i]);


            return view;
//            return null;
        }
    }
}
