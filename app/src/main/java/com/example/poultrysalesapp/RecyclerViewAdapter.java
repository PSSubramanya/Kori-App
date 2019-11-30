//package com.example.poultrysalesapp;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.provider.ContactsContract;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//
//
//
//public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
//{
//
//    Context mContext;
//    List<Breed1> mData;
//
//
//
//    Dialog dialog;
//    Dialog dialog1;
//    Dialog dialog2;
//
//    private Button chikenirrodview;
//    private Button chikenirrodbuy;
//    private TextView logintext;
//    private TextView signuptext;
//    private ImageView wishlistbtn;
//
//
//
////    Button chikenirrodbuy;
//
//
//    public RecyclerViewAdapter(Context mContext, List<Breed1> mData) {
//        this.mContext = mContext;
//        this.mData = mData;
//    }
//
//
//
//
//    //    public RecyclerViewAdapter(Context mContext, List<ContactsContract.Contacts> mData) {
////        this.mContext = mContext;
////        this.mData = mData;
////    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
//    {
//
//        final View v;
//        v = LayoutInflater.from(mContext).inflate(R.layout.item_breed,parent,false);
//        final MyViewHolder vHolder = new MyViewHolder(v);
//
//        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.slidedown);
//        v.startAnimation(animation);
//
//
////        Animation animation1 = AnimationUtils.loadAnimation(mContext,R.anim.slidedown);
////        v.startAnimation(animation);
//
//
//
//        dialog = new Dialog(mContext);
//        dialog.setContentView(R.layout.dialogue_hen);
//
//
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//
//        vHolder.breed_item_id.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                TextView dialogue_breedname_tv = (TextView)dialog.findViewById(R.id.dialoguebreedname);
//                TextView dialogue_breedcost_tv = (TextView)dialog.findViewById(R.id.dialoguecost);
//                ImageView dialogue_breedhen_img = (ImageView) dialog.findViewById(R.id.dialoguebreedhenimg);
//
//
//                dialogue_breedname_tv.setText(mData.get(vHolder.getAdapterPosition()).getBreedName());
//                dialogue_breedcost_tv.setText(mData.get(vHolder.getAdapterPosition()).getPrice());
//                dialogue_breedhen_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());
//                dialog.show();
//
//                if (dialog.isShowing())
//                {
//                    chikenirrodbuy = dialog.findViewById(R.id.chikenirrodbuy);
//                    wishlistbtn = dialog.findViewById(R.id.wishlistbtn);
//
//                    wishlistbtn.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Toast.makeText(mContext,"Add this to your Wish List",Toast.LENGTH_LONG).show();
//                        }
//                    });
//
//
//
//                    chikenirrodbuy.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Intent intent = new Intent(view.getContext(),UserLoginOrRegisterDialogue.class);
//                            view.getContext().startActivity(intent);
//                        }
//                    });
//
//
////                    chikenirrodbuy.setOnClickListener(new View.OnClickListener() {
////                        @Override
////                        public void onClick(View view)
////                        {
//////                            final Dialog dialog1;
////                            dialog1 = new Dialog(mContext);
////                            dialog1.setContentView(R.layout.user_login_signin_dialogue);
//////                            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
////                            dialog.dismiss();
////                            dialog1.show();
////
////                            if (dialog1.isShowing())
////                            {
////                                signuptext = dialog1.findViewById(R.id.signuptext);
////                                signuptext.setOnClickListener(new View.OnClickListener() {
////                                    @Override
////                                    public void onClick(View view)
////                                    {
////                                        final Dialog dialog2;
////                                        dialog2 = new Dialog(mContext);
////                                        dialog2.setContentView(R.layout.user_login_ignin_dialogb);
//////                            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
////                                        dialog1.dismiss();
////                                        dialog2.show();
////
////                                        if (dialog2.isShowing())
////                                        {
////                                            logintext = dialog2.findViewById(R.id.logintext);
////                                            logintext.setOnClickListener(new View.OnClickListener() {
////                                                @Override
////                                                public void onClick(View view)
////                                                {
////                                                    final Dialog dialog1;
////                                                    dialog1 = new Dialog(mContext);
////                                                    dialog1.setContentView(R.layout.user_login_signin_dialogue);
//////                            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
////                                                    dialog2.dismiss();
////                                                    dialog1.show();
////                                                    return;
////                                                }
////                                            });
////                                        }
////                                    }
////                                });
////                            }
////
////
//                }
//            }
//
//
//
////            private void openuserinfodialogue()
////            {
////                Dialog dialog1;
////                dialog1 = new Dialog(mContext);
////                dialog1.setContentView(R.layout.user_login_signin_dialogue);
////                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
////                dialog1.show();
////            }
//        });
//
//        return vHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
//    {
//        holder.tv_Prices.setText(mData.get(position).getPrice());
//        holder.tv_name.setText(mData.get(position).getBreedName());
//        holder.img.setImageResource(mData.get(position).getPhoto());
//    }
//
//    @Override
//    public int getItemCount() {
//        return mData.size();
//    }
//
//
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder
//    {
//
//        private LinearLayout breed_item_id;
//        private TextView tv_Prices;
//        private TextView tv_name;
//        private ImageView img;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//
//            breed_item_id = (LinearLayout)itemView.findViewById(R.id.breed_item_id);
//            tv_Prices = (TextView)itemView.findViewById(R.id.textViewkoriprice);
//
//            tv_name = (TextView)itemView.findViewById(R.id.textViewkorinames);
//
//            img = (ImageView)itemView.findViewById(R.id.img_breed);
//        }
//    }
//}
//
//
//
//
//



package com.example.poultrysalesapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.ContactsContract;
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

import java.util.List;




public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{

    Context mContext;
    List<Breed1> mData;



    Dialog dialog;
    Dialog dialog1;
    Dialog dialog2;

    private Button chikenirrodview;
    private Button chikenirrodbuy;
    private TextView logintext;
    private TextView signuptext;
    private ImageView wishlistbtn;



//    Button chikenirrodbuy;


    public RecyclerViewAdapter(Context mContext, List<Breed1> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }




    //    public RecyclerViewAdapter(Context mContext, List<ContactsContract.Contacts> mData) {
//        this.mContext = mContext;
//        this.mData = mData;
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        final View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_breed,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.slidedown);
        v.startAnimation(animation);


//        Animation animation1 = AnimationUtils.loadAnimation(mContext,R.anim.slidedown);
//        v.startAnimation(animation);



        dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.dialogue_hen);


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        vHolder.breed_item_id.setOnClickListener(new View.OnClickListener() {
        //vHolder.breed_item_grid_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                TextView dialogue_breedname_tv = (TextView)dialog.findViewById(R.id.dialoguebreedname);
                TextView dialogue_breedcost_tv = (TextView)dialog.findViewById(R.id.dialoguecost);
                ImageView dialogue_breedhen_img = (ImageView) dialog.findViewById(R.id.dialoguebreedhenimg);


                dialogue_breedname_tv.setText(mData.get(vHolder.getAdapterPosition()).getBreedName());
                dialogue_breedcost_tv.setText(mData.get(vHolder.getAdapterPosition()).getPrice());
                dialogue_breedhen_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());
                dialog.show();

                if (dialog.isShowing())
                {
                    chikenirrodbuy = dialog.findViewById(R.id.chikenirrodbuy);
                    wishlistbtn = dialog.findViewById(R.id.wishlistbtn);

                    wishlistbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(mContext,"Add this to your Wish List",Toast.LENGTH_LONG).show();
                        }
                    });



                    chikenirrodbuy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(view.getContext(),UserLoginOrRegisterDialogue.class);
                            view.getContext().startActivity(intent);
                        }
                    });


//                    chikenirrodbuy.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view)
//                        {
////                            final Dialog dialog1;
//                            dialog1 = new Dialog(mContext);
//                            dialog1.setContentView(R.layout.user_login_signin_dialogue);
////                            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                            dialog.dismiss();
//                            dialog1.show();
//
//                            if (dialog1.isShowing())
//                            {
//                                signuptext = dialog1.findViewById(R.id.signuptext);
//                                signuptext.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View view)
//                                    {
//                                        final Dialog dialog2;
//                                        dialog2 = new Dialog(mContext);
//                                        dialog2.setContentView(R.layout.user_login_ignin_dialogb);
////                            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                                        dialog1.dismiss();
//                                        dialog2.show();
//
//                                        if (dialog2.isShowing())
//                                        {
//                                            logintext = dialog2.findViewById(R.id.logintext);
//                                            logintext.setOnClickListener(new View.OnClickListener() {
//                                                @Override
//                                                public void onClick(View view)
//                                                {
//                                                    final Dialog dialog1;
//                                                    dialog1 = new Dialog(mContext);
//                                                    dialog1.setContentView(R.layout.user_login_signin_dialogue);
////                            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                                                    dialog2.dismiss();
//                                                    dialog1.show();
//                                                    return;
//                                                }
//                                            });
//                                        }
//                                    }
//                                });
//                            }
//
//
                }
            }



//            private void openuserinfodialogue()
//            {
//                Dialog dialog1;
//                dialog1 = new Dialog(mContext);
//                dialog1.setContentView(R.layout.user_login_signin_dialogue);
//                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog1.show();
//            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.tv_Prices.setText(mData.get(position).getPrice());
        holder.tv_name.setText(mData.get(position).getBreedName());
        holder.img.setImageResource(mData.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        private LinearLayout breed_item_id;
//        private CardView breed_item_id;
        private TextView tv_Prices;
        private TextView tv_name;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            breed_item_id = (LinearLayout)itemView.findViewById(R.id.breed_item_id);
            tv_Prices = (TextView)itemView.findViewById(R.id.textViewkoriprice);

            tv_name = (TextView)itemView.findViewById(R.id.textViewkorinames);

            img = (ImageView)itemView.findViewById(R.id.img_breed);



//            breed_item_id = (CardView) itemView.findViewById(R.id.breed_item_grid_id);
//            tv_Prices = (TextView)itemView.findViewById(R.id.textViewkoriprice);
//
//            tv_name = (TextView)itemView.findViewById(R.id.irrodcostgrid);
//
//            img = (ImageView)itemView.findViewById(R.id.irrod_img_id);
        }
    }
}





