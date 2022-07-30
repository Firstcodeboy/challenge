package com.antidote.systex.WebsiteToConnect;

import com.antidote.systex.Network.APIservice;
import com.antidote.systex.Network.Retrofit;

public class WebsiteToConnect {
    private static final String BASE_URL = "https://smuat.megatime.com.tw/";

    public  static APIservice getAPIservice(){
        return Retrofit.getRetrofitClient(BASE_URL).create(APIservice.class);
    }
}
