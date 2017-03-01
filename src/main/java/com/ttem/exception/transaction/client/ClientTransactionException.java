package com.ttem.exception.transaction.client;

import com.ttem.exception.transaction.TransactionException;

public class ClientTransactionException extends TransactionException {

    public ClientTransactionException() {
    }

    public ClientTransactionException(final String message) {
        super(message);
    }
}
