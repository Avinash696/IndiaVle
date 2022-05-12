//package com.example.panindia.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.panindia.R;
//import com.example.panindia.model.searchFlightModel.ResponceFlightSeachModel.Result;
//
//import java.util.List;
//
//public class searchListAdapter extends
//        RecyclerView.Adapter<searchListAdapter.ViewHolder> {
//    String tokenValue;
//    String traceId;
//    List<List<Result>> listSeachData;
//    Context context;
//
//    public searchListAdapter(String tokenValue, String traceId, List<List<Result>> listSeachData, Context context) {
//        this.tokenValue = tokenValue;
//        this.traceId = traceId;
//        this.listSeachData = listSeachData;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.custom_search_opeway,
//                parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Result data = listSeachData.get(0).get(position);
//
//        holder.tvTakeOff.setText(data.getSegments().get(0).get(0).getStopPointDepartureTime().toString());
//        holder.tvLanding.setText(data.getSegments().get(0).get(0).getDestination().getArrTime());
//        holder.tvFlightName.setText(data.getSegments().get(0).get(0).getAirline().getAirlineName());
//        holder.tvTotalTime.setText(data.getSegments().get(0).get(0).getAccumulatedDuration());
//        holder.tvPrice.setText(data.getFare().getPublishedFare());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return listSeachData.get(0).size();
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//        TextView tvTakeOff;
//        TextView tvLanding;
//        TextView tvFlightName;
//        TextView tvTotalTime;
//        TextView tvPrice;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tvTakeOff = itemView.findViewById(R.id.tvTakeOff);
//            tvLanding = itemView.findViewById(R.id.tvFlightLanding);
//            tvFlightName = itemView.findViewById(R.id.tvFlightName);
//            tvTotalTime = itemView.findViewById(R.id.tvTotalTime);
//            tvPrice = itemView.findViewById(R.id.tvPrice);
//
//        }
//    }
//}
