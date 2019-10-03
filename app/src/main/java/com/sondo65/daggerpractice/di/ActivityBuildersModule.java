package com.sondo65.daggerpractice.di;

import com.sondo65.daggerpractice.di.main.MainModule;
import com.sondo65.daggerpractice.di.main.MainViewModelsModule;
import com.sondo65.daggerpractice.ui.main.acticity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class, MainModule.class}
    )
    abstract MainActivity contributeAuthActivity();
}
