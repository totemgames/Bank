package com.ttem.exception.transaction.account.check.valid;

import com.ttem.exception.transaction.account.check.CheckException;

public class CheckValidException extends CheckException {

    public CheckValidException() {
    }

    public CheckValidException(final String message) {
        super(message);
    }
}
