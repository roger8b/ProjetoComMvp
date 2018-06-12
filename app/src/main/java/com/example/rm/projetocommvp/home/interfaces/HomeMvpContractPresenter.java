package com.example.rm.projetocommvp.home.interfaces;

import com.example.rm.projetocommvp.home.HomeActivity;

public interface HomeMvpContractPresenter {
    void attach(HomeActivity view);

    void initialize();
}
