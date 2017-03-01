package com.ttem.model.account.clientclass;

import com.ttem.model.account.Account;
import com.ttem.model.account.Client;
import com.ttem.model.transaction.client.WireOut;
import org.junit.BeforeClass;

public class TestDoTransaction {

    private static Account correctAccount;
    private static Account incorrectAccountNumber;

    private static Client correctClient;

    private static WireOut correctWireOut;
    private static WireOut incorrectWireOutSwift;
    private static WireOut incorrectWireOutAccountNumber;
    private static WireOut incorrectWireOutAccountNull;

    @BeforeClass
    public static void setUp() {
        correctAccount = new Account(new byte[15], "correct");
        incorrectAccountNumber = new Account(new byte[12], "incorrect number");

        correctClient = new Client("Bob", "Ross");

        correctWireOut = new WireOut.Builder()
                .setAmount(23.3)
                .setToAccount(correctAccount)
                .setSwift(new byte[15])
                .setCountry("USA")
                .setDescription("from Poland")
                .build();

        incorrectWireOutSwift = new WireOut.Builder()
                .setAmount(23.3)
                .setToAccount(correctAccount)
                .setSwift(new byte[19])
                .setCountry("USA")
                .setDescription("from Poland")
                .build();

        incorrectWireOutAccountNumber = new WireOut.Builder()
                .setAmount(3.2)
                .setToAccount(incorrectAccountNumber)
                .setSwift(new byte[15])
                .setCountry("USA")
                .setDescription("from Poland")
                .build();

        incorrectWireOutAccountNull = new WireOut.Builder()
                .setAmount(3.2)
                .setToAccount(null)
                .setSwift(new byte[15])
                .setCountry("USA")
                .setDescription("from Poland")
                .build();
    }
}
