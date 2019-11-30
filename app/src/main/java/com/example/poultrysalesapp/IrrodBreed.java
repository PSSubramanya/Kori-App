package com.example.poultrysalesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class IrrodBreed extends AppCompatActivity {

    int[] IMAGES1 = {R.drawable.poultryicone, R.drawable.poultryiconf, R.drawable.poultryiconi,R.drawable.poultryiconj, R.drawable.poultryimg};

    String[] PRICES1 = {"25", "35", "50", "25", "50"};

    String[] NAMES1 = {"Irrod1", "Irrod2", "Irrod3", "Irrod4", "Irrod5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irrod_breed);


        ListView listView = (ListView)findViewById(R.id.listView3);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fadein);

//        IrrodBreed.CustomAdapter customAdapter = new IrrodBreed().CustomAdapter();

        CustomAdapter customAdapter = new CustomAdapter();



        listView.setAdapter(customAdapter);
        listView.startAnimation(animation);





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0)
                {
                    Intent intent = new Intent(IrrodBreed.this,ViewAndSellChickenPage.class);
                    startActivity(intent);
                }

                if (position == 1)
                {
//                    Intent intent = new Intent(IrrodBreed.this,SalemBreed.class);
//                    startActivity(intent);
                }

                if (position == 2)
                {
//                    Intent intent = new Intent(IrrodBreed.this,OordaKori.class);
//                    startActivity(intent);
                }
            }
        });
    }


    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return IMAGES1.length;
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
            view = getLayoutInflater().inflate(R.layout.breedcustomlayout,null);

            ImageView imageView = (ImageView)view.findViewById(R.id.BreedchickenimageView);
            TextView textView = (TextView)view.findViewById(R.id.textViewkorinames);
            TextView textView1 = (TextView)view.findViewById(R.id.textViewkoriprice);

            imageView.setImageResource(IMAGES1[i]);
            textView1.setText(PRICES1[i]);
            textView.setText(NAMES1[i]);


            return view;
//            return null;
        }
    }
}
