package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class UserBuyPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mToggle;
    TextView pt2,pt3,pt4,pt5,pt6;
    TextView drawerusername, draweruseremailid;
    Button userlogout;
    //private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firestore;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_buy_page);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

//        pt2 = (TextView)findViewById(R.id.pt2);
//        pt3 = (TextView)findViewById(R.id.pt3);
//        pt4 = (TextView)findViewById(R.id.pt4);
//        pt5 = (TextView)findViewById(R.id.pt5);
//        pt6 = (TextView)findViewById(R.id.pt6);

//        drawerusername = (TextView)findViewById(R.id.drawerusername);
//        draweruseremailid = (TextView)findViewById(R.id.draweruseremailid);

//        userID = firebaseAuth.getCurrentUser().getUid();
//
//        DocumentReference documentReference = firestore.collection("Users").document(userID);
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                pt2.setText(documentSnapshot.getString("User Fullname"));
//                pt3.setText(documentSnapshot.getString("Phone No"));
//                pt4.setText(documentSnapshot.getString("Alternative No"));
//                pt5.setText(documentSnapshot.getString("Email-id"));
//                pt6.setText(documentSnapshot.getString("Address"));
////                drawerusername.setText(documentSnapshot.getString("User Fullname"));
////                draweruseremailid.setText(documentSnapshot.getString("Email-id"));
//            }
//        });

        mdrawerLayout = (DrawerLayout)findViewById(R.id.userbuypageid);
        mToggle = new ActionBarDrawerToggle(this,mdrawerLayout,R.string.open,R.string.close);
        mdrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        //userlogout = (Button)findViewById(R.id.userlogout);

//        userlogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                firebaseAuth.signOut();
//                finish();
//                startActivity(new Intent(getApplicationContext(),UserLoginOrRegisterDialogue.class));
//            }
//        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id = menuItem.getItemId();


        if (id == R.id.logoutuserbuy)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(getApplicationContext(),UserLoginOrRegisterDialogue.class));
        }

        if (id == R.id.draweruserinfo)
        {
            Intent intent = new Intent(UserBuyPage.this,DrawerUserInfoPage.class);
            startActivity(intent);
        }

        DrawerLayout mdrawerLayout = (DrawerLayout)findViewById(R.id.userbuypageid);
        mdrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
