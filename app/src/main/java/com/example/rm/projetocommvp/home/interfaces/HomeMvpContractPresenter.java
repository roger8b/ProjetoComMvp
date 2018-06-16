package com.example.rm.projetocommvp.home.interfaces;

import android.view.View;

import com.example.rm.projetocommvp.home.HomeActivity;
import com.example.rm.projetocommvp.model.User;

import io.reactivex.Single;

public interface HomeMvpContractPresenter {
    void attach(HomeActivity view);

    void requestUserData(int i);

    void buttonCliked(View view);

}
