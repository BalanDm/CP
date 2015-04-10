package by.balan.DAO;
import by.balan.entity.Ship;


import java.util.Collection;
import java.sql.SQLException;

/**
 * Created by Ultrabook on 08.04.2015.
 */

public interface ShipDAO {
    public void addShip(Ship ship) throws SQLException;
    public void updateShip(Ship ship) throws SQLException;
    public Ship getShipById(Long ship_id) throws SQLException;
    public Ship getShipByName(String ship_name) throws SQLException;
    public Collection getAllShips() throws SQLException;
    public void deleteShip(Ship ship) throws SQLException;
   // public Collection getBussesByDriver(Cargo driver) throws SQLException;
   // public Collection getBussesByRoute(Route route) throws SQLException;

}
