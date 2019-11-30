package com.example.poultrysalesapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.List;

public class UserLoginOrRegisterDialogue extends AppCompatActivity
{

    //private Context mContexta;
//    Dialog dialoga;
//    Context mContext1a;


//    public UserLoginOrRegisterDialogue(Context mContext1a) {
//        this.mContext1a = mContext1a;
////        this.mData1 = mData1;
//    }


    TabHost host;
    Button cancelbtn1, cancelbtn2, regbtn, logbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_or_register_dialogue);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        cancelbtn1 = (Button)findViewById(R.id.cancelbtn1);
        cancelbtn2 = (Button)findViewById(R.id.cancelbtn2);
        regbtn = (Button)findViewById(R.id.regbtn);
        logbtn = (Button)findViewById(R.id.logbtn);



        host = (TabHost)findViewById(R.id.tabHost);
        host.setup();


        //Register Tab
        TabHost.TabSpec spec = host.newTabSpec("Signup");

        spec.setContent(R.id.tab1);
        spec.setIndicator("Signup");
        host.addTab(spec);
        host.getTabWidget().getChildAt(host.getCurrentTab()).setBackgroundColor(Color.parseColor("#0E4D92"));
        TextView tv = (TextView) host.getTabWidget().getChildAt(host.getCurrentTab()).findViewById(android.R.id.title);
        tv.setTextColor(Color.WHITE);




        spec =host.newTabSpec("Login");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Login");
        host.addTab(spec);
        host.getTabWidget().getChildAt(host.getCurrentTab()).setBackgroundColor(Color.parseColor("#0E4D92"));
        TextView tv1 = (TextView) host.getTabWidget().getChildAt(host.getCurrentTab()).findViewById(android.R.id.title);
        tv1.setTextColor(Color.WHITE);


        host.setOnTabChangedListener(new TabHost.OnTabChangeListener()
        {
            @Override
            public void onTabChanged(String tabId)
            {
                int tab = host.getCurrentTab();
                for (int i = 0; i < host.getTabWidget().getChildCount(); i++)
                {
                    // When tab is not selected
//                    host.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#444444"));
                    host.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#FFFFFF"));

                    TextView tv = (TextView) host.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
//                    tv.setTextColor(Color.WHITE);
                    tv.setTextColor(Color.BLACK);

                }
                // When tab is selected
                host.getTabWidget().getChildAt(host.getCurrentTab()).setBackgroundColor(Color.parseColor("#0E4D92"));
                TextView tv = (TextView) host.getTabWidget().getChildAt(tab).findViewById(android.R.id.title);
//                tv.setTextColor(Color.BLACK);
                tv.setTextColor(Color.WHITE);
            }
        });



        //Functionalities of login/register dialog
        cancelbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLoginOrRegisterDialogue.this,ChickenBreedPage2.class);
                startActivity(intent);
                finish();
            }
        });

        cancelbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLoginOrRegisterDialogue.this,ChickenBreedPage2.class);
                startActivity(intent);
                finish();
            }
        });


//        regbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(UserLoginOrRegisterDialogue.this,ChickenBreedPage2.class);
//                startActivity(intent);
//            }
//        });


//        logbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                LayoutInflater mInflater = LayoutInflater.from(mContext1a);
//                //view = mInflater.inflate(R.layout.henregdialog,getParent());
//                dialoga = new Dialog();
//                dialoga.setContentView(R.layout.dialogue_hen);
//
//
//                dialoga.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            }
//        });


        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLoginOrRegisterDialogue.this,Registration_Form.class);
                startActivity(intent);
            }
        });


    }
}
