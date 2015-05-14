package by.balan.controller.dao.Interface;

import by.balan.model.entity.Ship;

import java.sql.SQLException;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public interface ShipDAO {
    public void addShip(Ship ship)throws SQLException;

}
