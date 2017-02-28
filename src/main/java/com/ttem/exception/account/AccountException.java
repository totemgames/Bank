package com.ttem.exception.account;

import com.ttem.exception.bank.BankException;

public class AccountException extends BankException{

    public AccountException() {
    }

    public AccountException(final String message) {
        super(message);
    }
}
