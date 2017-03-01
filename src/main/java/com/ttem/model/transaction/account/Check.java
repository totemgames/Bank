package com.ttem.model.transaction.account;

import com.ttem.exception.transaction.account.AccountTransactionException;
import com.ttem.model.account.Account;

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
}