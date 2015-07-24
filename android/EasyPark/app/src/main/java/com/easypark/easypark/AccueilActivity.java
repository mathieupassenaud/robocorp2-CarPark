package com.easypark.easypark;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class AccueilActivity extends AppCompatActivity implements LocationListener {

    ImageButton butAutourMoi;
    ImageButton butAutourDesti;

    //test
    private double latitude;
    private double longitude;
    private String TAG ="MAP";
    private LocationManager locationManager;
    private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        butAutourMoi = (ImageButton)findViewById(R.id.butAutourMoi);
        butAutourMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new UtilWebServices(getApplicationContext()).getParking();
                Intent intent = new Intent(AccueilActivity.this, MapsActivity.class);
                //Intent intent_map = new Intent(AccueilActivity.this, MapsActivity.class);
                intent.putExtra("latitude",latitude);
                intent.putExtra("longitude",longitude);
                startActivity(intent);
            }
        });

        butAutourDesti = (ImageButton)findViewById(R.id.butAutourDesti);
        butAutourDesti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, AutourDestinationActivity.class);
                startActivity(intent);
            }
        });

        //test
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Define the criteria how to select the locatioin provider -> use
        // default
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);

        // Initialize the location fields
        Log.d(TAG, "Provider " + provider + " has been selected.");
        onLocationChanged(location);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accueil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude =location.getLongitude();
        Log.d(TAG,latitude+";"+longitude);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
