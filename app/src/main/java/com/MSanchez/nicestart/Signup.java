package com.MSanchez.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView mBoy=findViewById(R.id.boy);
        Glide.with(this)
//                .load("https://images.unsplash.com/photo-1489424731084-a5d8b219a5bb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80")
                .load(R.drawable.hipman)
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
//                .circleCrop()
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(mBoy);

    }
    public void openProfile(View v) {
        Intent intent = new Intent(Signup.this, Profile.class);
        startActivity(intent);

    }
    public void openLogin(View v) {
        Intent intent = new Intent(Signup.this, Login.class);
        startActivity(intent);

    }
}