package by.balan.controller.dao.Interface;

import by.balan.model.entity.Cargo;
import by.balan.model.entity.Ship;

import java.sql.SQLException;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public interface CargoDAO {
    public void addCargo(Cargo cargo)throws SQLException;
    public Cargo getCargo(Long id)throws SQLException;
}
