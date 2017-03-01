package com.ttem.model.account.accountclass;

import com.ttem.exception.account.AccountException;
import com.ttem.exception.transaction.TransactionException;
import com.ttem.model.account.Account;
import com.ttem.model.transaction.account.Check;
import com.ttem.model.transaction.account.Deposit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDoTransaction {

    private static Account correctAccount;
    private static Account incorrectAccountNumber;

    private static Check correctCheck;
    private static Deposit correctDeposit;

    @BeforeClass
    public static void setUp() {
        correctAccount = new Account(new byte[15], "correct");
        incorrectAccountNumber = new Account(new byte[12], "incorrect number");

        correctCheck = new Check(2.3, correctAccount, "correct check");
        correctDeposit = new Deposit(2.3, correctAccount, "correct deposit");
    }

    @Test
    public void correctAccountWhenInputCorrectCheck() throws AccountException, TransactionException {
        Assert.assertTrue(correctAccount.doTransaction(correctCheck));
    }

    @Test
    public void correctAccountWhenInputCorrectDeposit() throws AccountException, TransactionException {
        Assert.assertTrue(correctAccount.doTransaction(correctDeposit));
    }
}
