package com.ttem.model.bank;

import com.ttem.model.account.Client;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final String name;
    private final List<Client> clientDataBase;

    public Bank(final String name) {
        this.name = name;
        this.clientDataBase = getClientListFromDataBase();
    }

    public String getName() {
        return this.name;
    }

    public List<Client> getClientDataBase() {
        return this.clientDataBase;
    }

    private List<Client> getClientListFromDataBase() {
        return new ArrayList<>();
    }
}
