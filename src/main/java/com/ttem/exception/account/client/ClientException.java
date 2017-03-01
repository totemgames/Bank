package com.ttem.exception.account.client;

import com.ttem.exception.bank.BankException;

public class ClientException extends BankException {

    public ClientException() {
    }

    public ClientException(final String message) {
        super(message);
    }
}
