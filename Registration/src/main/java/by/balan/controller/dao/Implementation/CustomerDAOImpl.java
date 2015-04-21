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
            query = session.createQuery("from Customer where mail= :email or phone= :phone ");
            query.setString("email", customer.getMail());
            query.setInteger("phone", customer.getPhone());
            custList=query.list();
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
}
