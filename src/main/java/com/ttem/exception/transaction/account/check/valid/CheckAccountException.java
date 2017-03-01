package com.ttem.exception.transaction.account.check.valid;

import com.ttem.exception.transaction.account.check.valid.CheckValidException;

public class CheckAccountException extends CheckValidException {

    public CheckAccountException() {
    }

    public CheckAccountException(final String message) {
        super(message);
    }
}
