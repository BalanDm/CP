package by.balan.controller.dao.Implementation;

import by.balan.controller.dao.Interface.ShipDAO;
import by.balan.controller.persistence.HibernateUtil;
import by.balan.model.entity.Ship;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public class ShipDAOImpl implements ShipDAO {
    public void addShip(Ship ship) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(ship);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
