package com.example.na28.viewpagertest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BikeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bike_view);
    }

    public void Bike(View v){
        Intent bikeinfo = new Intent(getApplicationContext(), BikeInfo.class);
        startActivity(bikeinfo);
    }

    public void BikeCourse(View v){
        Intent bikecourse = new Intent(getApplicationContext(), BikeCourse.class);
        startActivity(bikecourse);
    }

    public void BikeRent(View v){
        Intent bikerent = new Intent(getApplicationContext(), BikeRent.class);
        startActivity(bikerent);

    }



}
