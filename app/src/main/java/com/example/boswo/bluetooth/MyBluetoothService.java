package com.example.boswo.bluetooth;


import java.util.logging.Handler;

public class MyBluetoothService {
    private static final String TAG = "BLUETOOTH_CONNECTION_TAG";
    private Handler handler;

    private interface MessageConstants{
        public static final int MESSAGE_READ = 0;
        public static final int MESSAGE_WRITE = 1;
        public static final int MESSAGE_TOAST = 2;
    }
}