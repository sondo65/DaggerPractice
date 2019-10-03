package com.sondo65.daggerpractice.ui.main.viewmodel;

import android.util.Log;

import com.sondo65.daggerpractice.models.User;
import com.sondo65.daggerpractice.network.main.MainApi;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private static final String TAG = "MainViewModel";

    // inject
    private final MainApi mainApi;

    private MediatorLiveData<User> authUser = new MediatorLiveData<>();

    @Inject
    public MainViewModel(MainApi mainApi) {
        this.mainApi = mainApi;
        Log.d(TAG, "MainViewModel: viewmodel is working...");
    }

    public void authenticateWithId(int userId){
        final LiveData<User> source = LiveDataReactiveStreams.fromPublisher(
                mainApi.getUser(userId)
                        .subscribeOn(Schedulers.io()));

        Log.d(TAG, "authenticateWithId: viewmodel is working..." + mainApi.getUser(userId).toString());

        authUser.addSource(source, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                authUser.setValue(user);
                authUser.removeSource(source);
            }
        });
    }

    public LiveData<User> observeUser(){
        return authUser;
    }
}

















