package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class ChickenBreedPage3 extends AppCompatActivity {

    TextView irrodtypechicken, salemtypechicken, oordatypechicken;
    ViewPager viewPager;
    PageViewAdapter pageViewAdapter;
    ImageView addchicken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken_breed_page3);


        setupViewPager2();
    }

    private void setupViewPager2()
    {
        PageViewAdapter adapter = new PageViewAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentGridType1());
        adapter.addFragment(new FragmentGridType2());
        adapter.addFragment(new FragmentGridType3());

        ViewPager vp1 = (ViewPager)findViewById(R.id.viewpager11);
        vp1.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs11);

        tabLayout.setupWithViewPager(vp1);

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
