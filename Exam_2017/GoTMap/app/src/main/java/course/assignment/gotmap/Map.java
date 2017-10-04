package course.assignment.gotmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by User on 04/10/17.
 */

public class Map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng kingsLandingLatLng;
    private LatLng highGardenLatLng;
    private LatLng winterfellLatLng;
    private LatLng theWallLatLng;
    private LatLng riverrunLatLng;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        kingsLandingLatLng = new LatLng(51.515419, -0.141099);
        highGardenLatLng = new LatLng(51.3801748, -2.3995494);
        winterfellLatLng = new LatLng(53.9586419, -1.115611);
        theWallLatLng = new LatLng(54.9899016, -2.6717341);
        riverrunLatLng = new LatLng(52.477564, -2.003715);

        // The GoogleMap instance underlying the GoogleMapFragment defined in main.xml

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(kingsLandingLatLng).title("Kings Landing"));
        mMap.addMarker(new MarkerOptions().position(highGardenLatLng).title("Highgarden"));
        mMap.addMarker(new MarkerOptions().position(winterfellLatLng).title("Winterfell"));
        mMap.addMarker(new MarkerOptions().position(theWallLatLng).title("The Wall"));
        mMap.addMarker(new MarkerOptions().position(riverrunLatLng).title("Riverrun"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(winterfellLatLng, 6f));

        mMap.setOnMarkerClickListener( new GoogleMap.OnMarkerClickListener(){


            public boolean onMarkerClick(final Marker marker) {

                Intent i = new Intent(Map.this,  MainActivity.class);
                i.putExtra("marker", marker.getTitle());
                setResult(Activity.RESULT_OK, i);
                finish();

                return false;
            }
        });

    }
}
