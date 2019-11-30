package com.example.poultrysalesapp;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AdminInfoDialogue extends AppCompatDialogFragment {
    //private EditText et1, et2;
    //private PersonalInfoDialogueListener listener;
    //public static String usndata = " ";
    //public static String datedata = " ";
    //private DatePicker et2;

    private String adminuserid = "Nishmith";
    private String adminpassword = "Kori";


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.admininfopage, null);

        Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.slidedown);
//        Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.sample_animation);
//        Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.bounce);
        view.startAnimation(animation);

        Button adminbtn = view.findViewById(R.id.adminbtn);
        Button cancelad = view.findViewById(R.id.cancelad);

        final EditText textViewAdmin = view.findViewById(R.id.textViewAdmin);
        final EditText textViewAdminpass = view.findViewById(R.id.textViewAdminpass);

        final String checkuid = textViewAdmin.getText().toString();
        final String checkpassword = textViewAdminpass.getText().toString();

        adminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String checkuid = textViewAdmin.getText().toString();

//                if (checkuid.equals("Nishmith") && checkpassword.equals("Kori"))
//                {
//                    Toast.makeText(getActivity(),"Admin Accepted",Toast.LENGTH_LONG).show();
//                }
                if (textViewAdmin.getText().toString().equals("Nishmith") && textViewAdminpass.getText().toString().equals("Kori"))
                {
                    Intent intent = new Intent(getContext(),AdminChickenBreedAdd.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(),"Admin Accepted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getActivity(),"Verify the Credentials",Toast.LENGTH_LONG).show();
                }


//                Toast.makeText(getActivity(),"Admin Accepted",Toast.LENGTH_LONG).show();
            }
        });

        cancelad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(),"Verify the Credentials",Toast.LENGTH_LONG).show();
                dismiss();
            }
        });


        //et1 = view.findViewById(R.id.textViewUsn);
        //et2 = view.findViewById(R.id.textViewDate);

        builder.setView(view)
                .create();
//                .setTitle("Admin Info")
//                .setMessage("Enter Admin Username and password!!!");

//                .setTitle("")
//                .setMessage("");


//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                })
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        String usndata = et1.getText().toString();
//
//                        Intent intent = new Intent(((Dialog)dialogInterface).getContext(),ViewDatabase.class);
//                        intent.putExtra("usndata",usndata);
//                        startActivity(intent);

        return builder.create();
    }
}
//public class PersonalInfoDialogue extends AppCompatDialogFragment
//{
//    //private EditText et1, et2;
//    //private PersonalInfoDialogueListener listener;
//    //public static String usndata = " ";
//    //public static String datedata = " ";
//    //private DatePicker et2;
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        // super.onCreateDialog(savedInstanceState);
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        View view = inflater.inflate(R.layout.admininfopage,null);
//        //et1 = view.findViewById(R.id.textViewUsn);
//        //et2 = view.findViewById(R.id.textViewDate);
//
//        builder.setView(view)
//                .setTitle("Absence Info")
//                .setMessage("Enter Usn!!!");
////                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////
////                    }
////                })
////                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////
////                        String usndata = et1.getText().toString();
////
////                        Intent intent = new Intent(((Dialog)dialogInterface).getContext(),ViewDatabase.class);
////                        intent.putExtra("usndata",usndata);
////                        startActivity(intent);


//}