package com.example.classactivity2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.ViewHolder> {

    private List<Day> days;

    public DayAdapter(List<Day> days) {
        this.days = days;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View dayView = inflater.inflate(R.layout.item_days, parent, false);
        ViewHolder viewHolder = new ViewHolder(dayView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DayAdapter.ViewHolder holder, int position) {
        Day day = days.get(position);
        holder.textView_dateTime.setText(day.getTime_date());
        holder.textView_desc.setText(day.getDescription());
        holder.textView_feels.setText(day.getFeels_like());
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView_dateTime;
        TextView textView_desc;
        TextView textView_feelsLabel;
        TextView textView_feels;

        public ViewHolder(View itemView) {
            super(itemView);
            textView_dateTime = itemView.findViewById(R.id.date_time);
            textView_desc = itemView.findViewById(R.id.description);
            textView_feelsLabel = itemView.findViewById(R.id.feels_like);
            textView_feels = itemView.findViewById(R.id.temp);
        }
    }
}
