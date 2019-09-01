package com.example.boswo.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

import java.io.IOException;
import java.util.logging.Handler;




public class BluetoothConnection extends Thread {
    private final BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;

    public BluetoothConnection(BluetoothDevice device){
        BluetoothSocket tmp = null;
        mmDevice = device;

        try {
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
        }catch(IOException e){
            Log.e("Connector", "Socket's create() method failed",e);
        }
        mmSocket =tmp;
    }

    public void run(BluetoothAdapter bluetoothAdapter){
        bluetoothAdapter.cancelDiscovery();
        try{
            mmSocket.connect();
        }catch (IOException connectException){
            try {
                mmSocket.close();
            }catch (IOException closeException){
                Log.e("Connector", "Could not close the client socket", closeException);
            }
            return;
        }
        manageMyConnectedSocket(mmSocket);
    }

    public void cancel(){
        try{
            mmSocket.close();
        }catch (IOException closeException){
            Log.e("Connector", "Could not close the client socket", closeException);
        }
    }


}
