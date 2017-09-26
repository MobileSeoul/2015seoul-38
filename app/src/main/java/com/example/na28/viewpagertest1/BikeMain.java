package com.example.na28.viewpagertest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BikeMain extends AppCompatActivity  {

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.bike_main);

    }
    public void onButton(View v){
        Intent bike = new Intent(getApplicationContext(), BikeView.class);
        startActivity(bike);

    }
    public void Back(View v){
        finish();
    }


}
