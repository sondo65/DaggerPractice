package com.sondo65.daggerpractice.ui.main.viewmodel;

import android.util.Log;

import com.sondo65.daggerpractice.models.Photo;
import com.sondo65.daggerpractice.models.User;
import com.sondo65.daggerpractice.network.main.MainApi;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private static final String TAG = "MainViewModel";

    private final MainApi mainApi;

    private MediatorLiveData<List<Photo>> mlistPhotos;

    public LiveData<List<Photo>> getListPhotos(){
        return mlistPhotos;
    }

    @Inject
    public MainViewModel(MainApi mainApi) {
        this.mainApi = mainApi;
        Log.d(TAG, "MainViewModel: viewmodel is working...");
    }


    public void retrievePhoto(){
        final LiveData<List<Photo>> source = LiveDataReactiveStreams.fromPublisher(
                mainApi.getPhoto()
                .subscribeOn(Schedulers.io())
        );

        mlistPhotos.addSource(source, new Observer<List<Photo>>() {
            @Override
            public void onChanged(List<Photo> photos) {
                mlistPhotos.setValue(photos);
                mlistPhotos.removeSource(source);
            }
        });

    }

}

















