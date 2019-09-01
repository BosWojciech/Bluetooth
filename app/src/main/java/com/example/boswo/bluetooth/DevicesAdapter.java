package com.example.boswo.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.DevicesViewHolder> {


    private List<BluetoothDevice> deviceSet;

    CustomItemClickListener listener;


    public DevicesAdapter(List<BluetoothDevice> deviceSet, CustomItemClickListener listener){
        this.deviceSet = deviceSet;
        this.listener = listener;
    }

    public static class DevicesViewHolder extends RecyclerView.ViewHolder  {

        CardView cardView;
        TextView device;



        DevicesViewHolder(View itemView){
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            device = (TextView)itemView.findViewById(R.id.club_name);

        }

    }



    @Override
    public DevicesAdapter.DevicesViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view,parent,false);
        final DevicesViewHolder deviceHolder = new DevicesViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, deviceHolder.getLayoutPosition());
            }
        });
        return deviceHolder;
    }


    public void Click(View v){
        TextView textView = (TextView)v.findViewById(R.id.club_name);

    }

    @Override
    public void onBindViewHolder(@NonNull DevicesViewHolder holder, int position) {
        holder.device.setText(deviceSet.get(position).getName()+"\n"+deviceSet.get(position).getAddress());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return deviceSet.size();
    }


}
