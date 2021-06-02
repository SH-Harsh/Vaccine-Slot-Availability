package com.example.cowinslot.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cowinslot.Network.ServerResponse.SlotResponse;
import com.example.cowinslot.R;
import com.example.cowinslot.databinding.RecListBinding;

import java.util.List;

public class SlotAdapter extends RecyclerView.Adapter<SlotAdapter.SlotHolder> {

    private final List<SlotResponse.Sessions> serverResponses;
    private final Context context;

    public SlotAdapter(List<SlotResponse.Sessions> serverResponses, Context context) {
        this.serverResponses = serverResponses;
        this.context = context;
    }

    @NonNull
    @Override
    public SlotAdapter.SlotHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_list,parent,false);
        return new SlotHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SlotAdapter.SlotHolder holder, int position) {

        holder.binding.txvCenter.setText(serverResponses.get(position).getName());
        if(serverResponses.get(position).getAvailable_capacity() > 0){
            holder.binding.cardview.setBackgroundColor(Color.YELLOW);
        }else{
            holder.binding.cardview.setBackgroundColor(Color.rgb(102,255,232));
        }
        holder.binding.txvAvailableSlot.setText("Available slot : " + String.valueOf(serverResponses.get(position).getAvailable_capacity()));
        holder.binding.txvPincode.setText(String.valueOf(serverResponses.get(position).getPincode()));


    }

    @Override
    public int getItemCount() {
        return serverResponses.size();
    }

    public class SlotHolder extends RecyclerView.ViewHolder {

        RecListBinding binding;
        public SlotHolder(@NonNull View itemView) {
            super(itemView);
            binding = RecListBinding.bind(itemView);
        }
    }
}
