package com.example.poultrysalesapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerScrollViewAdapter extends RecyclerView.Adapter<RecyclerScrollViewAdapter.ViewHolder>
{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImagesUrls = new ArrayList<>();

    //private List<HorizontalScrollDB> scrollirrod;

    private Context mContext;


    public RecyclerScrollViewAdapter(Context mContext, ArrayList<String> mNames, ArrayList<String> mImagesUrls) {
        this.mNames = mNames;
        this.mImagesUrls = mImagesUrls;
        this.mContext = mContext;
    }


//    public RecyclerScrollViewAdapter(Context mContext,List<HorizontalScrollDB> scrollirrod) {
//        this.scrollirrod = scrollirrod;
//        this.mContext = mContext;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolder: called.");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitemscroll,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImagesUrls.get(position))
                .into(holder.imagescrolling);

//        Glide.with(mContext)
//                .asBitmap()
//                .load(scrollirrod.get(position))
//                .into(holder.imagescrolling);

        //holder.scrollimgtext.setText(mNames.get(position));

        holder.imagescrolling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG,"onClick: clicked on an image: "+mNames.get(position));
                //.makeText(mContext, mNames.get(position),Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mImagesUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
//        CircleImageView imagescrolling;
          ImageView imagescrolling;

        //TextView scrollimgtext;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imagescrolling = itemView.findViewById(R.id.imagescrolling);
            //scrollimgtext = itemView.findViewById(R.id.scrollimgtext);
        }
    }


}
