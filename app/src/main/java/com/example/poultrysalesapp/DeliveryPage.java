package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class DeliveryPage extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_page);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.display_confirm_page_titlebar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.usernotification)
        {
            Toast.makeText(DeliveryPage.this, "User Notification", Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.calldelivery)
        {
            DialToKoriOffice2();
//            Toast.makeText(DeliveryPage.this, "Call to Kori Office", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void DialToKoriOffice2() {
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
            ActivityCompat.requestPermissions(DeliveryPage.this,
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
}

//this page should be shown with done button and check box only if something is ordered,
// ELSE the same page should be displayed without any checkbox and button and with a caption saying "Nothing is ordered"

//Make the DONE Button default untill checkbox is pressed
// (also try to get a confirmation of payment notification + update in User Activity or any other section and then DONE Button should acticate))