package com.example.rm.projetocommvp.api;

import android.support.graphics.drawable.VectorDrawableCompat;

import com.example.rm.projetocommvp.BuildConfig;
import com.example.rm.projetocommvp.model.User;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper implements ApiMvpHelper {

    private ApiInterface mApiInterface;

    public ApiHelper() {
        mApiInterface = getRetrofit().create(ApiInterface.class);
    }

    private static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    @Override
    public Single<User> getUserData(int id) {
        return mApiInterface.userData(id);
    }
}
