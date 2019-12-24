package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class DeliveryPage extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    Dialog dialog;
    Dialog dialog1;
//    Dialog dialog2;



    CheckBox deliverycheckBox;
    Button deliverydone;

    private Button generateqr;
    private Button cancelqr;


    private TextView userinfofrqr;
    private TextView qrtitletext;
    private ImageView qrimggen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_page);


        deliverycheckBox = (CheckBox)findViewById(R.id.deliverycheckbox);

        deliverydone = (Button)findViewById(R.id.deliverydone);

        dialog = new Dialog(DeliveryPage.this);
        dialog.setContentView(R.layout.qrcode_generator_dialog);


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


//        if (deliverycheckBox.isChecked())
//        {
//            dialog.show();
//        }

//        deliverydone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.show();
//            }
//        });
    }

    public void CheckBoxItemClicked(View view)
    {
        deliverycheckBox = (CheckBox)view.findViewById(R.id.deliverycheckbox);

        dialog = new Dialog(DeliveryPage.this);
        dialog.setContentView(R.layout.qrcode_generator_dialog);


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        if (deliverycheckBox.isChecked())
        {
            dialog.show();

            if (dialog.isShowing())
            {
                generateqr = dialog.findViewById(R.id.generateqr);
                cancelqr = dialog.findViewById(R.id.cancelqr);


                generateqr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();

                        dialog1 = new Dialog(DeliveryPage.this);
                        dialog1.setContentView(R.layout.qr_gen_disp_dialog);


                        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                        dialog1.show();

                        if (dialog1.isShowing())
                        {
                            userinfofrqr = dialog1.findViewById(R.id.userinfofrqr);
                            qrimggen = dialog1.findViewById(R.id.qrimggen);


                            String txt = "Name: P.S. Subramanya Bhat\nAddress: Shree Durga, 5-39/3,\n\t\t\t\t\t\t\t\to/p to P.H.C., Bondel,\n\t\t\t\t\t\t\t\tMangalore, 575008\nOrders: \t\tIrrod1\n\t\t\t\t\t\t\t\tIrrod2\n\t\t\t\t\t\t\t\tIrrod3\n\t\t\t\t\t\t\t\tIrrod4\nTotal Cost: Rs.6000";

                            if (txt != null)
                            {
                                userinfofrqr.setText(txt);
                                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                                try
                                {
                                    BitMatrix bitMatrix = multiFormatWriter.encode(txt, BarcodeFormat.QR_CODE,500,500);
                                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                                    qrimggen.setImageBitmap(bitmap);
                                } catch (WriterException e)
                                {
                                    e.printStackTrace();
                                }

                            }
                        }


//                        String txt = etInput.getText().toString().trim();

//                        String txt = "Name: P.S. Subramanya Bhat\nAddress: xyz\nOrders: \tIrrod1\n\tIrrod2\n\tIrrod3\n\tIrrod4\nTotal Cost: Rs.6000";
//
//                        if (txt != null)
//                        {
//                            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
//                            try
//                            {
//                                BitMatrix bitMatrix = multiFormatWriter.encode(txt, BarcodeFormat.QR_CODE,500,500);
//                                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
//                                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
//                                imageView.setImageBitmap(bitmap);
//                            } catch (WriterException e)
//                            {
//                                e.printStackTrace();
//                            }
//
//                        }
                    }
                });
            }
        }
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

        if (id == R.id.qrcodescannerkori)
        {
//            DialToKoriOffice2();
            Intent intent = new Intent(DeliveryPage.this,QRScannerKori.class);
            startActivity(intent);
//            Toast.makeText(DeliveryPage.this, "Call to Kori Office", Toast.LENGTH_SHORT).show();
        }


        if (id == R.id.orderlistdelivery)
        {
            Toast.makeText(DeliveryPage.this, "Check the list of order for the current delivery", Toast.LENGTH_SHORT).show();
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