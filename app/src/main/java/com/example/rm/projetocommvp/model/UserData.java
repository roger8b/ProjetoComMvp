package com.example.rm.projetocommvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("avatar")
    @Expose
    public String avatar;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserData() {
    }

    /**
     *
     * @param id
     * @param lastName
     * @param avatar
     * @param firstName
     */
    public UserData(Integer id, String firstName, String lastName, String avatar) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

}