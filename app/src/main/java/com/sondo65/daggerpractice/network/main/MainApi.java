package com.sondo65.daggerpractice.network.main;

import com.sondo65.daggerpractice.models.Photo;
import com.sondo65.daggerpractice.models.User;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MainApi {


    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );

    @GET("photos")
    Flowable<List<Photo>> getPhoto();
}
