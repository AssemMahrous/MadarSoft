package android.madar.io.madarsoft.ui.locations.adapter;

import android.madar.io.madarsoft.R;
import android.madar.io.madarsoft.data.network.model.List;
import android.madar.io.madarsoft.data.network.model.Temp;
import android.madar.io.madarsoft.data.network.model.Weather_;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {
    java.util.List<List> list;

    public ChildAdapter(java.util.List<List> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ChildAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.child_single_item, parent, false);

        return new ChildAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChildAdapter.ViewHolder holder, int position) {
        List currentItem = list.get(position);
        Temp temp = currentItem.getTemp();
        holder.day_value.setText(String.valueOf(temp.getDay()));
        holder.night_value.setText(String.valueOf(temp.getNight()));
        holder.pressure_value.setText(String.valueOf(currentItem.getPressure()));
        holder.humidity_value.setText(String.valueOf(currentItem.getHumidity()));
        java.util.List<Weather_> weather_ = currentItem.getWeather();
        holder.description_value.setText(weather_.get(0).getDescription());
        holder.speed_value.setText(String.valueOf(currentItem.getSpeed()));
        holder.deg_value.setText(String.valueOf(currentItem.getDeg()));
        holder.cloud_value.setText(String.valueOf(currentItem.getClouds()));
        try {
            if (currentItem.getRain() != null) {
                holder.rain_value.setText(String.valueOf(currentItem.getRain()));
                holder.rain_title.setVisibility(View.VISIBLE);
                holder.rain_value.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            holder.rain_title.setVisibility(View.GONE);
            holder.rain_value.setVisibility(View.GONE);
        }

        try {
            if (currentItem.getSnow() != null) {
                holder.snow_value.setText(String.valueOf(currentItem.getSnow()));
                holder.snow_title.setVisibility(View.VISIBLE);
                holder.snow_value.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            holder.snow_title.setVisibility(View.GONE);
            holder.snow_value.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView day_value;
        TextView night_value;
        TextView pressure_value;
        TextView humidity_value;
        TextView description_value;
        TextView speed_value;
        TextView deg_value;
        TextView cloud_value;
        TextView rain_title;
        TextView rain_value;
        TextView snow_title;
        TextView snow_value;
        View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            day_value = view.findViewById(R.id.day_value);
            night_value = view.findViewById(R.id.night_value);
            pressure_value = view.findViewById(R.id.pressure_value);
            humidity_value = view.findViewById(R.id.humidity_value);
            description_value = view.findViewById(R.id.description_value);
            speed_value = view.findViewById(R.id.speed_value);
            deg_value = view.findViewById(R.id.deg_value);
            cloud_value = view.findViewById(R.id.cloud_value);
            rain_title = view.findViewById(R.id.rain_title);
            rain_value = view.findViewById(R.id.rain_value);
            snow_title = view.findViewById(R.id.snow_title);
            snow_value = view.findViewById(R.id.snow_value);
        }

    }
}
