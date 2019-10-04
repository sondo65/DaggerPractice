package com.sondo65.daggerpractice.repositories;

import androidx.lifecycle.MutableLiveData;

import com.sondo65.daggerpractice.models.Photo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class PhotoRepository {

    private static PhotoRepository mInstance;
    private ArrayList<Photo> dataSet = new ArrayList<>();



    public static PhotoRepository getInstance(){
        if(mInstance == null){
            mInstance = new PhotoRepository();
        }
        return mInstance;
    }

//    public MutableLiveData<List<Photo>> getListPhotos(){
//        setListPhotos();
//    }
//
//    private void setListPhotos(){
//
//        Observable<List<Photo>>
//    }
}
