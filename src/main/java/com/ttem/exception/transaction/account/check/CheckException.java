package com.ttem.exception.transaction.account.check;

import com.ttem.exception.transaction.account.AccountTransactionException;

public class CheckException extends AccountTransactionException {

    public CheckException() {
    }

    public CheckException(final String message) {
        super(message);
    }
}
