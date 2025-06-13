package lk.jiat.ee.bank.ejb;

import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.*;
import lk.jiat.ee.bank.ejb.remote.AccountService;
import lk.jiat.ee.bank.ejb.remote.TransferService;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TransferServiceBean implements TransferService {

    @EJB
    private AccountService accountService;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction transaction;


    @Override
    //@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void transferAmount(String sourceAccountNo, String destinationAccountNo, double amount) {
        //Log - db

        try {
            transaction.begin();
            accountService.debitFromAccount(sourceAccountNo, amount);
            accountService.creditToAccount(destinationAccountNo, amount);
            transaction.commit();
        } catch (NotSupportedException e) {
            try {
                transaction.rollback();
            } catch (SystemException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (HeuristicRollbackException e) {
            throw new RuntimeException(e);
        } catch (HeuristicMixedException e) {
            throw new RuntimeException(e);
        } catch (RollbackException e) {
            throw new RuntimeException(e);
        }



        try {
            transaction.begin();
            //accountService.debitFromAccount(sourceAccountNo, amount);
            //accountService.creditToAccount(destinationAccountNo, amount);
            transaction.commit();
        } catch (Exception e) {
            try {
                transaction.rollback();
            } catch (SystemException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }

        //

    }
}
