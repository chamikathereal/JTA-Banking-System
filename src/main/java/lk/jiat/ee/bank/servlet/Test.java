package lk.jiat.ee.bank.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.ee.bank.ejb.BeanA;
import lk.jiat.ee.bank.ejb.BeanB;

import java.io.IOException;

@WebServlet("/test")
public class Test extends HttpServlet {

    @EJB
    private BeanA beanA;
    @EJB
    private BeanB beanB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        beanA.doAction();
        //beanB.doAction();
    }
}
