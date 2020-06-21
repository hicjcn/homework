package com.example.demo.ui.record;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.model.Record;

public class RecordViewHolder extends RecyclerView.ViewHolder {

    public Activity activity;

    public Record record;

    public TextView name;
    public TextView desc;
    public TextView cnt;
    public TextView amount;
    public TextView time;

    public RecordViewHolder(Activity activity, @NonNull View itemView) {
        super(itemView);
        this.activity = activity;
        //  绑定视图
        name = itemView.findViewById(R.id.itemRecordName);
        desc = itemView.findViewById(R.id.itemRecordDesc);
        cnt = itemView.findViewById(R.id.itemRecordCnt);
        amount = itemView.findViewById(R.id.itemRecordAmount);
        time = itemView.findViewById(R.id.itemRecordTime);
    }
}
