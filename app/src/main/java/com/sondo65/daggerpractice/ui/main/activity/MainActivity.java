package com.sondo65.daggerpractice.ui.main.activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import dagger.android.support.DaggerAppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sondo65.daggerpractice.R;
import com.sondo65.daggerpractice.models.Photo;
import com.sondo65.daggerpractice.factory.ViewModelProviderFactory;
import com.sondo65.daggerpractice.ui.main.adapter.StraggeredRecyclerViewAdapter;
import com.sondo65.daggerpractice.ui.main.viewmodel.MainViewModel;
import com.sondo65.daggerpractice.util.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends DaggerAppCompatActivity{

    private static final String TAG = "MainActivity";

    private MainViewModel viewModel;

    private StraggeredRecyclerViewAdapter adapter;

    private List<Photo> mListPhotos = new ArrayList<>();

    @Inject
    ViewModelProviderFactory providerFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel.class);

        viewModel.getListPhotos();

        subscribePhotoObservers();

        initRecyclerView();

    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapter = new StraggeredRecyclerViewAdapter(this,viewModel.getListPhotos().getValue());
        Log.d(TAG, "initRecyclerView: " + mListPhotos.size());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(Constants.NUMBER_COLUM_RECYCLER_VIEW, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter);
    }


    private void subscribePhotoObservers(){
        viewModel.getListPhotos().observe(this, new Observer<List<Photo>>() {
            @Override
            public void onChanged(List<Photo> photos) {
                adapter.notifyDataSetChanged();
            }
        });
    }



}
