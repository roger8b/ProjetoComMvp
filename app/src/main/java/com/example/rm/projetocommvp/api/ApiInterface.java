package com.example.rm.projetocommvp.api;

import com.example.rm.projetocommvp.model.User;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/api/users/{id}")
    Single<User> userData(@Path("id") int id);
}
