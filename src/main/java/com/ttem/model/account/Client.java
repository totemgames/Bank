package com.ttem.model.account;

import com.ttem.exception.account.AccountDuplicateException;
import com.ttem.exception.account.AccountException;
import com.ttem.exception.transaction.client.ClientTransactionException;
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

    public boolean addNewAccount(final Account newAccount) throws AccountException {
        if (newAccount != null && newAccount.isValid() && isNewAccount(newAccount)){
            return addNewAccountToDataBase(newAccount);
        }
        return false;
    }

    public boolean doTransaction(final ClientTransaction transaction) throws ClientTransactionException {
        if (this.isValid() && transaction != null && transaction.doTransaction()){
            addTransactionToDataBase(transaction);
            return true;
        }
        return false;
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

    private boolean addTransactionToDataBase(final ClientTransaction transaction) {
        return this.historyTransaction.add(transaction);
    }

    private List<ClientTransaction> getHistoryTransactionFromDataBase() {
        return new ArrayList<>();
    }

    private List<Account> getAccountListFromDataBase() {
        return new ArrayList<>();
    }
}
