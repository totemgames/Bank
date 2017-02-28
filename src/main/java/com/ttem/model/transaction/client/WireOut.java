package com.ttem.model.transaction.client;

import com.ttem.model.account.Account;

import java.util.Arrays;
import java.util.Date;

public class WireOut extends ClientTransaction {

    private final String country;
    private final byte[] swift;
    private final Account toAccount;

    private WireOut(final Builder builder) {
        super(builder.getAmount(), builder.getDescription());
        this.country = builder.getCountry();
        this.swift = builder.getSwift();
        this.toAccount = builder.getToAccount();
    }

    @Override
    public boolean doTransaction() {
        return false;
    }

    public static class Builder{

        private  double amount;
        private  Account toAccount;
        private  String country;
        private  byte[] swift;
        private  String description;

        private double getAmount() {
            return this.amount;
        }

        private Account getToAccount() {
            return this.toAccount;
        }

        private String getCountry() {
            return this.country;
        }

        private byte[] getSwift() {
            return this.swift;
        }

        private String getDescription() {
            return this.description;
        }

        public Builder setAmount(final double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setToAccount(final Account toAccount) {
            this.toAccount = toAccount;
            return this;
        }

        public Builder setCountry(final String country) {
            this.country = country;
            return this;
        }

        public Builder setSwift(final byte[] swift) {
            this.swift = swift;
            return this;
        }

        public Builder setDescription(final String description) {
            this.description = description;
            return this;
        }

        public WireOut build(){
            return new WireOut(this);
        }
    }
}