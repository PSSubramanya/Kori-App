package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class UserLoginOrRegisterDialogue extends AppCompatActivity
{

    //private Context mContexta;
//    Dialog dialoga;
//    Context mContext1a;


//    public UserLoginOrRegisterDialogue(Context mContext1a) {
//        this.mContext1a = mContext1a;
////        this.mData1 = mData1;
//    }


    TabHost host;
    Button cancelbtn1, cancelbtn2, regbtn, logbtn;
    EditText regusername, regpassword, logusername, logpassword;


    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_or_register_dialogue);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        cancelbtn1 = (Button)findViewById(R.id.cancelbtn1);
        cancelbtn2 = (Button)findViewById(R.id.cancelbtn2);
        regbtn = (Button)findViewById(R.id.regbtn);
        logbtn = (Button)findViewById(R.id.logbtn);


        regusername = (EditText)findViewById(R.id.regusername);
        regpassword = (EditText)findViewById(R.id.regpassword);
        logusername = (EditText)findViewById(R.id.logusername);
        logpassword = (EditText)findViewById(R.id.logpassword);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),UserBuyPage.class));
            finish();
        }

        progressDialog = new ProgressDialog(this);




        host = (TabHost)findViewById(R.id.tabHost);
        host.setup();


        //Register Tab
        TabHost.TabSpec spec = host.newTabSpec("Signup");

        spec.setContent(R.id.tab1);
        spec.setIndicator("Signup");
        host.addTab(spec);
        host.getTabWidget().getChildAt(host.getCurrentTab()).setBackgroundColor(Color.parseColor("#0E4D92"));
        TextView tv = (TextView) host.getTabWidget().getChildAt(host.getCurrentTab()).findViewById(android.R.id.title);
        tv.setTextColor(Color.WHITE);




        spec =host.newTabSpec("Login");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Login");
        host.addTab(spec);
        host.getTabWidget().getChildAt(host.getCurrentTab()).setBackgroundColor(Color.parseColor("#0E4D92"));
        TextView tv1 = (TextView) host.getTabWidget().getChildAt(host.getCurrentTab()).findViewById(android.R.id.title);
        tv1.setTextColor(Color.WHITE);


        host.setOnTabChangedListener(new TabHost.OnTabChangeListener()
        {
            @Override
            public void onTabChanged(String tabId)
            {
                int tab = host.getCurrentTab();
                for (int i = 0; i < host.getTabWidget().getChildCount(); i++)
                {
                    // When tab is not selected
//                    host.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#444444"));
                    host.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#FFFFFF"));

                    TextView tv = (TextView) host.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
//                    tv.setTextColor(Color.WHITE);
                    tv.setTextColor(Color.BLACK);

                }
                // When tab is selected
                host.getTabWidget().getChildAt(host.getCurrentTab()).setBackgroundColor(Color.parseColor("#0E4D92"));
                TextView tv = (TextView) host.getTabWidget().getChildAt(tab).findViewById(android.R.id.title);
//                tv.setTextColor(Color.BLACK);
                tv.setTextColor(Color.WHITE);
            }
        });



        //Functionalities of login/register dialog
        cancelbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLoginOrRegisterDialogue.this,ChickenBreedPage3.class);
                startActivity(intent);
                finish();
            }
        });

        cancelbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLoginOrRegisterDialogue.this,ChickenBreedPage3.class);
                startActivity(intent);
                finish();
            }
        });


//        regbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(UserLoginOrRegisterDialogue.this,ChickenBreedPage2.class);
//                startActivity(intent);
//            }
//        });


//        logbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                LayoutInflater mInflater = LayoutInflater.from(mContext1a);
//                //view = mInflater.inflate(R.layout.henregdialog,getParent());
//                dialoga = new Dialog();
//                dialoga.setContentView(R.layout.dialogue_hen);
//
//
//                dialoga.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            }
//        });


//        logbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(UserLoginOrRegisterDialogue.this,Registration_Form.class);
//                startActivity(intent);
//            }
//        });


//        regbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(UserLoginOrRegisterDialogue.this,Registration_Form.class);
//                startActivity(intent);
//            }
//        });

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = regusername.getText().toString().trim();
                String password = regpassword.getText().toString().trim();


                if (TextUtils.isEmpty(email))
                {
//                    Toast.makeText(UserLoginOrRegisterDialogue.this,"Please enter your E-mail id!!!",Toast.LENGTH_SHORT).show();
                    regusername.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(password))
                {
//                    Toast.makeText(UserLoginOrRegisterDialogue.this,"Please enter the password!!!",Toast.LENGTH_SHORT).show();
                    regpassword.setError("Password is required");
                    return;
                }


                if (password.length()<6)
                {
                    regpassword.setError("Password must be minimum 6 characters");
                    return;
                }

                progressDialog.setMessage("Registering user...");
                progressDialog.show();


                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            progressDialog.dismiss();
                            Toast.makeText(UserLoginOrRegisterDialogue.this,"User Created Successfully!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Registration_Form.class));
                        }
                        else
                        {
                            Toast.makeText(UserLoginOrRegisterDialogue.this,"Error in registration"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                //userRegPage();
//                Intent intent = new Intent(UserLoginOrRegisterDialogue.this,Registration_Form.class);
//                startActivity(intent);
            }
        });


        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //LogUser();
                String email1 = logusername.getText().toString().trim();
                String password1 = logpassword.getText().toString().trim();


                if (TextUtils.isEmpty(email1))
                {
//                    Toast.makeText(UserLoginOrRegisterDialogue.this,"Please enter your E-mail id!!!",Toast.LENGTH_SHORT).show();
                    logusername.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(password1))
                {
//                    Toast.makeText(UserLoginOrRegisterDialogue.this,"Please enter the password!!!",Toast.LENGTH_SHORT).show();
                    logpassword.setError("Password is required");
                    return;
                }


//                if (password1.length()<6)
//                {
//                    regpassword.setError("Password must be minimum 6 characters");
//                    return;
//                }

                progressDialog.setMessage("Logging in...");
                progressDialog.show();


                firebaseAuth.signInWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            progressDialog.dismiss();
                            Toast.makeText(UserLoginOrRegisterDialogue.this,"Logged in Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),UserBuyPage.class));
                        }
                        else
                        {
                            Toast.makeText(UserLoginOrRegisterDialogue.this,"Error in logging in"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


    }



//    public void userRegPage()
//    {
//        String email = regusername.getText().toString().trim();
//        String password = regpassword.getText().toString().trim();
//
//
//
//        if (TextUtils.isEmpty(email))
//        {
//            Toast.makeText(this,"Please enter your E-mail id!!!",Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        if (TextUtils.isEmpty(password))
//        {
//            Toast.makeText(this,"Please enter the password!!!",Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        progressDialog.setMessage("Registering User...");
//        progressDialog.show();
//
//
//        firebaseAuth.signInWithEmailAndPassword(email,password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        progressDialog.dismiss();
//                        if (task.isSuccessful())
//                        {
//                            Toast.makeText(UserLoginOrRegisterDialogue.this,"Registration Successful!",Toast.LENGTH_SHORT).show();
//                        }
//                        else
//                        {
//                            Toast.makeText(UserLoginOrRegisterDialogue.this,"Registration Failed!",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//
//    }
//
//
//    private void LogUser()
//    {
//        String email1 = logusername.getText().toString().trim();
//        String password1 = logpassword.getText().toString().trim();
//
//        if (TextUtils.isEmpty(email1))
//        {
//            Toast.makeText(this,"Please enter the email id!!!",Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        if (TextUtils.isEmpty(password1))
//        {
//            Toast.makeText(this,"Please enter the password!!!",Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//
//        progressDialog.setMessage("Logging in...");
//        progressDialog.show();
//
//
//        firebaseAuth.createUserWithEmailAndPassword(email1,password1)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        progressDialog.dismiss();
//                        if (task.isSuccessful())
//                        {
//                            finish();
//                            startActivity(new Intent(getApplicationContext(),Registration_Form.class));
//                            Toast.makeText(UserLoginOrRegisterDialogue.this,"Logged in Successfully!",Toast.LENGTH_SHORT).show();
//                        }
//                        else
//                        {
//                            Toast.makeText(UserLoginOrRegisterDialogue.this,"Log in Failed!",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }
}
