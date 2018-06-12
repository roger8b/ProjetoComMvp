package com.example.rm.projetocommvp.api;

import com.example.rm.projetocommvp.model.User;

import io.reactivex.Single;

public interface ApiMvpHelper {

    Single<User> getUserData(int id);
}
