package com.shivesh.loginregister.activities;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

import com.shivesh.loginregister.R;
import com.shivesh.loginregister.model.User;
import com.shivesh.loginregister.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;
public class ForgetPasswordActivity extends AppCompatActivity
{

    TextInputEditText textInputEditText;
    AppCompatButton appCompatButton;
    List<User> user;
    DatabaseHelper dh;

   // private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        textInputEditText= findViewById(R.id.textInputEditTextEnter_Email);
        appCompatButton= findViewById(R.id.appCompatButtonForget);

     //   auth = FirebaseAuth.getInstance();

        dh=new DatabaseHelper(ForgetPasswordActivity.this);
        user=new ArrayList<>();
        appCompatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email=textInputEditText.getText().toString();
                user=dh.forgetPassword(email);

                if( user.get(0).getEmail().equals("User Not Exist") )
                {
                    Toast.makeText(ForgetPasswordActivity.this, user.get(0).getEmail(), Toast.LENGTH_SHORT).show();
                }else
                {
                   Toast.makeText(ForgetPasswordActivity.this, "Email "+user.get(0).getEmail()+" & password "+user.get(0).getPassword(), Toast.LENGTH_SHORT).show();

                    /*auth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(ForgetPasswordActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(ForgetPasswordActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });*/
                }
            }
        });
    }
}
