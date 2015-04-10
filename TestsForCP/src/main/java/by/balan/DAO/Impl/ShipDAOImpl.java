package by.balan.DAO.Impl;

/**
 * Created by Ultrabook on 08.04.2015.
 */
        import by.balan.DAO.ShipDAO;
        import by.balan.entity.Ship;
        import java.sql.SQLException;
        import java.util.Collection;
        import java.util.ArrayList;
        import java.util.List;
        import by.balan.persistence.HibernateUtil;
        import javax.swing.*;

        import org.hibernate.Hibernate;
        import org.hibernate.Session;

public class ShipDAOImpl implements ShipDAO {

    @Override
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

    @Override
    public void updateShip(Ship ship) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(ship);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Ship getShipById(Long ship_id) throws SQLException {
        Session session = null;
        Ship ship = new Ship();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ship= (Ship) session.get(Ship.class, new Long(ship_id));
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ship;
    }

    @Override
    public Ship getShipByName(String ship_name) throws SQLException {
        Session session = null;
        Ship ship = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ship= (Ship) session.get(Ship.class, new String(ship_name));
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ship;
    }

    @Override
    public Collection getAllShips() throws SQLException {
        Session session = null;
        List ships = new ArrayList<Ship>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            ships = session.createCriteria(Ship.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ships;
    }

    @Override
    public void deleteShip(Ship ship) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(ship);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
