package com.example.devs;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class signUp extends AppCompatActivity {

    RelativeLayout rellay1 , rellay2;
    EditText e1, e2;

    Button register;


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        rellay1 =  findViewById(R.id.rel_lay1);
        rellay2 =  findViewById(R.id.rel_lay2);
        e1 =  findViewById(R.id.line1);
        e2 =  findViewById(R.id.line2);
        register =  findViewById(R.id.register) ;

        handler.postDelayed(runnable , 3000);



    }
}
