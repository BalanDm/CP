package by.balan.controller.dao.Interface;

import by.balan.model.entity.Container;

import java.sql.SQLException;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public interface ContainerDAO {
    public void addContainer(Container container)throws SQLException;
}
