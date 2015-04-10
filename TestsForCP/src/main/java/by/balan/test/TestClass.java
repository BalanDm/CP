package by.balan.test;

import by.balan.entity.Ship;
import by.balan.persistence.Factory;
import by.balan.persistence.HibernateUtil;
import junit.framework.TestCase;
import org.hibernate.Session;


import java.sql.SQLException;

/**
 * Created by balan on 22.12.2014.
 */

public class TestClass extends TestCase {
    public TestClass(String testName) {
        super(testName);
    }

    public void testOpenSession(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        assertTrue("Не удалось открыть сессию!",session.isOpen());
}
    public void testInsertToShip()
    {
        boolean notWrite=false;
        Ship ship =new Ship();
        ship.setShipName("Apolon");
        ship.setShipNumber("APL1267");
        try {
            Factory.getInstance().getShipDAO().addShip(ship);
        } catch (SQLException e) {
            notWrite=true;
        }
        assertTrue("Данные не записались в БД", !notWrite);
    }
    public void testReadToShip()
    {
        boolean notWrite=false;
        Ship ship=null;
        ship=new Ship();
        try {
            Factory.getInstance().getShipDAO().getShipById(1L);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertNotNull("Данные не прочитались из БД", ship);
    }

    public void testInsertEqualsRead() throws SQLException {
        boolean notEquals=false;
        Ship ship =new Ship();
        Ship shipTest=new Ship();
        ship.setShipName("Ship123");
        ship.setShipNumber("Number123");
        Factory.getInstance().getShipDAO().addShip(ship);
        shipTest=Factory.getInstance().getShipDAO().getShipById(14L);
        if(shipTest.getShipName()!=ship.getShipName()
                || shipTest.getShipNumber()!=ship.getShipNumber())
        {
            notEquals=true;
        }
        assertTrue("Переданные данные не равны полученым",notEquals);
    }
}
