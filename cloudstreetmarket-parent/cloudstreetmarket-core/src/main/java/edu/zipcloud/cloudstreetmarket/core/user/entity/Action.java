package edu.zipcloud.cloudstreetmarket.core.user.entity;

public enum Action {
    BUY("buys"), SELL("sells");

    private String presentTense;

    Action(String present) {
        presentTense = present;
    }

    public String getPresentTense() {
        return presentTense;
    }
}
