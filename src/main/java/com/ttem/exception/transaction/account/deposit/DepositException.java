package com.ttem.exception.transaction.account.deposit;

import com.ttem.exception.transaction.account.AccountTransactionException;

public class DepositException extends AccountTransactionException {

    public DepositException() {
    }

    public DepositException(final String message) {
        super(message);
    }
}
