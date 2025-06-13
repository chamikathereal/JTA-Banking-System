package lk.jiat.ee.bank.ejb.remote;

public interface TransferService {
    void transferAmount(String sourceAccountNo, String destinationAccountNo, double amount);
}
