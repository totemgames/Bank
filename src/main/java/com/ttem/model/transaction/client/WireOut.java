package com.ttem.model.transaction.client;

import com.ttem.exception.transaction.client.wireout.valid.WireOutAccountException;
import com.ttem.exception.transaction.client.wireout.valid.WireOutAmountException;
import com.ttem.exception.transaction.client.wireout.valid.WireOutDoneException;
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

    public Account getToAccount() {
        return this.toAccount;
    }

    public String getCountry() {
        return this.country;
    }

    public byte[] getSwift() {
        return this.swift;
    }

    private boolean executionOfTransaction() {
        this.setDone(true);
        this.setDate(new Date());
        return this.isDone();
    }

    private boolean isNotDone() throws WireOutDoneException {
        if (this.isDone()){
            throw new WireOutDoneException(this.toString() + " this transaction is completed");
        }
        return true;
    }

    private boolean amountValid() throws WireOutAmountException {
        if (this.getAmount() <= 0.0){
            throw new WireOutAmountException(this.getAmount() + " invalid amount");
        }
        return true;
    }

    private boolean accountValid() throws WireOutAccountException {
        if (this.getToAccount() == null){
            return false;
        }
        else if (getToAccount().getNumber().length != 15){
            throw new WireOutAccountException(getToAccount().toString() + " this account has invalid number");
        }
        return true;
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