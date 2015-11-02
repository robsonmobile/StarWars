package net.paulacr.starwars.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.paulacr.starwars.R;
import net.paulacr.starwars.adapters.MainGridAdapter;
import net.paulacr.starwars.models.Icons;
import net.paulacr.starwars.repositories.GridMenuItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paula on 24/10/2015.
 */
public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.main_fragment, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {

//        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(),
                2, GridLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(new MainGridAdapter( getContext(), getIcons()));

        //DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();

    }

    private List<Icons> getIcons() {
        return GridMenuItems.getGridMenuItems();
    }
}
