package com.antidote.systex.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.antidote.systex.Model.Model;
import com.antidote.systex.Repository.Repository;

public class MainActivityViewModel extends ViewModel {
    private final Repository repository;

    public MainActivityViewModel() {
        repository = new Repository();
    }

    public LiveData<Model> getList(){
        return repository.getModelLiveData();
    }
}
