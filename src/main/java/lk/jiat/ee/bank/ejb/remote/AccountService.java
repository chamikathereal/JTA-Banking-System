package lk.jiat.ee.bank.ejb.remote;

import lk.jiat.ee.bank.entity.Account;

public interface AccountService {
    void creditToAccount(String accountNo, double amount);
    void debitFromAccount(String accountNo, double amount);
}
