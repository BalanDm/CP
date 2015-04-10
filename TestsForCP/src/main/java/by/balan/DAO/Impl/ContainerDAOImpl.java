package by.balan.DAO.Impl;

import by.balan.DAO.ContainerDAO;
import by.balan.entity.Container;
import by.balan.persistence.HibernateUtil;
import org.hibernate.Session;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ultrabook on 08.04.2015.
 */
public class ContainerDAOImpl implements ContainerDAO {
    @Override
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

    @Override
    public void updateContainer(Container container) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(container);
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
    public Container getContainerpById(Long container_id) throws SQLException {
        Session session = null;
        Container container = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            container = (Container) session.load(Container.class, container_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return container;
    }

    @Override
    public Collection getAllContainers() throws SQLException {
        Session session = null;
        List containers = new ArrayList<Container>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            containers = session.createCriteria(Container.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return containers;
    }

    @Override
    public void deleteContainer(Container container) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(container);
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
