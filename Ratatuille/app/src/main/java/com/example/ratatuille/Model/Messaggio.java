package com.example.ratatuille.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Messaggio {

    @Expose
    @SerializedName("id_messaggio")
    private int id_messaggio;

    @Expose
    @SerializedName("corpo")
    private String corpo;


}
