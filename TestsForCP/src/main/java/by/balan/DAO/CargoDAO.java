package by.balan.DAO;

import by.balan.entity.Cargo;
import by.balan.entity.Container;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Ultrabook on 08.04.2015.
 */
public interface CargoDAO {
    public void addCargo(Cargo cargo) throws SQLException;
    public void updateCargo(Cargo cargo) throws SQLException;
    public Cargo getCargoById(Long cargo_id) throws SQLException;
    public Collection getAllCargos() throws SQLException;
    public void deleteCargo(Cargo cargo) throws SQLException;
}
