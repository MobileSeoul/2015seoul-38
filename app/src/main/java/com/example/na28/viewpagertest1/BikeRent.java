package com.example.na28.viewpagertest1;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BikeRent extends AppCompatActivity {


    private GoogleMap map;
    Button button;
    static final LatLng SEOUL = new LatLng(37.566545, 126.977717);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_rent);


        map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 14));
        button = (Button)findViewById(R.id.btn1);
        button.setOnClickListener(btn1OnClickListener);

        LocationManager locationmanager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        LocationListener loclis = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double lat = location.getLatitude();
                double lon = location.getLongitude();
                final LatLng latlng = new LatLng(lat, lon);

                map.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 16));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Toast.makeText(BikeRent.this, "GPS가 켜져있지 않습니다.", Toast.LENGTH_SHORT).show();

                new AlertDialog.Builder(BikeRent.this).setTitle("GPS 설정").setMessage("GPS가 꺼져있습니다. \nGPS를 켜시겠습니까?")
                        .setPositiveButton("GPS 켜기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(intent);
                            }
                        }).setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
            }
        };



        String locationProvider = LocationManager.GPS_PROVIDER;

        locationmanager.requestLocationUpdates(locationProvider,0,0,loclis);

        map.setMyLocationEnabled(true);

        //spinner
        String[] str=getResources().getStringArray(R.array.spinnerArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_dropdown_item,str);
        Spinner spi = (Spinner)findViewById(R.id.spinner);
        spi.setAdapter(adapter);
        spi.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected
                            (AdapterView<?> parent, View view, int position, long id) {
                        print(view, position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );//spinner

        } // onCreate

    public void print(View v,int position){
        Spinner sp = (Spinner)findViewById(R.id.spinner);
        TextView tx = (TextView)findViewById(R.id.textView);
        String res = "";
        if(sp.getSelectedItemPosition()>0){
            res=(String)sp.getAdapter().getItem(sp.getSelectedItemPosition());
        }
        if(res!=""){
            if(res.equals("난지 한강공원")){
                map.clear();
                LatLng Position = new LatLng(37.565314, 126.880383);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 16));
                map.addMarker(new MarkerOptions()
                        .position(Position)
                        .snippet("난지 한강공원 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
            }
            else if(res.equals("뚝섬 한강공원")){
                map.clear();
                LatLng Position = new LatLng(37.530858, 127.066544);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 16));
                map.addMarker(new MarkerOptions()
                        .position(Position)
                        .snippet("뚝섬 한강공원 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
            }
            else if(res.equals("마포 한강공원")){
                map.clear();
                LatLng Position = new LatLng(37.530053, 126.928381);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 16));
                map.addMarker(new MarkerOptions()
                        .position(Position)
                        .snippet("마포 한강공원 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
            }
            else if(res.equals("망원 한강공원")){
                map.clear();
                LatLng Position = new LatLng(37.556454, 126.894181);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 16));
                map.addMarker(new MarkerOptions()
                        .position(Position)
                        .snippet("망원 한강공원 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
            }
            else if(res.equals("반포 한강공원")){
                map.clear();
                LatLng Position = new LatLng(37.512651, 127.002274);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 16));
                map.addMarker(new MarkerOptions()
                        .position(Position)
                        .snippet("반포 한강공원 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
            }
            else if(res.equals("서울숲 공원")){
                map.clear();
                LatLng Position = new LatLng(37.543419, 127.045051);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 16));
                map.addMarker(new MarkerOptions()
                        .position(Position)
                        .snippet("서울숲 공원 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
                map.addMarker(new MarkerOptions()
                        .position(new LatLng(37.543019, 127.041228))
                        .snippet("서울숲 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
            }
            else if(res.equals("옥수 달맞이봉공원")){
                map.clear();
                LatLng Position = new LatLng(37.541424, 127.019987);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 16));
                map.addMarker(new MarkerOptions()
                        .position(Position)
                        .snippet("옥수 달맞이봉공원 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
            }
            else if(res.equals("양화 한강공원")){
                map.clear();
                LatLng Position = new LatLng(37.544079, 126.892647);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 16));
                map.addMarker(new MarkerOptions()
                        .position(Position)
                        .snippet("양화 한강공원 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
            }
            else if(res.equals("이촌 한강공원")){
                map.clear();
                LatLng Position = new LatLng(37.517047, 126.969585);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 16));
                map.addMarker(new MarkerOptions()
                        .position(Position)
                        .snippet("이촌 한강공원 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
            }
            else if(res.equals("원효 한강공원")){
                map.clear();
                LatLng Position = new LatLng(37.524642, 126.936923);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 16));
                map.addMarker(new MarkerOptions()
                        .position(Position)
                        .snippet("원효 한강공원 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
            }
            else if(res.equals("잠원 한강공원")){
                map.clear();
                LatLng Position = new LatLng( 37.525026, 127.016198);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 16));
                map.addMarker(new MarkerOptions()
                        .position(Position)
                        .snippet("잠원 한강공원 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
            }
            else if(res.equals("잠실 한강공원")){
                map.clear();
                LatLng Position = new LatLng(37.517837, 127.081951);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 16));
                map.addMarker(new MarkerOptions()
                        .position(Position)
                        .snippet("잠실 한강공원 자전거 대여소")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                        .title("여기는"));
            }
            //tx.setText(res);
        }
    }

    private Button.OnClickListener btn1OnClickListener = new Button.OnClickListener(){
        public void onClick(View v) {
            map.clear();
            LatLng Position = new LatLng(37.522449, 126.985100);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(Position, 12));
            //map.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.541424, 127.019987))
                    .snippet("옥수 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("현재위치"));

            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.543419, 127.045051))
                    .snippet("서울숲 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("여기는"));
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.543019, 127.041228))
                    .snippet("서울숲 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("여기는"));
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.525026, 127.016198))
                    .snippet("잠원 한강공원 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("여기는"));
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.517047, 126.969585))
                    .snippet("이촌 한강공원 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("여기는"));
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.512651, 127.002274))
                    .snippet("반포 한강공원 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("여기는"));
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.524642, 126.936923))
                    .snippet("원효 한강공원 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("여기는"));
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.530053, 126.928381))
                    .snippet("마포 한강공원 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("여기는"));
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.544079, 126.892647))
                    .snippet("양화 한강공원 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("여기는"));
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.556454, 126.894181))
                    .snippet("망원 한강원 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("여기는"));
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.565314, 126.880383))
                    .snippet("난지 한강공원 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("여기는"));
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.530858, 127.066544))
                    .snippet("뚝섬 한강공원 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("여기는"));
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(37.517837, 127.081951))
                    .snippet("잠실 한강공원 자전거 대여소")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("여기는"));
        }
    };
    }




