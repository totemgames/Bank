package com.ttem.model.account;

import com.ttem.exception.account.AccountNumberException;
import com.ttem.model.transaction.account.AccountTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account {

    private final byte[] number;
    private final List<AccountTransaction> historyTransaction;
    private final String description;

    public Account(final byte[] number, final String description) {
        this.number = number;
        this.historyTransaction = getHistoryTransactionFromDataBase();
        this.description = description;
    }

    public boolean isValid() throws AccountNumberException {
        if (this.number.length != 15){
            throw  new AccountNumberException(Arrays.toString(number) + " invalid account number");
        }
        return true;
    }

    public byte[] getNumber() {
        return this.number;
    }

    public String getDescription() {
        return this.description;
    }

    public List<AccountTransaction> getHistoryTransaction() {
        return this.historyTransaction;
    }

    private boolean addTransactionToDataBase(final AccountTransaction transaction) {
        return this.historyTransaction.add(transaction);
    }

    private List<AccountTransaction> getHistoryTransactionFromDataBase() {
        return new ArrayList<>();
    }
}