package com.ttem.exception.transaction.client.wireout;

import com.ttem.exception.transaction.client.ClientTransactionException;

public class WireOutException extends ClientTransactionException {

    public WireOutException() {
    }

    public WireOutException(final String message) {
        super(message);
    }
}
