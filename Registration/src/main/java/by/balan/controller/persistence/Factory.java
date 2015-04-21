package by.balan.controller.persistence;

import by.balan.controller.dao.Implementation.CustomerDAOImpl;
import by.balan.controller.dao.Interface.CustomerDAO;

/**
 * Created by Ultrabook on 08.04.2015.
 */
public class Factory {

    private static CustomerDAO customerDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public CustomerDAO getCustomerDAO() {
        if (customerDAO == null) {
            customerDAO = new CustomerDAOImpl();
        }
        return customerDAO;
    }
}


