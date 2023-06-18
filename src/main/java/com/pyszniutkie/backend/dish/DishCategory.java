package com.pyszniutkie.backend.dish;

public enum DishCategory {
    BREAK_FAST("śniadanie"), DINER("obiad"), SUPPER("kolacja"), ADDITIVES("dodatki");

    private String polishName;

    DishCategory(String polishName) {
        this.polishName = polishName;
    }

    public String getPolishName() {
        return polishName;
    }
}
