package com.antidote.systex.Common;

import com.antidote.systex.Network.APIservice;
import com.antidote.systex.Network.Retrofit;

public class Common {
    private static final String BASE_URL = "https://smuat.megatime.com.tw/";

    public  static APIservice getAPIservice(){
        return Retrofit.getRetrofitClient(BASE_URL).create(APIservice.class);
    }
}
