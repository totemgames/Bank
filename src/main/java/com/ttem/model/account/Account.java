package com.ttem.model.account;

public class Account {

    private final byte[] number;
    private final String description;

    public Account(final byte[] number, final String description) {
        this.number = number;
        this.description = description;
    }
}