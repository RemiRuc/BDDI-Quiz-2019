package com.example.ditplme;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Player implements Serializable {
    @SerializedName("pseudo")
    @Expose
    private String pseudo;
    @SerializedName("mail")
    @Expose
    private String mail;
    @SerializedName("Score")
    @Expose
    private int score;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player : " + pseudo;
    }
}
