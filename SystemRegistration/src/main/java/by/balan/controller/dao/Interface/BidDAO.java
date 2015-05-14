package by.balan.controller.dao.Interface;

import by.balan.model.entity.Bid;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public interface BidDAO {
    public void addBid(Bid bid) throws SQLException;
    public List<Bid> getAllUserBid(Long id) throws  SQLException;
    public void delete(Long id)throws SQLException;
    public List<Bid>SearchByNumBid(Long idBid,Long idCust)throws SQLException;
    public List<Bid>SearchByNumShip(String idShip,Long idCust)throws SQLException;
    public List<Bid>SearchByDateOp(String date,Long idCust)throws SQLException;
    public List<Bid>SearchByNumContainer(String idContainer,Long idCust)throws SQLException;
}
