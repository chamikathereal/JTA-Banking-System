package lk.jiat.ee.bank.ejb;

import jakarta.ejb.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import lk.jiat.ee.bank.ejb.remote.AccountService;
import lk.jiat.ee.bank.entity.Account;

@Stateless
//@TransactionManagement(TransactionManagementType.BEAN)
public class AccountServiceBean implements AccountService {

    @PersistenceContext
    private EntityManager em;


    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void creditToAccount(String accountNo, double amount) {
        try {
            Account account = em.createNamedQuery("Account.findByAccountNo", Account.class)
                    .setParameter("accountNo", accountNo)
                    .getSingleResult();
            if (amount > 0) {
                account.setBalance(account.getBalance() + amount);
            }
            em.merge(account);
        } catch (NoResultException e) {
            e.printStackTrace();
        }

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void debitFromAccount(String accountNo, double amount) {
        try {
            Account account = em.createNamedQuery("Account.findByAccountNo", Account.class)
                    .setParameter("accountNo", accountNo)
                    .getSingleResult();
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                em.merge(account);
            }
        }catch (NoResultException e) {
            e.printStackTrace();
        }
    }
}
