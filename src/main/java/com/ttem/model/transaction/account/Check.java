package com.ttem.model.transaction.account;

import com.ttem.exception.transaction.account.AccountTransactionException;
import com.ttem.model.account.Account;

import java.util.Date;

public class Check extends AccountTransaction {

    private final Account toAccount;

    public Check(final double amount, final Account toAccount, final String description) {
        super(amount, description);
        this.toAccount = toAccount;
    }

    @Override
    public boolean doTransaction() throws AccountTransactionException {
        return false;
    }

    public Account getToAccount() {
        return this.toAccount;
    }

    private boolean executionOfTransaction() {
        this.setDone(true);
        this.setDate(new Date());
        return this.isDone();
    }
}