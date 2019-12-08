package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registration_Form extends AppCompatActivity {

    public static final String TAG = "TAG";
    Button registeruserinfo, canceluserinfo;
    EditText fullnameuser, phoneuser, altphoneuser, useremialid, userhomeaddress;
    private FirebaseAuth firebaseAuth;
    FirebaseFirestore fstore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__form);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        firebaseAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        registeruserinfo = (Button)findViewById(R.id.registeruserinfo);
        canceluserinfo = (Button)findViewById(R.id.canceluserinfo);

        fullnameuser = (EditText)findViewById(R.id.fullnameuser);
        phoneuser = (EditText)findViewById(R.id.phoneuser);
        altphoneuser = (EditText)findViewById(R.id.altphoneuser);
        useremialid = (EditText)findViewById(R.id.useremialid);
        userhomeaddress = (EditText)findViewById(R.id.userhomeaddress);

        registeruserinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullname = fullnameuser.getText().toString().trim();
                String phonenumber = phoneuser.getText().toString().trim();
                String alternatephonenumber = altphoneuser.getText().toString().trim();
                String emailaddress = useremialid.getText().toString().trim();
                String homeAddress = userhomeaddress.getText().toString().trim();

                userID = firebaseAuth.getCurrentUser().getUid();
                DocumentReference documentReference = fstore.collection("Users").document(userID);
                Map<String,Object> user = new HashMap<>();
//                user.put("User Fullname",fullnameuser);
//                user.put("Phone No.",phoneuser);
//                //user.put("Alternative No.",altphoneuser);
//                user.put("Email-id",useremialid);
//                user.put("Address",userhomeaddress);
                user.put("User Fullname",fullname);
                user.put("Phone No",phonenumber);
                user.put("Alternative No",alternatephonenumber);
                user.put("Email-id",emailaddress);
                user.put("Address",homeAddress);
                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "onSuccess: User Profile is created for" + userID);
                    }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure: " + e.toString());
                        }

                });
                Toast.makeText(Registration_Form.this,"User Info Registered",Toast.LENGTH_SHORT);
                Intent intent = new Intent(Registration_Form.this,UserBuyPage.class);
                startActivity(intent);
            }

        });

//        Toast.makeText(Registration_Form.this,"User Info Registered",Toast.LENGTH_SHORT);
//        Intent intent = new Intent(Registration_Form.this,UserBuyPage.class);
//        startActivity(intent);



        canceluserinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration_Form.this,UserLoginOrRegisterDialogue.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
