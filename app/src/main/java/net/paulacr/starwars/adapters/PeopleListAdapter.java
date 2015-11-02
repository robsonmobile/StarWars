package net.paulacr.starwars.adapters;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import net.paulacr.starwars.R;
import net.paulacr.starwars.interfaces.OnGridClickListener;
import net.paulacr.starwars.models.Icons;
import net.paulacr.starwars.models.POJO.people.People;
import net.paulacr.starwars.models.PeopleModel;
import net.paulacr.starwars.network.RestApi;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Paula on 24/10/2015.
 */
public class PeopleListAdapter extends RecyclerView.Adapter<PeopleListAdapter.ViewHolder>{

    List<PeopleModel> peoples;

    public PeopleListAdapter(List<PeopleModel> peoples) {
        this.peoples = peoples;
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView icon;
        private ImageView homeworld;
        public TextView name;
        public TextView gender;

        public ViewHolder(View view) {
            super(view);

            icon        = (ImageView) view.findViewById(R.id.peopleListIcon);
            homeworld   = (ImageView) view.findViewById(R.id.peopleListHomeworld);
            name        = (TextView) view.findViewById(R.id.peopleListName);
            gender     = (TextView) view.findViewById(R.id.peopleListGender);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            int id = view.getId();

            switch (position) {
                case 0:

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

            if(id == R.id.peopleListHomeworld) {
                //Start homeworld activity with the correct data
                String homeworld = peoples.get(getAdapterPosition()).toString();
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.people_list_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PeopleModel people = peoples.get(position);
        //Icon hardcoded
        holder.icon.setImageResource(R.mipmap.ic_launcher);
        holder.homeworld.setImageResource(R.mipmap.ic_launcher);
        holder.name.setText(people.getName());
        holder.gender.setText(people.getGender());
    }

    @Override
    public int getItemCount() {
        return peoples.size();
    }
}
