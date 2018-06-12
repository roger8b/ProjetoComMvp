package com.example.rm.projetocommvp.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rm.projetocommvp.R;
import com.example.rm.projetocommvp.home.interfaces.HomeMvpContractPresenter;
import com.example.rm.projetocommvp.home.interfaces.HomeMvpContractView;
import com.example.rm.projetocommvp.model.User;

public class HomeActivity extends AppCompatActivity implements HomeMvpContractView {

    HomeMvpContractPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();

        mPresenter.initialize();
    }

    private void init() {
        mPresenter = new HomePresenter(getApplicationContext());
        mPresenter.attach(this);
    }

    @Override
    public void showUser(User user) {
        Log.println(Log.ASSERT, "Name", user.getFirstName());
        Log.println(Log.ASSERT, "Last", user.getLastName());
        Log.println(Log.ASSERT, "Avatar", user.getAvatar());

    }
}
