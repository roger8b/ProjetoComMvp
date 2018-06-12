package com.example.rm.projetocommvp.home;

import android.content.Context;

import com.example.rm.projetocommvp.api.ApiHelper;
import com.example.rm.projetocommvp.api.ApiMvpHelper;
import com.example.rm.projetocommvp.home.interfaces.HomeMvpContractDataManager;
import com.example.rm.projetocommvp.model.User;

import io.reactivex.Single;

public class HomeDataManager implements HomeMvpContractDataManager {

    ApiMvpHelper mApiMvpHelper;

    public HomeDataManager(Context context) {
        mApiMvpHelper = new ApiHelper();

    }

    @Override
    public Single<User> requestUserData(int id) {
        return mApiMvpHelper.getUserData(id);
    }
}
