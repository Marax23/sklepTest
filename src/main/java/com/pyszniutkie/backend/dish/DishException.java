package com.pyszniutkie.backend.dish;

public class DishException  extends RuntimeException{


    private String massage;

    public DishException(String message) {
        this.massage = message;
    }

    public String getMassage() {
        return massage;
    }
}
