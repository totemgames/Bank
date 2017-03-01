package com.ttem.model.transaction.account.depositclass;

import com.ttem.model.account.Account;
import com.ttem.model.transaction.account.Deposit;
import org.junit.BeforeClass;

public class TestDoTransaction {

    private static Account correctAccount;
    private static Account incorrectAccountNumber;

    private static Deposit correctDeposit;
    private static Deposit incorrectDepositAmount;
    private static Deposit incorrectDepositAccountNumber;
    private static Deposit incorrectDepositAccountNull;

    @BeforeClass
    public static void setUp() throws Exception {
        correctAccount = new Account(new byte[15], "correct");
        incorrectAccountNumber = new Account(new byte[12], "incorrect number");

        correctDeposit = new Deposit(2.3, correctAccount, "correct deposit");
        incorrectDepositAmount = new Deposit(-3.4, correctAccount, "incorrect amount");
        incorrectDepositAccountNumber = new Deposit(3.4, incorrectAccountNumber, "incorrect account number");
        incorrectDepositAccountNull = new Deposit(3.4, null, "incorrect account null");
    }
}
