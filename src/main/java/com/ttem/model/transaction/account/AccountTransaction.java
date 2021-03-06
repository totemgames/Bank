package com.ttem.model.transaction.account;

import com.ttem.exception.transaction.account.AccountTransactionException;
import com.ttem.model.transaction.Transaction;

public abstract class AccountTransaction extends Transaction {

    public AccountTransaction(final double amount, final String description) {
        super(amount, description);
    }

    @Override
    public abstract boolean doTransaction() throws AccountTransactionException;
}
