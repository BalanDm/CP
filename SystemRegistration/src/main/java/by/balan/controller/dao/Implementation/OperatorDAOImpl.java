package by.balan.controller.dao.Implementation;

import by.balan.controller.dao.Interface.OperatorDAO;
import by.balan.controller.persistence.HibernateUtil;
import by.balan.model.entity.Customer;
import by.balan.model.entity.Operator;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public class OperatorDAOImpl implements OperatorDAO {
    public void addOperator(Operator operator) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(operator);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean searchOperEquals(Operator operator) throws SQLException {
        Session session = null;
        Query query=null;
        List<Operator> operList=null ;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            query = session.createQuery("from Operator where login= :login and password= :password ");
            query.setString("login", operator.getLogin());
            query.setString("password", operator.getPassword());
            operList=query.list();
            operator.setIdOperator(operList.get(0).getIdOperator());
            operator.setName(operList.get(0).getName());
            operator.setLastName(operList.get(0).getLastName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        if(operList.size()!=0)
            return true;
        else return false;
    }
}
