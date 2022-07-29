package com.antidote.systex.Network;

import com.antidote.systex.Model.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIservice {
    @GET("EAS/Apps/systex/hr_elearning/hr_elearning_20220602_181350.json")
    Call<Model> getAllData();
}
