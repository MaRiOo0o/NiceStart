package com.MSanchez.nicestart;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    private LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        openApp();

        animationView = findViewById(R.id.animationView);
        animationView.setAnimation(R.raw.carga);             //Nombre de la animacion en res/raw
        animationView.setRepeatCount(LottieDrawable.INFINITE);

        ImageView cloud = findViewById(R.id.logo);
        TextView texto=findViewById(R.id.texto);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.blink);
        cloud.startAnimation(myanim);
        texto.startAnimation(myanim);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ImageView mSea = findViewById(R.id.sea);

        Glide.with(this)
                .load("https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80")
//                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
//                .circleCrop()
                .into(mSea);
        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.rotate);
        mSea.startAnimation(myanim2);
    }

private void openApp() {

    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(Splash
                    .this, Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);


        }
    }, 5000);
}
}
