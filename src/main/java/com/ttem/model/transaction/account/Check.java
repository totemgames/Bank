package com.ttem.model.transaction.account;

import com.ttem.exception.transaction.account.check.CheckException;
import com.ttem.exception.transaction.account.check.valid.CheckAccountException;
import com.ttem.exception.transaction.account.check.valid.CheckAmountException;
import com.ttem.exception.transaction.account.check.valid.CheckDoneException;
import com.ttem.exception.transaction.account.check.valid.CheckValidException;
import com.ttem.model.account.Account;
import java.util.Date;

public class Check extends AccountTransaction {

    private final Account toAccount;

    public Check(final double amount, final Account toAccount, final String description) {
        super(amount, description);
        this.toAccount = toAccount;
    }

    @Override
    public boolean doTransaction() throws CheckException {
        if(this.isValid() && executionOfTransaction()){
            return true;
        }
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

    private boolean isValid() throws CheckValidException {
        return this.isNotDone() && this.amountValid() && this.accountValid();
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

    private boolean accountValid() throws CheckAccountException {
        if (this.getToAccount() == null){
            return false;
        }
        else if (getToAccount().getNumber().length != 15){
            throw new CheckAccountException(getToAccount().toString() + " this account has invalid number");
        }
        return true;
    }
}