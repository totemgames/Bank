package com.ttem.model.transaction.account;

import com.ttem.exception.transaction.account.AccountTransactionException;
import com.ttem.model.account.Account;

public class Deposit extends AccountTransaction {

    private final Account fromAccount;

    public Deposit(final double amount, final Account fromAccount, final String description) {
        super(amount, description);
        this.fromAccount = fromAccount;
    }

    @Override
    public boolean doTransaction() throws AccountTransactionException {
        return false;
    }
}