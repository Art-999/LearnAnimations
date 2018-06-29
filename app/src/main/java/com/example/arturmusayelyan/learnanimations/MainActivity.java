package com.example.arturmusayelyan.learnanimations;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;

public class MainActivity extends AppCompatActivity {
    //First Activity

    private  RelativeLayout buckysLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buckysLayout=findViewById(R.id.buckys_layout);
        buckysLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                moveButton();
                return false;
            }
        });
    }
    private void moveButton(){
        // simple animation example
        Button buckysButton=findViewById(R.id.buckys_btn);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(buckysLayout);
        }

        //Change the position of the button
        RelativeLayout.LayoutParams positionRules= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        buckysButton.setLayoutParams(positionRules);

        //Change the size of the button
        ViewGroup.LayoutParams sizeRules=buckysButton.getLayoutParams();
        sizeRules.width=450;
        sizeRules.height=300;
        buckysButton.setLayoutParams(sizeRules);
    }
}
