package com.ttem.model.transaction.account.checkclass;

import com.ttem.model.account.Account;
import com.ttem.model.transaction.account.Check;
import org.junit.BeforeClass;

public class TestDoTransaction {

    private static Account correctAccount;
    private static Account incorrectAccountNumber;

    private static Check correctCheck;
    private static Check incorrectCheckAmount;
    private static Check incorrectCheckAccountNumber;
    private static Check incorrectCheckAccountNull;

    @BeforeClass
    public static void setUp() {
        correctAccount = new Account(new byte[15], "correct");
        incorrectAccountNumber = new Account(new byte[12], "incorrect number");

        correctCheck = new Check(2.3, correctAccount, "correct check");
        incorrectCheckAmount = new Check(-3.4, correctAccount, "incorrect amount");
        incorrectCheckAccountNumber = new Check(3.4, incorrectAccountNumber, "incorrect account number");
        incorrectCheckAccountNull = new Check(3.4, null, "incorrect account null");
    }
}
