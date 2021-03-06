package com.ttem.model.transaction.client.wireoutclass;

import com.ttem.exception.transaction.TransactionException;
import com.ttem.exception.transaction.client.wireout.WireOutException;
import com.ttem.exception.transaction.client.wireout.valid.WireOutAccountException;
import com.ttem.exception.transaction.client.wireout.valid.WireOutAmountException;
import com.ttem.exception.transaction.client.wireout.valid.WireOutSwiftException;
import com.ttem.model.account.Account;
import com.ttem.model.transaction.client.WireOut;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDoTransaction {

    private static Account correctAccount;
    private static Account incorrectAccountNumber;

    private static WireOut correctWireOut;
    private static WireOut incorrectWireOutAmount;
    private static WireOut incorrectWireOutSwift;
    private static WireOut incorrectWireOutAccountNumber;
    private static WireOut incorrectWireOutAccountNull;

    @BeforeClass
    public static void setUp() {
        correctAccount = new Account(new byte[15], "correct");
        incorrectAccountNumber = new Account(new byte[12], "incorrect number");

        correctWireOut = new WireOut.Builder()
                .setAmount(23.3)
                .setToAccount(correctAccount)
                .setSwift(new byte[15])
                .setCountry("USA")
                .setDescription("from Poland")
                .build();

        incorrectWireOutAmount = new WireOut.Builder()
                .setAmount(-11.4)
                .setToAccount(correctAccount)
                .setSwift(new byte[15])
                .setCountry("USA")
                .setDescription(" from Poland")
                .build();

        incorrectWireOutSwift = new WireOut.Builder()
                .setAmount(3.2)
                .setToAccount(correctAccount)
                .setSwift(new byte[12])
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

    @Test
    public void whenInputCorrectWireOut() throws TransactionException {
        Assert.assertTrue(correctWireOut.doTransaction());
    }

    @Test(expected = WireOutAmountException.class)
    public void whenInputIncorrectWireOutAmount() throws TransactionException {
        incorrectWireOutAmount.doTransaction();
    }

    @Test(expected = WireOutSwiftException.class)
    public void whenInputIncorrectWireOutSwift() throws WireOutException {
        incorrectWireOutSwift.doTransaction();
    }

    @Test(expected = WireOutAccountException.class)
    public void whenInputIncorrectWireOutAccountNumber() throws TransactionException {
        incorrectWireOutAccountNumber.doTransaction();
    }

    @Test
    public void whenInputIncorrectWireOutAccountNull() throws TransactionException {
        Assert.assertFalse(incorrectWireOutAccountNull.doTransaction());
    }
}
