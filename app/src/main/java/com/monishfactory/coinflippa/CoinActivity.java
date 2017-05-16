package com.monishfactory.coinflippa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class CoinActivity extends AppCompatActivity {

    ImageView image_bottle;

    Button button_spin;

    Random n;

    int angle;

    boolean restart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);

        image_bottle = (ImageView) findViewById(R.id.image_bottle);

        button_spin = (Button) findViewById(R.id.button_spin);

        n = new Random();

        button_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (restart) {
                    RotateAnimation r = new RotateAnimation(angle % 360, 360,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                    r.setFillAfter(true);
                    r.setDuration(1000);
                    r.setInterpolator(new AccelerateDecelerateInterpolator());

                    image_bottle.startAnimation(r);

                    button_spin.setText("GO");
                    restart = false;
                } else {
                    angle = n.nextInt(3600) + 360;
                    RotateAnimation r = new RotateAnimation(0, angle,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                    r.setFillAfter(true);
                    r.setDuration(3600);
                    r.setInterpolator(new AccelerateDecelerateInterpolator());

                    image_bottle.startAnimation(r);

                    button_spin.setText("RESET");
                    restart = true;
                }
            }
        });
    }
}
