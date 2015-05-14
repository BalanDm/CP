package by.balan.controller.dao.Interface;

import by.balan.model.entity.Customer;

import java.sql.SQLException;

/**
 * Created by Ultrabook on 20.04.2015.
 */
public interface CustomerDAO {
    public void addCustomer(Customer customer) throws SQLException;
    public boolean searchEqualsCustomer(Customer customer) throws SQLException;
    public Customer getEqualsCustomer(String email) throws SQLException;
}
