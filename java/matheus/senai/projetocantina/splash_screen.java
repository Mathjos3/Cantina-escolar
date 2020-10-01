package matheus.senai.projetocantina;

import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        iniciarAnimacao();
    }


    //ANIMAÇÃO DA TELA SPLASH
    private void iniciarAnimacao(){
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.alpha);
        anim.reset();
        ConstraintLayout c = (ConstraintLayout) findViewById(R.id.main_layout);
        if (c != null){
            c.clearAnimation();
            c.startAnimation(anim);
        }

        anim = AnimationUtils.loadAnimation(this,R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash);
        if (iv != null){
            iv.clearAnimation();
            iv.startAnimation(anim);
        }

        int SPLASH_DISPLAY_LENGTH = 3500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splash_screen.this,MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
                splash_screen.this.finish();
            }
        },SPLASH_DISPLAY_LENGTH);

    }


}
