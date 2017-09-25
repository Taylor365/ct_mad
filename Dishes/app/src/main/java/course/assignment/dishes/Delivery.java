package course.assignment.dishes;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.*;
import android.location.Address;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

/**
 * Created by User on 19/09/17.
 */

public class Delivery extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng delDest;
    private LatLng delOrigin;
    private double lat;
    private double lng;
    public String destination;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery);

        //Retrieving User's Address
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String value = sp.getString("delivery address", "DefaultValue");
        destination = value.replace(' ', '+');

        List<Address> result = null;
        try {
            result = new Geocoder(this).getFromLocationName(destination, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address location = result.get(0);
        lat = location.getLatitude();
        lng = location.getLongitude();
        delDest = new LatLng(lat, lng);

        //Retrieving Cook's Address
        Intent out = getIntent();
        String origin = out.getExtras().getString("cook address");
        origin = origin.replace(' ', '+');

        List<Address> result2 = null;
        try {
            result2 = new Geocoder(this).getFromLocationName(origin, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address location2 = result2.get(0);
        double lat2 = location2.getLatitude();
        double lng2 = location2.getLongitude();
        delOrigin = new LatLng(lat2, lng2);


        // The GoogleMap instance underlying the GoogleMapFragment defined in main.xml

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(delOrigin).title("Busy Cooking :)"));
        mMap.addMarker(new MarkerOptions().position(delDest).title("We will Deliver to Here!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(delOrigin, 12f));

    }
}
