package com.ttem.exception.transaction.account.deposit.valid;

public class DepositDoneException extends DepositValidException {

    public DepositDoneException() {
    }

    public DepositDoneException(final String message) {
        super(message);
    }
}
