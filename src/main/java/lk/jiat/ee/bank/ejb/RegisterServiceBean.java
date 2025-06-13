package lk.jiat.ee.bank.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.jiat.ee.bank.ejb.remote.RegisterService;
import lk.jiat.ee.bank.entity.User;

@Stateless
public class RegisterServiceBean implements RegisterService {

    @PersistenceContext(unitName = "BankPU")
    private EntityManager em;

    @Override
    public void registerUser(String name, String email, String password) {
        User user = new User(name, email, password);
        em.persist(user);
    }
}
