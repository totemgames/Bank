package com.ttem.view.console;

import com.ttem.model.account.Client;
import com.ttem.model.bank.Bank;
import com.ttem.view.DefaultView;

public class ConsoleView implements DefaultView {

    @Override
    public void printBank(final Bank bank) {
        System.out.println(bank.getName());
        System.out.println("Clients list:");
        for (Client c : bank.getClientDataBase()) {
            System.out.println(c.getFirstName());
        }
        System.out.println();
    }
}
