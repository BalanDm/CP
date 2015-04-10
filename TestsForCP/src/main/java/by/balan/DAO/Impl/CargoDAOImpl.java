package by.balan.DAO.Impl;

import by.balan.DAO.CargoDAO;
import by.balan.entity.Cargo;
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
public class CargoDAOImpl implements CargoDAO {
    @Override
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

    @Override
    public void updateCargo(Cargo cargo) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cargo);
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
    public Cargo getCargoById(Long cargo_id) throws SQLException {
        Session session = null;
        Cargo cargo = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cargo = (Cargo) session.load(Cargo.class, cargo_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cargo;
    }

    @Override
    public Collection getAllCargos() throws SQLException {
        Session session = null;
        List cargos = new ArrayList<Cargo>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cargos = session.createCriteria(Cargo.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cargos;
    }

    @Override
    public void deleteCargo(Cargo cargo) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cargo);
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
