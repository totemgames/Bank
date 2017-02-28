package com.ttem.model.account;

import com.ttem.exception.account.AccountDuplicateException;
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

    private boolean isNewAccount(final Account newAccount) throws AccountDuplicateException {
        for (Account existingAccount : this.getAccountList()) {
            if (existingAccount == newAccount){
                throw new AccountDuplicateException(newAccount.toString() + " this account already exists");
            }
        }
        return true;
    }

    private boolean addNewAccountToDataBase(final Account newAccount) {
        return this.accountList.add(newAccount);
    }

    public boolean isValid() {
        return true;
    }

    public List<ClientTransaction> getHistoryTransaction() {
        return this.historyTransaction;
    }

    public List<Account> getAccountList() {
        return this.accountList;
    }

    private List<ClientTransaction> getHistoryTransactionFromDataBase() {
        return new ArrayList<>();
    }

    private List<Account> getAccountListFromDataBase() {
        return new ArrayList<>();
    }
}
