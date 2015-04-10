package by.balan.persistence;
import by.balan.DAO.Impl.CargoDAOImpl;
import by.balan.DAO.Impl.ContainerDAOImpl;
import by.balan.DAO.Impl.ShipDAOImpl;
import by.balan.DAO.*;
import by.balan.entity.Cargo;

/**
 * Created by Ultrabook on 08.04.2015.
 */
public class Factory {

    private static ShipDAO shipDAO = null;
    private static ContainerDAO containerDAO = null;
    private static CargoDAO cargoDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public ShipDAO getShipDAO(){
        if (shipDAO == null){
            shipDAO = new ShipDAOImpl();
        }
        return shipDAO;
    }

    public ContainerDAO getContainerDAO(){
        if (containerDAO == null){
            containerDAO = new ContainerDAOImpl();
        }
        return containerDAO;
    }
    public CargoDAO getCargoDAO(){
        if (cargoDAO == null){
            cargoDAO = new CargoDAOImpl();
        }
        return cargoDAO;
    }
}
