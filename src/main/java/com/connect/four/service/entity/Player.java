package com.connect.four.service.entity;

import com.connect.four.service.common.Coin;

import java.io.Serializable;

public class Player implements Serializable {

    private static final long serialVersionUID = 123L;

    private String id;
    private Coin coinColor;

    public Player() {
    }

    public Player(String id, Coin coinColor) {
        this.id = id;
        this.coinColor = coinColor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Coin getCoinColor() {
        return coinColor;
    }

    public void setCoinColor(Coin coinColor) {
        this.coinColor = coinColor;
    }
}
