package com.example.demo.ui.record;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.model.Goods;
import com.example.demo.model.Record;
import com.example.demo.ui.goods.GoodsViewHolder;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

public class RecordAdapter extends RecyclerView.Adapter<RecordViewHolder> {

    private Activity activity;
    private List<Record> list;

    public RecordAdapter(Activity activity, List<Record> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(activity, R.layout.item_record, null);
        return new RecordViewHolder(activity, view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
        Record record = list.get(position);
        holder.record = record;
        holder.name.setText(record.name);
        holder.desc.setText(record.description);
        holder.cnt.setText("x" + record.count);
        holder.amount.setText("￥" + record.amount);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        holder.time.setText(simpleDateFormat.format(record.time));
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
