package com.example.rm.projetocommvp.home.interfaces;

import com.example.rm.projetocommvp.model.User;

import io.reactivex.Single;

public interface HomeMvpContractDataManager {


    Single<User> requestUserData(int id);
}
