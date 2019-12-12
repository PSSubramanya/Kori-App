package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class ChickenBreedPage2 extends AppCompatActivity {

    TextView irrodtypechicken, salemtypechicken, oordatypechicken;
    ViewPager viewPager;
    PageViewAdapter pageViewAdapter;
    ImageView addchicken;

//    int[] IMAGES1 = {R.drawable.poultryicone, R.drawable.poultryiconf, R.drawable.poultryiconi,R.drawable.poultryiconj, R.drawable.poultryimg};
//
//    String[] PRICES1 = {"25", "35", "50", "25", "50"};
//
//    String[] NAMES1 = {"Irrod1", "Irrod2", "Irrod3", "Irrod4", "Irrod5"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken_breed_page2);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setLogo(android.R.drawable.ic_menu_info_details);

        setupViewPager();

    }


    private void setupViewPager()
    {
        PageViewAdapter adapter = new PageViewAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentType1());
        adapter.addFragment(new FragmentType2());
        adapter.addFragment(new FragmentType3());

        ViewPager vp = (ViewPager)findViewById(R.id.viewpager);
        vp.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(vp);
//        tabLayout.setBackgroundColor(getResources().getColor(R.color.lightblue));
//        tabLayout.setBackgroundColor(getColor(R.color.lightblue));
//        tabLayout.setBackgroundColor(getColor(R.drawable.tab_bg_color));
        tabLayout.setBackgroundColor(getColor(R.color.darkgrey));
        tabLayout.setTabTextColors(getColor(R.color.EmraldGreen),getColor(R.color.colorWhite));

        tabLayout.getTabAt(0).setText("Irrod");
        tabLayout.getTabAt(1).setText("Salem");
        tabLayout.getTabAt(2).setText("Oorda");

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
