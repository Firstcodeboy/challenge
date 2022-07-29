package com.antidote.systex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {
    @SerializedName("DataList")
    @Expose
    private List<DataList> dataList;

    public List<DataList> getDataList() {
        return dataList;
    }

    public Model(List<DataList> dataList) {
        this.dataList = dataList;
    }
}
