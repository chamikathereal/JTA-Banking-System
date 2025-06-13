package lk.jiat.ee.bank.ejb.remote;

import jakarta.ejb.Local;
import lk.jiat.ee.bank.entity.Account;
@Local
public interface RegisterService {
    void registerUser(String name,String email,String password);
}
