package net.paulacr.starwars.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import net.paulacr.starwars.R;
import net.paulacr.starwars.interfaces.OnGridClickListener;
import net.paulacr.starwars.models.Icons;
import net.paulacr.starwars.models.POJO.people.People;
import net.paulacr.starwars.network.RestApi;
import net.paulacr.starwars.utils.Intents;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Paula on 24/10/2015.
 */
public class MainGridAdapter extends RecyclerView.Adapter<MainGridAdapter.ViewHolder> {

    private List<Icons> icons;
    private Context context;

    public MainGridAdapter(Context context, List<Icons> icons) {
        this.icons = icons;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView icon;
        public TextView title;

        public ViewHolder(View view) {
            super(view);

            icon = (ImageView) view.findViewById(R.id.mainGridIcon);
            title = (TextView) view.findViewById(R.id.mainGridTitle);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            switch (position) {
                case 0:
                    context.startActivity(Intents.toPeople(context));
                    Log.i("Log position ", "--> " + position + " case 0");
                    break;
                case 1:
                    Log.i("Log position ", "--> " + position + " case 1");
                    break;
                case 2:
                    Log.i("Log position ", "--> " + position + " case 2");
                    break;
                case 3:
                    Log.i("Log position ", "--> " + position + " case 3");
                    break;
                case 4:
                    Log.i("Log position ", "--> " + position + " case 4");
                    break;
                case 5:
                    Log.i("Log position ", "--> " + position + " case 5");
                    break;

            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.main_grid_item_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Icons icon = icons.get(position);

        holder.icon.setImageResource(icon.getIcon());
        holder.title.setText(icon.getTitle());
    }

    @Override
    public int getItemCount() {
        return icons.size();
    }


}
