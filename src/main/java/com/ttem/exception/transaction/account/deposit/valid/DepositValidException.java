package com.ttem.exception.transaction.account.deposit.valid;

import com.ttem.exception.transaction.account.deposit.DepositException;

public class DepositValidException extends DepositException {

    public DepositValidException() {
    }

    public DepositValidException(final String message) {
        super(message);
    }
}
