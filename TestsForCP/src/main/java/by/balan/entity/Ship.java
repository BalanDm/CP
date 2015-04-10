package by.balan.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ultrabook on 07.04.2015.
 */
public class Ship implements Serializable {

    private Long shipID;
    private String shipName;
    private String shipNumber;
    private Set cargos = new HashSet();

    public Ship() {
    }

    public Ship(Long shipID, String shipName, String shipNumber, Set cargos) {

        this.shipID = shipID;
        this.shipName = shipName;
        this.shipNumber = shipNumber;
        this.cargos = cargos;
    }

    public Set getCargos() {
        return cargos;
    }

    public void setCargos(Set cargos) {
        this.cargos = cargos;
    }



    public String getShipNumber() {
        return shipNumber;
    }

    public void setShipNumber(String shipNumber) {
        this.shipNumber = shipNumber;
    }

    public Long getShipID() {
        return shipID;
    }

    public void setShipID(Long shipID) {
        this.shipID = shipID;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

}
