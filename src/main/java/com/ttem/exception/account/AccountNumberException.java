package com.ttem.exception.account;

import com.ttem.exception.account.AccountException;

public class AccountNumberException extends AccountException {

    public AccountNumberException() {
    }

    public AccountNumberException(final String message) {
        super(message);
    }
}
