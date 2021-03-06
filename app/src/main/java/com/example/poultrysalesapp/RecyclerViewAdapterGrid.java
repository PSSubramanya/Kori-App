package com.example.poultrysalesapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerViewAdapterGrid extends RecyclerView.Adapter<RecyclerViewAdapterGrid.MyViewHolder>
{
    public static final String TAG = "TAG";
    Context mContext1;
    List<IrrodGrid> mData1;



    Dialog dialog;
    Dialog dialog1;
    Dialog dialog2;

    private Button chikenirrodview;
    private Button chikenirrodbuy;
    private TextView logintext;
    private TextView signuptext;
    private ImageView wishlistbtn;
//    private ImageView multiselectcheck;

    public RecyclerViewAdapterGrid(Context mContext1, List<IrrodGrid> mData1) {
        this.mContext1 = mContext1;
        this.mData1 = mData1;
    }



    private final static int mwidth = 512;
    private final static int mheight = 512;

    private ArrayList<String> pathArray;
    private int array_position;


    private FirebaseAuth firebaseAuth; // for storage purposes
    FirebaseFirestore fstore;
    private StorageReference storageReference;
    String userID;




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;

//        final View v;
//        v = LayoutInflater.from(mContext1).inflate(R.layout.cardview_item_hen,parent,false);
//        //final RecyclerViewAdapterGrid.MyViewHolder vHolder = new RecyclerViewAdapterGrid().MyViewHolder(v);
//
//        final MyViewHolder viewHolder1 = new MyViewHolder(v);



        pathArray = new ArrayList<>();

        firebaseAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();



//        checkFilePermission();


        View v;
//        LayoutInflater.from(mContext1).inflate(R.layout.cardview_item_hen,parent,false);
        LayoutInflater mInflater = LayoutInflater.from(mContext1);

        //final RecyclerViewAdapterGrid.MyViewHolder vHolder = new RecyclerViewAdapterGrid().MyViewHolder(v);

//        final MyViewHolder viewHolder1 = new MyViewHolder(v);
        v = mInflater.inflate(R.layout.cardview_item_hen,parent,false);



        Animation animation = AnimationUtils.loadAnimation(mContext1,R.anim.slidedown);
        v.startAnimation(animation);

        dialog = new Dialog(mContext1);
        dialog.setContentView(R.layout.dialogue_hen);


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));






//        Animation animation1 = AnimationUtils.loadAnimation(mContext,R.anim.slidedown);
//        v.startAnimation(animation);

        //return viewHolder1;
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position)
    {
        holder.tv_Prices1.setText(mData1.get(position).getPrice1());
        holder.tv_name1.setText(mData1.get(position).getBreedName1());
        holder.thumb1.setImageResource(mData1.get(position).getThumbnail1());


//        holder.breed_item_grid_id.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//
////                return false;
//            }
//        });

        holder.breed_item_grid_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TextView dialogue_breedname_tv = (TextView)dialog.findViewById(R.id.dialoguebreedname);
//                TextView dialogue_breedcost_tv = (TextView)dialog.findViewById(R.id.dialoguecost);
//                ImageView dialogue_breedhen_img = (ImageView) dialog.findViewById(R.id.dialoguebreedhenimg);



                // declared final to make these textviews accessible to inner classes
                final TextView dialogue_breedname_tv = (TextView)dialog.findViewById(R.id.dialoguebreedname);
                final TextView dialogue_breedcost_tv = (TextView)dialog.findViewById(R.id.dialoguecost);
                final ImageView dialogue_breedhen_img = (ImageView) dialog.findViewById(R.id.dialoguebreedhenimg);


                dialogue_breedname_tv.setText(mData1.get(holder.getAdapterPosition()).getBreedName1());
                dialogue_breedcost_tv.setText(mData1.get(holder.getAdapterPosition()).getPrice1());
                dialogue_breedhen_img.setImageResource(mData1.get(holder.getAdapterPosition()).getThumbnail1());
                dialog.show();


                if (dialog.isShowing())
                {
                    chikenirrodbuy = dialog.findViewById(R.id.chikenirrodbuy);
                    chikenirrodview = dialog.findViewById(R.id.chikenirrodview);
                    wishlistbtn = dialog.findViewById(R.id.wishlistbtn);

                    wishlistbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(mContext1,"Add this to your Wish List",Toast.LENGTH_LONG).show();
                        }
                    });

//                    chikenirrodbuy.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Intent intent = new Intent(view.getContext(),UserLoginOrRegisterDialogue.class);
//                            view.getContext().startActivity(intent);
//                        }
//                    });


                    chikenirrodbuy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();




                            final String drawerstringname = dialogue_breedname_tv.getText().toString().trim();
                            String drawerstringcost = dialogue_breedcost_tv.getText().toString().trim();


                            DocumentReference documentReference = fstore.collection("Irrod Hens").document(drawerstringname);

                            Map<String,Object> user = new HashMap<>();

                            user.put("Hen",drawerstringname);
                            user.put("Cost",drawerstringcost);


                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: Irrod hen collection created" + drawerstringname);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }

                            });



                            Intent intent = new Intent(view.getContext(),UserLoginOrRegisterDialogue.class);
                            intent.putExtra("drawerstringname",drawerstringname);
                            view.getContext().startActivity(intent);
                        }
                    });


                    chikenirrodview.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            Intent intent = new Intent(view.getContext(),ImageAndVideoViewerPage.class);
                            view.getContext().startActivity(intent);
                        }
                    });


//                    chikenirrodbuy.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
////                            Intent intent = new Intent(view.getContext(),UserLoginOrRegisterDialogue.class);
////                            view.getContext().startActivity(intent);
//
//                            dialog1 = new Dialog(mContext1);
//                            dialog1.setContentView(R.layout.dialog_auth);
//
//
////                            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//                            dialog.dismiss();
//                            dialog1.show();
//
//                        }
//                    });
                }
            }
        });

//        CardView breed_item_grid_id;
    }


//    private void checkFilePermission()
//    {
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP)
//        {
//            int permissionCheck = DeliveryPage.this.checkSelf
//        }
//    }

    @Override
    public int getItemCount() {
        return mData1.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        //private CardView breed_item_grid_id;
//        private TextView tv_Prices1;
//        private TextView tv_name1;
//        private ImageView thumb1;

        CardView breed_item_grid_id;
        TextView tv_Prices1;
        TextView tv_name1;
        ImageView thumb1;

        public MyViewHolder(View itemview)
        {
            super(itemview);

            breed_item_grid_id = (CardView) itemView.findViewById(R.id.breed_item_grid_id);
            tv_Prices1 = (TextView)itemView.findViewById(R.id.irrodcostgrid);

            tv_name1 = (TextView)itemView.findViewById(R.id.irrodtypegrid);

            thumb1 = (ImageView)itemView.findViewById(R.id.irrod_img_id);
        }
    }
}




// on click of confirm button it shud ask for gps location and once location is sent only then it should to be directed to Delivery Page