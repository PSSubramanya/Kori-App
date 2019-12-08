package com.example.poultrysalesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class DrawerUserInfoPage extends AppCompatActivity {

    TextView pt2,pt3,pt4,pt5,pt6;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firestore;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_user_info_page);


        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        pt2 = (TextView)findViewById(R.id.pt2);
        pt3 = (TextView)findViewById(R.id.pt3);
        pt4 = (TextView)findViewById(R.id.pt4);
        pt5 = (TextView)findViewById(R.id.pt5);
        pt6 = (TextView)findViewById(R.id.pt6);


        userID = firebaseAuth.getCurrentUser().getUid();

        DocumentReference documentReference = firestore.collection("Users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                pt2.setText(documentSnapshot.getString("User Fullname"));
                pt3.setText(documentSnapshot.getString("Phone No"));
                pt4.setText(documentSnapshot.getString("Alternative No"));
                pt5.setText(documentSnapshot.getString("Email-id"));
                pt6.setText(documentSnapshot.getString("Address"));
//                drawerusername.setText(documentSnapshot.getString("User Fullname"));
//                draweruseremailid.setText(documentSnapshot.getString("Email-id"));
            }
        });

    }
}
