package com.example.panindia.ui.test.filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.panindia.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class DisplayFilterWaliAdapter extends
        RecyclerView.Adapter<DisplayFilterWaliAdapter.CustomViewHolder> implements Filterable{
    ArrayList<filterModel> arrayData;
    ArrayList<filterModel> backup;
    Context context;

    public DisplayFilterWaliAdapter(ArrayList<filterModel> arrayData, Context context) {
        this.arrayData = arrayData;
        this.backup = arrayData;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_filter_wali,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        filterModel data = arrayData.get(position);
        holder.tv.setText(data.getOneName());
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

    @Override
    public Filter getFilter() {
        return filterable;
    }
    private Filter filterable = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<filterModel> filterList = new ArrayList<>();
            if(charSequence == null || charSequence.length() == 0){
                filterList.addAll(backup);
            }
            else{
                for(filterModel item :backup){
                        if(item.getOneName().toLowerCase(Locale.ROOT).trim().contains
                                (charSequence.toString().toLowerCase(Locale.ROOT).trim())){
                            filterList.add(item);
                        }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filterList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            arrayData.clear();
            arrayData.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tvFilterWaliTest);
        }
    }
}