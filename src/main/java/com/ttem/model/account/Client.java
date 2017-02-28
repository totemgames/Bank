package com.ttem.model.account;

import com.ttem.model.transaction.client.ClientTransaction;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {

    private final List<ClientTransaction> historyTransaction;
    private final List<Account> accountList;

    public Client(final String firstName, final String lastName) {
        super(firstName, lastName);
        this.historyTransaction = getHistoryTransactionFromDataBase();
        this.accountList = getAccountListFromDataBase();
    }

    private boolean addNewAccountToDataBase(final Account newAccount) {
        return this.accountList.add(newAccount);
    }

    private List<ClientTransaction> getHistoryTransactionFromDataBase() {
        return new ArrayList<>();
    }

    private List<Account> getAccountListFromDataBase() {
        return new ArrayList<>();
    }
}
