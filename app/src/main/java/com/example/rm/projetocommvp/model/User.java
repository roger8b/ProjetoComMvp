package com.example.rm.projetocommvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("data")
    @Expose
    public UserData userData;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param userData
     */
    public User(UserData userData) {
        super();
        this.userData = userData;
    }

}
