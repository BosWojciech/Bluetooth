package com.example.boswo.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class paired_devices extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paired_devices);

        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        try{
            Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
            final List<BluetoothDevice> deviceList = new ArrayList<BluetoothDevice>();
            deviceList.addAll(pairedDevices);



            recyclerView = (RecyclerView)findViewById(R.id.devices_list);
            recyclerView.setHasFixedSize(true);

            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);

            mAdapter = new DevicesAdapter(deviceList, new CustomItemClickListener(){
                @Override
                public void onItemClick(View v, int position){
                    String adress = deviceList.get(position).getAddress();
                    Intent intent = new Intent(getApplicationContext(), Connected.class);
                    intent.putExtra("Mac", adress);
                    startActivity(intent);
                }
            });

            recyclerView.setAdapter(mAdapter);

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}

class Device {
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

