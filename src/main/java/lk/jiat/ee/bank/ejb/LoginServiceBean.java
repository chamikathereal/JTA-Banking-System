package lk.jiat.ee.bank.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import lk.jiat.ee.bank.ejb.remote.LoginService;
import lk.jiat.ee.bank.entity.User;

@Stateless
public class LoginServiceBean implements LoginService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean login(String email, String password) {

        try {
            User user = em.createNamedQuery("User.findByEmailAndPassword", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
            return true;
        }catch (NoResultException e){
            return false;
        }
    }
}
