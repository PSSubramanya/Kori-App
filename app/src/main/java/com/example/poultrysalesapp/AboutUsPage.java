package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class AboutUsPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mdrawerLayout1;
    private ActionBarDrawerToggle mToggle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_page);


//        mdrawerLayout1 = (DrawerLayout) findViewById(R.id.userbuypageid);
//        mToggle = new ActionBarDrawerToggle(this, mdrawerLayout, R.string.open, R.string.close);
//        mdrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);


        mdrawerLayout1 = (DrawerLayout) findViewById(R.id.aboutuspageid);
        mToggle1 = new ActionBarDrawerToggle(this, mdrawerLayout1, R.string.open, R.string.close);

        mToggle1.getDrawerArrowDrawable().setColor(Color.WHITE);

        mdrawerLayout1.addDrawerListener(mToggle1);
        mToggle1.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id = menuItem.getItemId();


        if (id == R.id.ratingicon)
        {
//            firebaseAuth.signOut();
//            finish();
//            startActivity(new Intent(getApplicationContext(),UserLoginOrRegisterDialogue.class));
        }

        if (id == R.id.feedbackicon)
        {
//            Intent intent = new Intent(UserBuyPage.this,DrawerUserInfoPage.class);
//            startActivity(intent);
        }

        if (id == R.id.helpicon)
        {
            Intent intent = new Intent(AboutUsPage.this,HelpAndTipsPage.class);
            startActivity(intent);
        }


        if (id == R.id.aboutusicon)
        {
            Intent intent = new Intent(AboutUsPage.this,AppInfoPage.class);
            startActivity(intent);
        }


        if (id == R.id.codedevelopericon)
        {
            Intent intent = new Intent(AboutUsPage.this,CreditsPage.class);
            startActivity(intent);
        }

        DrawerLayout mdrawerLayout = (DrawerLayout)findViewById(R.id.aboutuspageid);
        mdrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
