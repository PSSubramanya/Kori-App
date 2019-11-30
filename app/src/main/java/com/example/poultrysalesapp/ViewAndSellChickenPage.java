package com.example.poultrysalesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class ViewAndSellChickenPage extends AppCompatActivity {

    ImageView img1,img5,img6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_and_sell_chicken_page);

        img1 = (ImageView)findViewById(R.id.img1);
        img5 = (ImageView)findViewById(R.id.img5);
        img6 = (ImageView)findViewById(R.id.img6);

        BitmapDrawable bitmapDrawable = (BitmapDrawable)img1.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        final byte[] arr = bitmap.getNinePatchChunk();

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewAndSellChickenPage.this,ShowChickenImage.class);
//                ByteArrayOutputStream bs = new ByteArrayOutputStream();
//                b.compress(Bitmap.CompressFormat.PNG, 50, bs);
//                Bundle bundle=new Bundle();
////                bundle.putInt("image",R.drawable.ic_launcher);
//                bundle.putInt("image",R.id.img1);
//                intent.putExtras(bundle);
//                startActivity(intent);
                intent.putExtra("bmp",arr);
                startActivity(intent);
            }
        });
    }
}
