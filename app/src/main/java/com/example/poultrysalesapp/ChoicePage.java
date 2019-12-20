package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ChoicePage extends AppCompatActivity {

    //Button b;
    //ImageView infoid;
    ImageView chikenimg, eggs;
    TextView chikentext, eggtexts;
    RelativeLayout chickenlayout, egglayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_page);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        //infoid = (ImageView)findViewById(R.id.infoid);

//        infoid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ChoicePage.this, "Click on the icon to choose!", Toast.LENGTH_LONG).show();
//            }
//        });

        //b = (Button)findViewById(R.id.b);


        chickenlayout = (RelativeLayout)findViewById(R.id.chickenlayout);
        egglayout = (RelativeLayout)findViewById(R.id.egglayout);

        chikenimg = (ImageView)findViewById(R.id.chikenimg);
        eggs = (ImageView)findViewById(R.id.eggs);

        chikentext = (TextView)findViewById(R.id.chikentext);
        eggtexts = (TextView)findViewById(R.id.eggtexts);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);

        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.fadein);

        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.slidedown);


//        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.fadeout);
//        b.startAnimation(animation);

        chickenlayout.startAnimation(animation2);
        egglayout.startAnimation(animation2);


        chikenimg.startAnimation(animation);
        eggs.startAnimation(animation);

        chikentext.startAnimation(animation1);
        eggtexts.startAnimation(animation1);


//        eggs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Animation animation1 = AnimationUtils.loadAnimation(ChoicePage.this,R.anim.fadein);
//                Animation animation2 = AnimationUtils.loadAnimation(ChoicePage.this,R.anim.fadeout);
//                //eggs.startAnimation(animation2);
////                eggs.setImageDrawable(android.R.drawable.omletkoriappicona);
//                eggs.setImageResource(R.drawable.omleticon);
//                eggs.startAnimation(animation1);
//            }
//        });

        chikenimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(ChoicePage.this,ChickenBreedsViewPage.class);
//                startActivity(intent);

//                Intent intent = new Intent(ChoicePage.this,ChickenBreedPage2.class); //PERFECTLY WORKING VIEWERPAGE + RECYCLER VIEW WITH DIALOGUE BOX AND BUTTONS
//                startActivity(intent);

//                Intent intent = new Intent(ChoicePage.this,FragmentType1.class);
//                startActivity(intent);

                Intent intent = new Intent(ChoicePage.this,ChickenBreedPage3.class); //THIS IS TO IMPLEMENT GRID LAYOUT LIKE HOW THE ADMIN WANTS THE APP TO BE!!!!!!
                startActivity(intent);
            }
        });

        eggs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoicePage.this,EggsBreedViewPage.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.choicepagetitlebar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

//        if (id == R.id.helpbutton)
//        {
//            Toast.makeText(ChoicePage.this, "Click on the icons to choose!", Toast.LENGTH_LONG).show();
//        }

        if (id == R.id.infobutton)
        {
//            Toast.makeText(ChoicePage.this, "Click on the icon to choose!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ChoicePage.this,AboutUsPage.class);
            startActivity(intent);
        }

        if (id == R.id.directtodeliverypage)
        {
//            Toast.makeText(ChoicePage.this, "Check for the delivery", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ChoicePage.this,DeliveryPage.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


}
