package com.ttem.model.account;

import com.ttem.model.transaction.account.AccountTransaction;

import java.util.ArrayList;
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

    private List<AccountTransaction> getHistoryTransactionFromDataBase() {
        return new ArrayList<>();
    }
}