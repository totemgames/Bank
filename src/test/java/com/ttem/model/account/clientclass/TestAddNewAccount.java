package com.ttem.model.account.clientclass;

import com.ttem.model.account.Account;
import com.ttem.model.account.Client;
import org.junit.BeforeClass;

public class TestAddNewAccount {

    private static Account correctAccount;
    private static Account incorrectAccountNumber;
    private static Account incorrectAccountNull;

    private static Client correctClient;

    @BeforeClass
    public static void setUp() {
        correctAccount = new Account(new byte[15], "correct");
        incorrectAccountNumber = new Account(new byte[12], "incorrect number");
        incorrectAccountNull = null;

        correctClient = new Client("Bob", "Ross");
    }
}
