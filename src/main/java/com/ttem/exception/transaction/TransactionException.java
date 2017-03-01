package com.ttem.exception.transaction;

import com.ttem.exception.bank.BankException;

public class TransactionException extends BankException {

    public TransactionException() {
    }

    public TransactionException(final String message) {
        super(message);
    }
}
