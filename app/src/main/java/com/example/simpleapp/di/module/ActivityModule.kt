package com.example.simpleapp.di.module

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.example.simpleapp.ViewModelFactory
import com.example.simpleapp.api.ApiHelper
import com.example.simpleapp.di.ActivityContext
import com.example.simpleapp.di.PerActivity
import com.example.simpleapp.repository.MainRepository
import com.example.simpleapp.ui.MainViewModel
import com.example.simpleapp.utils.NetworkHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(private val activity: FragmentActivity) {

    @PerActivity
    @Provides
    @ActivityContext
    fun provideContext(): Context = activity


    @Provides
    fun provideMainRepository(apiHelper: ApiHelper) : MainRepository{
        return MainRepository(apiHelper)
    }

    @Provides
    fun provideMainViewModel(mainRepository: MainRepository,  networkHelper: NetworkHelper) : MainViewModel{
        return ViewModelProviders.of(activity, ViewModelFactory(mainRepository, networkHelper))
            .get(MainViewModel::class.java)
    }
}
