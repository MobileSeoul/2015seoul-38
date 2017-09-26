package com.example.na28.viewpagertest1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class BikeCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bike_course);

        ImageButton ib = (ImageButton)findViewById(R.id.imagebutton1);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BikeCourse.this, "버튼눌림", Toast.LENGTH_SHORT).show();

                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));

                startActivity(it);

            }
        });


    }


}
