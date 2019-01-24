package com.example.ditplme.retro;

public class ApiUtil {

    private static final String BASE_URL = "http://bddiquiz2019.remi-rucojevic.com/api/";

    public static RetrofitInterface getServiceClass(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(RetrofitInterface.class);
    }
}
