package by.balan.controller.dao.Implementation;

import by.balan.controller.dao.Interface.CustomerDAO;
import by.balan.controller.persistence.HibernateUtil;
import by.balan.model.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ultrabook on 20.04.2015.
 */
public class CustomerDAOImpl implements CustomerDAO {
    public void addCustomer(Customer customer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean searchEqualsCustomer(Customer customer) throws SQLException {
        Session session = null;
        Query query=null;
        List<Customer> custList=null ;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            query = session.createQuery("from Customer where mail= :email and password= :password ");
            query.setString("email", customer.getMail());
            query.setString("password", customer.getPassword());
            custList=query.list();
            customer.setIdCustomer(custList.get(0).getIdCustomer());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        if(custList.size()!=0)
              return true;
        else return false;
    }


    public Customer getEqualsCustomer(String email) throws SQLException {
        Session session = null;
        Query query=null;
        Customer customer=null ;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            query = session.createQuery("from Customer where mail= :email");
            query.setString("email", email);
            customer=(Customer)query.uniqueResult();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customer;
    }
}
