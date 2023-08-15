package com.example.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
        //light value
        float l,l2,x,y,z;

        TextView ll,xx,yy,zz;
        //sensor manager
        SensorManager sensorManager;
        // light sensor
        Sensor light, accelerometer;
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ll=(TextView) findViewById(R.id.lum);
            xx=(TextView) findViewById(R.id.x);
            yy=(TextView) findViewById(R.id.y);
            zz=(TextView) findViewById(R.id.z);
            // Instantiate the SensorManager
            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            // Instantiate the light sensor
            light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
        protected void onPause() {
            // unregister the sensor listener
            sensorManager.unregisterListener(this, light);
            sensorManager.unregisterListener(this, accelerometer);
            super.onPause();
        }
        protected void onResume() {
                // register the sensor listener
            sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_GAME);
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
        super.onResume();
        }
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

         }


       public void onSensorChanged(SensorEvent event) {
                // detect light sensor change
                if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                    // light value
                    l = event.values[0];
                    //display the value in the text view
                    ll.setText(String.valueOf(l));

                }
               // detect and display acceloremeter values
                 if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

                     x = event.values[0];
                     xx.setText(String.valueOf(x));
                     y = event.values[1];
                     yy.setText(String.valueOf(y));
                     z = event.values[2];
                     zz.setText(String.valueOf(z));

                 }
       }
}


