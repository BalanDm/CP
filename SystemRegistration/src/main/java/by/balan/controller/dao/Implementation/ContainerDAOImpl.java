package by.balan.controller.dao.Implementation;

import by.balan.controller.dao.Interface.ContainerDAO;
import by.balan.controller.persistence.HibernateUtil;
import by.balan.model.entity.Container;
import by.balan.model.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public class ContainerDAOImpl implements ContainerDAO {
    public void addContainer(Container container) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(container);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean searchEquals(String id) throws SQLException {
        Session session = null;
        Query query=null;
        List<Customer> custList=null ;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            query = session.createQuery("from Container where id_container= :id");
            query.setString("id", id);
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
