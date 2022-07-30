package com.antidote.systex.Repository;

import androidx.lifecycle.MutableLiveData;

import com.antidote.systex.WebsiteToConnect.WebsiteToConnect;
import com.antidote.systex.Model.Model;
import com.antidote.systex.Network.APIservice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private APIservice apIservice;

    public Repository() {
        this.apIservice = WebsiteToConnect.getAPIservice();
    }

    public MutableLiveData<Model> getModelLiveData(){
        MutableLiveData<Model> data = new MutableLiveData<>();
        apIservice.getAllData().enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful())
                    data.setValue(response.body());
            }
            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
