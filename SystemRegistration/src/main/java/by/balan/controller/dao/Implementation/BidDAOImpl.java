package by.balan.controller.dao.Implementation;

import by.balan.controller.dao.Interface.BidDAO;
import by.balan.controller.persistence.HibernateUtil;
import by.balan.model.entity.Bid;
import by.balan.model.entity.Customer;
import by.balan.model.entity.Operator;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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

    public void updateDateBid(String date,Long id,String status,Operator operator) throws SQLException {
        Session session = null;
        Bid updateBid;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            updateBid=(Bid)session.load(Bid.class, id);
            updateBid.setDateOp(date);
            updateBid.setStatus(status);
            updateBid.setOperator(operator);
            session.update(updateBid);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
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

    public boolean checkBidById(Long id) throws SQLException {
        Session session = null;
        Query query=null;
        List<Bid> bids=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            query = session.createQuery("from Bid where id_bid= :id");
            query.setLong("id",id);
            bids= query.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        if(bids.size()!=0)
            return true;
        else return false;
    }

    public List<Bid> getAllBidByAdmin() throws SQLException {
        Session session = null;
        Query query=null;
        List<Bid> bids=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            query = session.createQuery("from Bid where status!='rejected'");
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

    public List<Bid> getAllBid() throws SQLException {
        Session session = null;
        Query query=null;
        List<Bid> bids=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            query = session.createQuery("from Bid");
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

    public List<Bid> SearchByNumBid(Long idBid,Long idCust) throws SQLException {
        Session session = null;
        Query query=null;
        List<Bid> bids=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            if(idCust!=null) {
                query = session.createQuery("from Bid where Customer_id= :custId and id_bid= :id");
                query.setLong("custId",idCust);
            }else query = session.createQuery("from Bid where status!='rejected' and id_bid= :id");
            query.setLong("id", idBid);
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

    public List<Bid> SearchByNumShip(String idShip,Long idCust) throws SQLException {
        Session session = null;
        SQLQuery query=null;
        List<Bid> bids=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            if(idCust!=null) {
                query = session.createSQLQuery("select Bid.* from Bid as bid INNER JOIN Cargo as cargo ON cargo.id_cargo=bid.Cargo_id_cargo WHERE cargo.Ship_id_ship= :idShip and bid.Customer_id= :id");
                query.setParameter("id", idCust);
            }else query = session.createSQLQuery("select Bid.* from Bid as bid INNER JOIN Cargo as cargo ON cargo.id_cargo=bid.Cargo_id_cargo WHERE cargo.Ship_id_ship= :idShip and bid.status !='rejected'");
            query.addEntity(Bid.class);
            query.setParameter("idShip", idShip);;
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

    public List<Bid> SearchByDateOp(String date,Long idCust) throws SQLException {
        Session session = null;
        Query query=null;
        List<Bid> bids=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            if(idCust!=null) {
                query = session.createQuery("from Bid where Customer_id= :custId and date_operation= :date");
                query.setLong("custId",idCust);
            }else  query = session.createQuery("from Bid where date_operation= :date and  status!='rejected' ");
            query.setString("date", date);
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

    public List<Bid> SearchByNumContainer(String idContainer,Long idCust) throws SQLException {
        Session session = null;
        SQLQuery query=null;
        List<Bid> bids=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            if(idCust!=null) {
                query = session.createSQLQuery("select Bid.* from Bid as bid INNER JOIN Cargo as cargo ON cargo.id_cargo=bid.Cargo_id_cargo WHERE cargo.Container_id_container= :idContainer and bid.Customer_id= :id");
            }else  query = session.createSQLQuery("select Bid.* from Bid as bid INNER JOIN Cargo as cargo ON cargo.id_cargo=bid.Cargo_id_cargo WHERE cargo.Container_id_container= :idContainer and bid.status!='rejected'");
            query.addEntity(Bid.class);
            query.setParameter("idContainer", idContainer);
            query.setParameter("id", idCust);
            bids=query.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bids;
    }

    public List<Bid> SearchByNumCargo(Long idCargo, Long idCust) throws SQLException {
        Session session = null;
        SQLQuery query=null;
        List<Bid> bids=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            if(idCust!=null) {
                query = session.createSQLQuery("SELECT Bid.* from Bid as bid INNER JOIN Cargo as cargo ON cargo.id_cargo = bid.Cargo_id_cargo WHERE number= :idCargo and bid.Customer_id= :id");
                query.setParameter("id", idCust);
            }else query = session.createSQLQuery("SELECT Bid.* from Bid as bid INNER JOIN Cargo as cargo ON cargo.id_cargo = bid.Cargo_id_cargo WHERE number= :idCargo and status !='rejected'");
            query.addEntity(Bid.class);
            query.setLong("idCargo", idCargo);
            bids= (List<Bid>)query.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bids;
    }

    public List<Bid> SearchClients(String searchParam) throws SQLException {
        Session session = null;
        SQLQuery query=null;
        List<Bid> bids=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            query = session.createSQLQuery("select Bid.* from Bid as bid INNER JOIN Customer as cust ON bid.Customer_id=cust.id where (cust.organization= :search or cust.mail= :search) and status != 'rejected'");
            query.addEntity(Bid.class);
            query.setParameter("search", searchParam);
            bids= (List<Bid>)query.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bids;
    }
}
