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
    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("situation")
    @Expose
    private int situation;

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

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }

    @Override
    public String toString() {
        String sit = "";
        if (situation == 0){
            sit = "développeur";
        } else {
            sit = "graphiste";
        }
        return "Le " + sit + " " + pseudo + " à fait " + score + " points";
    }
}
