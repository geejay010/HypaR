package com.partypeople.agent47.hypar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileSetUpScreen extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_set_up_screen);

        mAuth=FirebaseAuth.getInstance();
        mAuthListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null){
                    startActivity(new Intent(ProfileSetUpScreen.this, SignupScreen.class));
                }
            }
        };

    }

    public void onGetBacktoSignIn(View view) {
        mAuth.signOut();
        LoginManager.getInstance().logOut();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);
    }
}
