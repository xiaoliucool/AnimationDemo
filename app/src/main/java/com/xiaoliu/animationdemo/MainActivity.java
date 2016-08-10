package com.xiaoliu.animationdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Animation mAnimation;

    @Bind(R.id.ivIcon)
    ImageView displayPicImageView;
    @Bind(R.id.btnAlpha)
    Button alphaButton;
    @Bind(R.id.btnScale)
    Button scaleButton;
    @Bind(R.id.btnTranslate)
    Button translateButton;
    @Bind(R.id.btnRotate)
    Button rotateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        registerListener();
    }

    private void loadAnimation(Context context, int animResId) {
        mAnimation = AnimationUtils.loadAnimation(context, animResId);
    }

    private void registerListener() {
        alphaButton.setOnClickListener(this);
        scaleButton.setOnClickListener(this);
        translateButton.setOnClickListener(this);
        rotateButton.setOnClickListener(this);
    }

    private void stopAnimation(){
        mAnimation.cancel();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAlpha:
                loadAnimation(this, R.anim.my_alpha);
                break;
            case R.id.btnScale:
                loadAnimation(this, R.anim.my_scale);
                break;
            case R.id.btnTranslate:
                loadAnimation(this, R.anim.my_translate);
                break;
            case R.id.btnRotate:
                loadAnimation(this, R.anim.my_rotate);
                break;
            default:
                break;
        }
        displayPicImageView.startAnimation(mAnimation);
        stopAnimation();
    }
}
