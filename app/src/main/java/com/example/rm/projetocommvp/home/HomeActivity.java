package com.example.rm.projetocommvp.home;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rm.projetocommvp.R;
import com.example.rm.projetocommvp.databinding.ActivityHomeBinding;
import com.example.rm.projetocommvp.home.interfaces.HomeMvpContractPresenter;
import com.example.rm.projetocommvp.home.interfaces.HomeMvpContractView;
import com.example.rm.projetocommvp.model.User;
import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class HomeActivity extends AppCompatActivity implements HomeMvpContractView {

    HomeMvpContractPresenter mPresenter;
    ActivityHomeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_home,null );

        init();


        Disposable subscribeButton1 = RxView.clicks(mBinding.btUser1)
                .subscribe(aVoid -> {

                    mPresenter.requestUserData(1);

                });

        Disposable subscribeButton2 = RxView.clicks(mBinding.btUser2)
                .subscribe(aVoid -> {
                    mPresenter.requestUserData(2);
                });




    }

    private void init() {
        mPresenter = new HomePresenter(getApplicationContext());
        mPresenter.attach(this);
    }

    @Override
    public void showUser(User user) {

        mBinding.tvName.setText(user.userData.firstName);
        mBinding.tvLast.setText(user.userData.lastName);
        mBinding.tvAvatar.setText(user.userData.avatar);



    }




}
