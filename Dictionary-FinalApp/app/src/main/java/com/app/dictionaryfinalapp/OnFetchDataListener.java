package com.app.dictionaryfinalapp;

import com.app.dictionaryfinalapp.model.ApiResponse;

public interface OnFetchDataListener {
    void onFetchData(ApiResponse apIresponse, String message);
    void onError(String message);
}
