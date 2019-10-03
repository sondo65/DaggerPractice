package com.sondo65.daggerpractice.di.main;

import com.sondo65.daggerpractice.di.ViewModelKey;
import com.sondo65.daggerpractice.ui.main.viewmodel.MainViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindAuthViewModel(MainViewModel viewModel);

}
