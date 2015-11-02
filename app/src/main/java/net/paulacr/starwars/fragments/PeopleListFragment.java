package net.paulacr.starwars.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import net.paulacr.starwars.R;
import net.paulacr.starwars.adapters.MainGridAdapter;
import net.paulacr.starwars.adapters.PeopleListAdapter;
import net.paulacr.starwars.models.Icons;
import net.paulacr.starwars.models.POJO.people.People;
import net.paulacr.starwars.models.PeopleModel;
import net.paulacr.starwars.network.RestApi;
import net.paulacr.starwars.repositories.GridMenuItems;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Paula on 01/11/2015.
 */
public class PeopleListFragment extends Fragment {

    @Bind(R.id.loadingPeopleList)
    ProgressBar loadingView;

    @Bind(R.id.peoplesRecyclerView)
    RecyclerView recyclerView;


    private PeopleListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(
                R.layout.people_list_fragment, container, false);
        ButterKnife.bind(this, layout);

        return layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setupRecyclerView();


        //new RestApi().requestForPeople(callbackPeople);
    }

    @Override
    public void onResume() {
        super.onResume();
        setOnLoading(true);

    }

    private void setupRecyclerView() {


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PeopleListAdapter(getFakePeoples());
        recyclerView.setAdapter(adapter);
        //DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
    }

    private void setOnLoading(boolean value) {
        if(value) {
            loadingView.setVisibility(View.VISIBLE);
            //recyclerView.setVisibility(View.INVISIBLE);
        } else {
            loadingView.setVisibility(View.INVISIBLE);
            //recyclerView.setVisibility(View.VISIBLE);
        }

    }

    private List<PeopleModel> getFakePeoples() {
        List<PeopleModel> peoples = new ArrayList<>();
        peoples.add(new PeopleModel("string", "string", "string", R.mipmap.ic_launcher));
        return peoples;
    }

    private void setResults(List<PeopleModel> resultCallback) {
        Log.i("Log callback result", "--> " + resultCallback.get(5).getName());
        adapter = new PeopleListAdapter(resultCallback);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    Callback<People> callbackPeople = new Callback<People>() {

        @Override
        public void success(People people, Response response) {

            int count = people.getCount() - 1;
            int size = people.getResults().size();

            Log.i("Log callback size", "--> " + size);
            Log.i("Log callback count", "--> " +count);


            List<PeopleModel> results = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                String nome = people.getResults().get(i).getName();
                String homeworld = people.getResults().get(i).getHomeworld();
                String gender = people.getResults().get(i).getGender();

                PeopleModel peopleModel = new PeopleModel(nome, homeworld, gender, R.mipmap.ic_launcher);
                results.add(peopleModel);
                Log.i("Log callback model", "--> " + peopleModel);
                Log.i("Log callback result", "--> " + results.get(i).getName());

            }
            setOnLoading(false);
            setResults(results);
        }

        @Override
        public void failure(RetrofitError error) {
            Log.i("Log callback ", " error --> " + error);
        }
    };


    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
