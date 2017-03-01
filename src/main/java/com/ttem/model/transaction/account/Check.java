package com.ttem.model.transaction.account;

import com.ttem.exception.transaction.account.AccountTransactionException;
import com.ttem.exception.transaction.account.check.valid.CheckAmountException;
import com.ttem.exception.transaction.account.check.valid.CheckDoneException;
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

    private boolean isNotDone() throws CheckDoneException {
        if (this.isDone()){
            throw new CheckDoneException(this.toString() + " this transaction is completed");
        }
        return true;
    }

    private boolean amountValid() throws CheckAmountException {
        if (this.getAmount() <= 0.0){
            throw new CheckAmountException(this.getAmount() + " invalid amount");
        }
        return true;
    }
}