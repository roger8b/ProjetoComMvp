package com.example.rm.projetocommvp.home;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.rm.projetocommvp.R;
import com.example.rm.projetocommvp.databinding.ActivityHomeBinding;
import com.example.rm.projetocommvp.home.interfaces.HomeMvpContractPresenter;
import com.example.rm.projetocommvp.home.interfaces.HomeMvpContractView;
import com.example.rm.projetocommvp.model.User;

public class HomeActivity extends AppCompatActivity implements HomeMvpContractView, View.OnClickListener {

    HomeMvpContractPresenter mPresenter;
    ActivityHomeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_home,null );
        init();

        mBinding.btRequest.setOnClickListener(this);


    }

    private void init() {
        mPresenter = new HomePresenter(getApplicationContext());
        mPresenter.attach(this);
    }

    @Override
    public void showUser(User user) {
       // Log.println(Log.ASSERT, "Name", user.getFirstName());
       // Log.println(Log.ASSERT, "Last", user.getLastName());
       // Log.println(Log.ASSERT, "Avatar", user.getAvatar());

    }

    @Override
    public void onClick(View view) {
        mPresenter.initialize();
    }
}
