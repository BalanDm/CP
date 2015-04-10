package by.balan.DAO;

import by.balan.entity.Container;
import by.balan.entity.Ship;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Ultrabook on 08.04.2015.
 */
public interface ContainerDAO {
    public void addContainer(Container container) throws SQLException;
    public void updateContainer(Container container) throws SQLException;
    public Container getContainerpById(Long container_id) throws SQLException;
    public Collection getAllContainers() throws SQLException;
    public void deleteContainer(Container container) throws SQLException;
}
