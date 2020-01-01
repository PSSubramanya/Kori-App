package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserBuyPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_CALL = 1;
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mToggle;

//    private TextView settingaddress;
//    private TextView canceladdress;

    private ImageView sharelocationicon;


    TextView pt2, pt3, pt4, pt5, pt6;
    TextView displayhenname, displayhencost;
    TextView drawerusername, draweruseremailid;
    Button userlogout;
    Button displayconfirm;
    ImageButton displaycontactus;
    //private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firestore;
    String userID;


    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_buy_page);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        displayhenname = (TextView) findViewById(R.id.displayhenname);
        displayhencost = (TextView) findViewById(R.id.displayhencost);

        displayconfirm = (Button) findViewById(R.id.displayconfirm);

        displaycontactus = (ImageButton) findViewById(R.id.displaycontactus);

        displayconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserBuyPage.this, DeliveryPage.class);
                startActivity(intent);
            }
        });


        dialog = new Dialog(UserBuyPage.this);
        dialog.setContentView(R.layout.set_location);


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


//        final String drawerstringname = dialogue_breedname_tv.getText().toString().trim();
//        String drawerstringcost = dialogue_breedcost_tv.getText().toString().trim();

//        String drawerstringname = getIntent().getStringExtra("dStringname");
//        String drawerstringname = "Irrod1";
//
//        DocumentReference documentReference = firestore.collection("Irrod Hens").document(drawerstringname);
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                drawerusername.setText(documentSnapshot.getString("Hen"));
//                displayhencost.setText(documentSnapshot.getString("Cost"));
////                drawerusername.setText(documentSnapshot.getString("User Fullname"));
////                draweruseremailid.setText(documentSnapshot.getString("Email-id"));
//            }
//        });

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

        mdrawerLayout = (DrawerLayout) findViewById(R.id.userbuypageid);
        mToggle = new ActionBarDrawerToggle(this, mdrawerLayout, R.string.open, R.string.close);

        mToggle.getDrawerArrowDrawable().setColor(Color.WHITE);

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

    public void DialToKoriOffice() {
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        intent.setData(Uri.parse("tel:7204958072"));
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
//            return;
            ActivityCompat.requestPermissions(UserBuyPage.this,
                    new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }
        else
        {
//                String dial = "tel:"+number;
            String dial = "tel:7204958072";
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
//        startActivity(intent);
    }
    public void displaycontactusoptions(View view)
    {
        PopupMenu popupMenu = new PopupMenu(UserBuyPage.this,displaycontactus);
        popupMenu.getMenuInflater().inflate(R.menu.contactusoptions,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

//                switch (menuItem.getItemId())
//                {
//
//                }

                int popupid = menuItem.getItemId();

                if (popupid == R.id.contactuscalloption)
                {
//                    Toast.makeText(UserBuyPage.this, "Make  a call", Toast.LENGTH_SHORT).show();
                    DialToKoriOffice();
                }

                if (popupid == R.id.contactusmsgoption)
                {
                    Toast.makeText(UserBuyPage.this, "Send  a message", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.displayconfirmpage2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.userLocation)
        {
//            Toast.makeText(UserBuyPage.this, "User Location", Toast.LENGTH_SHORT).show();
            dialog.show();
            if (dialog.isShowing())
            {
//                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
//                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                mapIntent.setPackage("com.google.android.apps.maps");
//                if (mapIntent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(mapIntent);
//                }
//                settingaddress = dialog.findViewById(R.id.settingaddress);
//                settingaddress.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
////                        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
//                        Uri gmmIntentUri = Uri.parse("geo:12.9258,74.8770");
//                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                        mapIntent.setPackage("com.google.android.apps.maps");
//                        if (mapIntent.resolveActivity(getPackageManager()) != null) {
//                            startActivity(mapIntent);
//                        }
//                    }
//                });

                sharelocationicon = dialog.findViewById(R.id.sharelocationicon);
                sharelocationicon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri gmmIntentUri = Uri.parse("geo:12.9258,74.8770");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        if (mapIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(mapIntent);
                        }
                    }
                });
            }
        }

        if (id == R.id.calldelivery)
        {
            Toast.makeText(UserBuyPage.this, "Call for query", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
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
