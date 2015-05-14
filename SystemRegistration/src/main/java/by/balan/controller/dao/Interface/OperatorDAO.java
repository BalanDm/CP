package by.balan.controller.dao.Interface;

import by.balan.model.entity.Operator;

import java.sql.SQLException;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public interface OperatorDAO {
    public void addOperator(Operator operator)throws SQLException;
}
