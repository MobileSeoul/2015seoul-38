package com.example.na28.viewpagertest1;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BikeInfo extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mPager;



    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.bike_info_view);


        setLayout();



        mPager = (ViewPager)findViewById(R.id.pager);

        mPager.setAdapter(new PagerAdapterClass(getApplicationContext()));
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_one:
                setCurrentInflateItem(0);
                break;
            case R.id.img_two:
                setCurrentInflateItem(1);
                break;
            case R.id.img_three:
                setCurrentInflateItem(2);
                break;
        }
    }
    private int position;
    private void setCurrentInflateItem(int type){
        if(type==0){
            mPager.setCurrentItem(0);
        }else if(type==1){
            mPager.setCurrentItem(1);
        }else{
            mPager.setCurrentItem(2);
        }
    }


//    private Button btn_one;
//    private Button btn_two;
//    private Button btn_three;

    private ImageView img_one;
    private ImageView img_two;
    private ImageView img_three;
    /*
     * Layout
     */
    private void setLayout(){
//        btn_one = (Button) findViewById(R.id.btn_one);
//        btn_two = (Button) findViewById(R.id.btn_two);
//        btn_three = (Button) findViewById(R.id.btn_three);

        img_one = (ImageView) findViewById(R.id.img_one);
        img_two = (ImageView) findViewById(R.id.img_two);
        img_three = (ImageView) findViewById(R.id.img_three);

        img_one.setOnClickListener(this);
        img_two.setOnClickListener(this);
        img_three.setOnClickListener(this);
    }

    private View.OnClickListener mPagerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = ((Button)v).getText().toString();
            //   Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * PagerAdapter
     */
    private class PagerAdapterClass extends PagerAdapter {

        private LayoutInflater mInflater;

        public PagerAdapterClass(Context c){
            super();
            mInflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object instantiateItem(View pager, int position) {
            View v = null;
            if(position==0){
                v = mInflater.inflate(R.layout.roadbikeinfo, null);
                v.findViewById(R.id.iv_one);
                //v.findViewById(R.id.btn_click).setOnClickListener(mPagerListener);
            }
            else if(position==1){
                v = mInflater.inflate(R.layout.fixieinfo, null);
                v.findViewById(R.id.iv_two);
                // v.findViewById(R.id.btn_click_2).setOnClickListener(mPagerListener);
            }else{
                v = mInflater.inflate(R.layout.mtbinfo, null);
                v.findViewById(R.id.iv_three);
                // v.findViewById(R.id.btn_click_3).setOnClickListener(mPagerListener);
            }

            ((ViewPager)pager).addView(v, 0);

            return v;
        }

        @Override
        public void destroyItem(View pager, int position, Object view) {
            ((ViewPager)pager).removeView((View)view);
        }

        @Override
        public boolean isViewFromObject(View pager, Object obj) {
            return pager == obj;
        }

        @Override public void restoreState(Parcelable arg0, ClassLoader arg1) {}
        @Override public Parcelable saveState() { return null; }
        @Override public void startUpdate(View arg0) {}
        @Override public void finishUpdate(View arg0) {}
    }


}



