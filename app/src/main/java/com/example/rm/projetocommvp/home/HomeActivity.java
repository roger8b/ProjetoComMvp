package com.example.rm.projetocommvp.home;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.example.rm.projetocommvp.R;
import com.example.rm.projetocommvp.databinding.ActivityHomeBinding;
import com.example.rm.projetocommvp.home.interfaces.HomeMvpContractPresenter;
import com.example.rm.projetocommvp.home.interfaces.HomeMvpContractView;
import com.example.rm.projetocommvp.model.User;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.Observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static junit.framework.Assert.assertTrue;

public class HomeActivity extends AppCompatActivity implements HomeMvpContractView, View.OnClickListener {

    HomeMvpContractPresenter mPresenter;
    ActivityHomeBinding mBinding;
    String result = "";
    Observable<List<String>> listObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Utils.init(getApplicationContext());
        ToastUtils.showShort("Home Actiity");

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_home,null );

         listObservable = Observable.just(getColorList());

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
        mPresenter.colorList(listObservable);
    }

    @Override
    public void showUser(User user) {

        mBinding.tvName.setText(user.userData.firstName);
        mBinding.tvLast.setText(user.userData.lastName);
        mBinding.tvAvatar.setText(user.userData.avatar);



    }


    @Override
    public void onClick(View v) {

    }

    public List<String> getColorList() {

        List<String> colorList = new LinkedList<>();

        colorList.add(1,"fbdfigbdgi");
        colorList.add(2,"fbdfigbdgi");
        colorList.add(3,"fbdfigbdgi");
        colorList.add(4,"fbdfigbdgi");
        colorList.add(5,"fbdfigbdgi");
        colorList.add(6,"fbdfigbdgi");

        return colorList;
    }
}
