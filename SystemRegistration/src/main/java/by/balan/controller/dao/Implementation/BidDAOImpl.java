package by.balan.controller.dao.Implementation;

import by.balan.controller.dao.Interface.BidDAO;
import by.balan.controller.persistence.HibernateUtil;
import by.balan.model.entity.Bid;
import by.balan.model.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public class BidDAOImpl implements BidDAO {
    public void addBid(Bid bid) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(bid);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Bid> getAllUserBid(Long id) throws SQLException {
        Session session = null;
        Query query=null;
        List<Bid> bids=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            query = session.createQuery("from Bid where Customer_id= :id");
            query.setLong("id", id);
            bids= query.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bids;
    }

    public void delete(Long id) throws SQLException {
        Session session = null;
        Query query=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            query=session.createQuery("delete from Bid where id_bid= :id");
            query.setLong("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Bid> SearchByNumBid(Long idBid,Long idCust) throws SQLException {
        Session session = null;
        Query query=null;
        List<Bid> bids=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            query = session.createQuery("from Bid where Customer_id= :custId and id_bid= :id");
            query.setLong("id", idBid);
            query.setLong("custId",idCust);
            bids= query.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bids;
    }

    public List<Bid> SearchByNumShip(String idShip,Long IdCust) throws SQLException {
        return null;
    }

    public List<Bid> SearchByDateOp(String date,Long idCust) throws SQLException {
        Session session = null;
        Query query=null;
        List<Bid> bids=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            query = session.createQuery("from Bid where Customer_id= :custId and date_operation= :date");
            query.setString("date", date);
            query.setLong("custId",idCust);
            bids= query.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bids;
    }

    public List<Bid> SearchByNumContainer(String idContainer,Long IdCust) throws SQLException {
        return null;
    }
}
