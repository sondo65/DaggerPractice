package com.sondo65.daggerpractice.di.main;


import com.sondo65.daggerpractice.network.main.MainApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class MainModule {

    @Provides
    static MainApi provideSessionApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }

}



















