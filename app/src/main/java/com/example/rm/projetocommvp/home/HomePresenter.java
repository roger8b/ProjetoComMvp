package com.example.rm.projetocommvp.home;

import android.content.Context;
import android.view.View;

import com.example.rm.projetocommvp.home.interfaces.HomeMvpContractDataManager;
import com.example.rm.projetocommvp.home.interfaces.HomeMvpContractPresenter;
import com.example.rm.projetocommvp.home.interfaces.HomeMvpContractView;
import com.example.rm.projetocommvp.model.User;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeMvpContractPresenter {

    HomeMvpContractView mView;
    HomeMvpContractDataManager mDatamanager;



    public HomePresenter(Context context) {
        mDatamanager = new HomeDataManager(context);
    }

    @Override
    public void attach(HomeActivity view) {
        mView = view;
    }

    @Override
    public void requestUserData(int userId) {

        mDatamanager.requestUserData(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(User user) {
                        mView.showUser(user);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    @Override
    public void buttonCliked(View view) {


    }


}
