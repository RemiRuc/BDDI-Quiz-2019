package com.example.ditplme;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SubscriptionResponse implements Serializable {
    @SerializedName("status")
    String status;
    @SerializedName("listPlayers")
    List<Player> listPlayers;

    @Override
    public String toString() {
        return "subscription response : " + status;
    }
}
