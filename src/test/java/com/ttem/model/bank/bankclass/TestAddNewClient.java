package com.ttem.model.bank.bankclass;

import com.ttem.model.account.Client;
import com.ttem.model.bank.Bank;
import org.junit.Assert;
import org.junit.Test;

public class TestAddNewClient {

    private static Bank bank = new Bank("ING");
    private static Client correctClient = new Client("Bob", "Ross");

    @Test
    public void whenInputCorrectClient() throws Exception {
        Client expectedClient = correctClient;

        Assert.assertTrue(bank.addNewClient(expectedClient));

        Client actualClient = bank.getClientDataBase().get(0);
        Assert.assertSame(expectedClient, actualClient);
    }
}
