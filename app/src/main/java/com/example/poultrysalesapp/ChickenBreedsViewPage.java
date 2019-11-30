package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChickenBreedsViewPage extends AppCompatActivity {

//    int[] IMAGES = {R.drawable.poultryicone, R.drawable.poultryiconf, R.drawable.poultryiconi,R.drawable.poultryiconj, R.drawable.poultryimg};

    int[] IMAGES = {R.drawable.kori1, R.drawable.kori1, R.drawable.kori1, R.drawable.kori1, R.drawable.kori1};

    String[] NAMES = {"Kori1", "Kori2", "Kori3", "Kori4", "Kori5"};




    private ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken_breeds_view_page);

        ListView listView = (ListView)findViewById(R.id.listView1);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fadein);

        CustomAdapter customAdapter = new CustomAdapter();


        listView.setAdapter(customAdapter);
        listView.startAnimation(animation);


//        ListAdapter myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
//        ListAdapter myAdapter = new ArrayAdapter<>(this,R.layout.customlayout);
//        listView.setAdapter(myAdapter);
//
//        listView.startAnimation(animation);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0)
                {
                    Intent intent = new Intent(ChickenBreedsViewPage.this,IrrodBreed.class);
                    startActivity(intent);
                }

                if (position == 1)
                {
                    Intent intent = new Intent(ChickenBreedsViewPage.this,SalemBreed.class);
                    startActivity(intent);
                }

                if (position == 2)
                {
                    Intent intent = new Intent(ChickenBreedsViewPage.this,OordaKori.class);
                    startActivity(intent);
                }
            }
        });





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
            view = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
            TextView textView = (TextView)view.findViewById(R.id.textViewkori);

            imageView.setImageResource(IMAGES[i]);
            textView.setText(NAMES[i]);


            return view;
//            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.addhenbreed,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.addchickenbreed)
        {
            openDialogue();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openDialogue()
    {
        AdminInfoDialogue adminInfoDialogue = new AdminInfoDialogue();
        adminInfoDialogue.show(getSupportFragmentManager(),"Admin Info Dialogue");
    }
}
