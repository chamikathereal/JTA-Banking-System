package lk.jiat.ee.bank.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.transaction.*;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class BeanA {
    @EJB
    private BeanB beanB;

    @Resource
    private UserTransaction transaction;

    @Resource
    private SessionContext sessionContext;

    public void doAction() {
        System.out.println("BeanA.doAction...");
        System.out.println(transaction);
        beanB.doAction();
        doWork();
    }

    public void doWork() {
        System.out.println("BeanA doWork: " + transaction);
    }

    public void doWork1() {
        System.out.println("BeanA doWork: " + transaction);
    }


}
