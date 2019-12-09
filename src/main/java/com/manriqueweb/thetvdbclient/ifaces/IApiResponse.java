package com.manriqueweb.thetvdbclient.ifaces;

public interface IApiResponse<T> {
    void onResponse(T data);
    void onError(String errorMsg);
}
