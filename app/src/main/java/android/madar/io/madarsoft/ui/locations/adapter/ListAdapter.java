package android.madar.io.madarsoft.ui.locations.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.madar.io.madarsoft.R;
import android.madar.io.madarsoft.data.network.model.City;
import android.madar.io.madarsoft.data.network.model.Weather;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Weather> weatherList;
    private Context context;

    public ListAdapter(Context context, List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.parent_single_item, parent, false);

        return new ListAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Weather currentItem = weatherList.get(position);
        City city = currentItem.getCity();
        holder.country_value.setText(city.getCountry());
        holder.city_value.setText(city.getName());

        List<android.madar.io.madarsoft.data.network.model.List> list = currentItem.getList();
        if (list.size() > 0) {
            ChildAdapter adapter = new ChildAdapter(list);
            holder.days_recycler.setLayoutManager(new LinearLayoutManager(context,
                    LinearLayoutManager.VERTICAL, false));
//            holder.days_recycler.addItemDecoration(new DividerItemDecoration(context
//                    , LinearLayoutManager.HORIZONTAL) {
//                @Override
//                public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {

//                }
//            });
            holder.days_recycler.setAdapter(adapter);
        }

        holder.arrow_image.setOnClickListener(v -> {
            if (holder.days_recycler.getVisibility() == View.VISIBLE) {
                holder.days_recycler.setVisibility(View.GONE);
            } else {
                holder.days_recycler.setVisibility(View.VISIBLE);
            }
        });

    }


    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView country_value;
        TextView city_value;
        ImageView arrow_image;
        RecyclerView days_recycler;
        View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            city_value = view.findViewById(R.id.city_value);
            country_value = view.findViewById(R.id.country_value);
            arrow_image = view.findViewById(R.id.arrow_image);
            days_recycler = view.findViewById(R.id.days_recycler);

        }

    }
}
