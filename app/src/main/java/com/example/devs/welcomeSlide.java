package com.example.devs;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
//import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class welcomeSlide extends AppCompatActivity {
    Button sign_up , log_in , g_mail;
    ViewPager pageSlider;
    // LinearLayout dots;
    private int[] layouts;
    MyViewPageAdapter pageAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_slide);


        sign_up = findViewById(R.id.sign_up);
        log_in =  findViewById(R.id.log_in);
        g_mail =  findViewById(R.id.g_mail);
        pageSlider = findViewById(R.id.pageSlider);

        layouts= new int[]{
                R.layout.activty_slide1,
                R.layout.activity_slide2,
                R.layout.activity_slide3,
        };

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcomeSlide.this , logIn.class);
                startActivity(intent);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcomeSlide.this , signUp.class);
                startActivity(intent);
            }
        });



        pageAdapter = new MyViewPageAdapter();

        pageSlider.setAdapter(pageAdapter);
        pageSlider.setCurrentItem(0);
        pageAdapter.setTimer(pageSlider);
    }



    public class MyViewPageAdapter extends PagerAdapter{

        private LayoutInflater layoutInflater;

         MyViewPageAdapter(){

        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater =(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position] , container, false);

            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }

        // the slider method definition in the class

        final Handler handler = new Handler();
         Timer swipeTimer;


        void setTimer(final ViewPager slider) {
            final Runnable Update = new Runnable() {
                int NUM_PAGES = 4;
                int currentPage = 0;

                public void run() {
                    if (currentPage == NUM_PAGES) {
                        currentPage = 0;
                    }
                    slider.setCurrentItem(currentPage++, true);
                }
            };


            swipeTimer = new Timer();
            swipeTimer.schedule(new TimerTask() {

                @Override
                public void run() {
                    handler.post(Update);
                }
            }, 1000, 6 * 1000);
        }

    }

}
