package com.ttem.model.transaction.account;

import com.ttem.exception.transaction.account.AccountTransactionException;
import com.ttem.exception.transaction.account.deposit.valid.DepositDoneException;
import com.ttem.model.account.Account;

import java.util.Date;

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

    public Account getFromAccount() {
        return this.fromAccount;
    }

    private boolean executionOfTransaction() {
        this.setDone(true);
        this.setDate(new Date());
        return this.isDone();
    }

    private boolean isNotDone() throws DepositDoneException {
        if (this.isDone()){
            throw new DepositDoneException(this.toString() + " this transaction is completed");
        }
        return true;
    }
}