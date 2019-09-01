package com.example.boswo.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();



        ImageView iw = (ImageView)findViewById(R.id.imageView1);
        int resID = getResources().getIdentifier("riccardo", "drawable", getPackageName());
        iw.setImageResource(resID);
    }

    public void changeActivity(View v){
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        /*if(adapter.getBondedDevices().size()>0) {
            Intent intent = new Intent(this, paired_devices.class);
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Nie znaleziono sparowanych urządzeń", Toast.LENGTH_LONG);
            toast.show();
        }*/
        boolean success = false;
        try{
            adapter.getBondedDevices().size();
            success = true;
        }catch(Exception e){
            Toast toast = Toast.makeText(getApplicationContext(), "Nie znaleziono sparowanych urządzeń", Toast.LENGTH_LONG);
            toast.show();
        }
        if(success){
            Intent intent = new Intent(this, paired_devices.class);
            startActivity(intent);
        }
    }
}
