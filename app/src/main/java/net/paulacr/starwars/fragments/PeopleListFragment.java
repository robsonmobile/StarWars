package net.paulacr.starwars.fragments;

import android.app.ProgressDialog;
import android.content.res.Resources;
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
import net.paulacr.starwars.utils.Translations;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Paula on 01/11/2015.
 */
public class PeopleListFragment extends Fragment {

    @Bind(R.id.peoplesRecyclerView)
    RecyclerView recyclerView;

    private PeopleListAdapter adapter;
    private ProgressDialog progressDialog;
    private int count = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView layout = (RecyclerView) inflater.inflate(
                R.layout.people_list_fragment, container, false);
        ButterKnife.bind(this, layout);

        return layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createProgressDialog();
        setOnLoading(true);

        new RestApi().requestForPeople(1, callbackPeople);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setOnLoading(boolean isLoading) {
        if(isLoading) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    private ProgressDialog createProgressDialog() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(getResources().getString(R.string.progress_receiving_data));
        return progressDialog;
    }

    private void bindRecyclerViewData(List<PeopleModel> result) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PeopleListAdapter(result);
        recyclerView.setAdapter(adapter);
        //DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
    }

    Callback<People> callbackPeople = new Callback<People>() {

        @Override
        public void success(People people, Response response) {
            int size = people.getResults().size();
            int pagesCount = people.getCount() / size;

            Log.i("Log count " , "--> " + pagesCount);

            List<PeopleModel> results = new ArrayList<>();
            for(int i = 0; i < size - 1; i++) {
                String nome = people.getResults().get(i).getName();
                String homeworld = people.getResults().get(i).getHomeworld();
                String gender = people.getResults().get(i).getGender();

                //set correct gender text, depending on Language
                String lang = Resources.getSystem().getConfiguration().locale.getDisplayLanguage();
                if(lang.equals("português")) {
                    gender = addSpaceToString().concat(Translations.genderTranslation(gender));
                } else {
                    gender = addSpaceToString().concat(gender);
                }

                PeopleModel peopleModel = new PeopleModel(nome, homeworld, gender, R.mipmap.ic_launcher);
                results.add(peopleModel);
                Log.i("Log callback model", "--> " + peopleModel);
                Log.i("Log callback result", "--> " + results.get(i).getName());
            }
            //Bind Results to recyclerview
            //Log.i("Log callback result", "--> " + results.get(0).getName());
            bindRecyclerViewData(results);
            setOnLoading(false);
        }

        @Override
        public void failure(RetrofitError error) {
            Log.i("Log callback ", " error --> " + error);
        }
    };

    private String addSpaceToString() {
        return " ";
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
