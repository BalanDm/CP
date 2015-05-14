package by.balan.controller.persistence;

import by.balan.controller.dao.Implementation.*;
import by.balan.controller.dao.Interface.*;

/**
 * Created by Ultrabook on 08.04.2015.
 */
public class Factory {

    private static CustomerDAO customerDAO = null;
    private static ShipDAO shipDAO = null;
    private static OperatorDAO operatorDAO = null;
    private static ContainerDAO containerDAO=null;
    private static CargoDAO cargoDAO=null;
    private static BidDAO bidDAO=null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public ShipDAO getShipDAO() {
        if (shipDAO == null) {
            shipDAO = new ShipDAOImpl();
        }
        return shipDAO;
    }
    public OperatorDAO getOperatorDAO() {
        if (operatorDAO == null) {
            operatorDAO = new OperatorDAOImpl();
        }
        return operatorDAO;
    }
    public ContainerDAO getContainerDAO() {
        if (containerDAO == null) {
            containerDAO = new ContainerDAOImpl();
        }
        return containerDAO;
    }
    public CargoDAO getCargoDAO() {
        if (cargoDAO == null) {
            cargoDAO = new CargoDAOImpl();
        }
        return cargoDAO;
    }
    public BidDAO getBidDAO() {
        if (bidDAO == null) {
            bidDAO= new BidDAOImpl();
        }
        return bidDAO;
    }
    public CustomerDAO getCustomerDAO() {
        if (customerDAO == null) {
            customerDAO= new CustomerDAOImpl();
        }
        return customerDAO;
    }
}


