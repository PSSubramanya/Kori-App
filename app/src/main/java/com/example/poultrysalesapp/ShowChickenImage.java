package com.example.poultrysalesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class ShowChickenImage extends AppCompatActivity {

    ImageView viewimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_chicken_image);
        //Bundle bundle = getIntent().getExtras();

        //viewimg = (ImageView)findViewById(R.id.viewimg);

//        if (bundle!=null)
//        {
//            int bmp = bundle.getInt("bmp");
//            viewimg.setImageResource(bmp);
//        }

        viewimg = (ImageView)findViewById(R.id.viewimg);

//        Intent i = getIntent();
//        byte[] arr1 = i.getByteArrayExtra("bmp");
//        Bitmap map = BitmapFactory.decodeByteArray(arr1,0, arr1.length);
//        viewimg.setImageBitmap(map);




//        Bundle bundle=this.getIntent().getExtras();
//        int pic=bundle.getInt("image");
//        v.setImageResource(pic);
//        ImageView previewThumbnail = new ImageView(this);
//
//        Bitmap bmp = this.getIntent().getParcelableExtra("bmp");
//        Bitmap b = BitmapFactory.decodeByteArray(
//                getIntent().getByteArrayExtra("bmp"),0,getIntent().getByteArrayExtra("bmp").length);
        //viewimg.setImageBitmap(bmp);
    }
}
