package lk.jiat.ee.bank.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.transaction.TransactionSynchronizationRegistry;
import jakarta.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class BeanB {

    @Resource
    private UserTransaction transaction;

    public void doAction() {
        System.out.println("BeanB.doAction...");
        System.out.println(transaction);

    }
}
