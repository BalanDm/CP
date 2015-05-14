package by.balan.controller.dao.Implementation;

import by.balan.controller.dao.Interface.CargoDAO;
import by.balan.controller.persistence.HibernateUtil;
import by.balan.model.entity.Cargo;
import by.balan.model.entity.Customer;
import by.balan.model.entity.Ship;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public class CargoDAOImpl implements CargoDAO {
    public void addCargo(Cargo cargo) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cargo);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Cargo getCargo(Long id) throws SQLException {
        Session session = null;
        Query query=null;
        Cargo cargo=null ;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            query = session.createQuery("from Cargo where id_cargo= :id");
            query.setLong("id", id);
            cargo=(Cargo)query.uniqueResult();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cargo;
    }
}
