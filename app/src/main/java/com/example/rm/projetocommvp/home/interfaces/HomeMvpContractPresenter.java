package com.example.rm.projetocommvp.home.interfaces;

import android.view.View;

import com.example.rm.projetocommvp.home.HomeActivity;
import com.example.rm.projetocommvp.model.User;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface HomeMvpContractPresenter {
    void attach(HomeActivity view);

    void requestUserData(int i);

    void buttonCliked(View view);

    void colorList(Observable<List<String>> listObservable);
}
