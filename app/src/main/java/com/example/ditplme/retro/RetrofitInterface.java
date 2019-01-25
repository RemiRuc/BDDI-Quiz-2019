package com.example.ditplme.retro;



import com.example.ditplme.Player;
import com.example.ditplme.SubscriptionResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("bdd.json")
    public Call<List<Player>> getAllPlayers();

    @PUT("add.php")
    Call<SubscriptionResponse> createPlayer(
            @Query(value = "pseudo", encoded = true) String pseudo,
            @Query(value = "mail", encoded = true) String mail,
            @Query(value = "score", encoded = true) int score,
            @Query(value = "situation", encoded = true) int situation);

}
