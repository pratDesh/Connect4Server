package com.connect.four.service.dtos;

import com.connect.four.service.entity.Game;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = 1887441531981183124L;

    private Game game;
    private String message;
    private Boolean isSuccess;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
