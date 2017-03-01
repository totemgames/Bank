package com.ttem.exception.transaction.account;

import com.ttem.exception.transaction.TransactionException;

public class AccountTransactionException extends TransactionException {

    public AccountTransactionException() {
    }

    public AccountTransactionException(final String message) {
        super(message);
    }
}
