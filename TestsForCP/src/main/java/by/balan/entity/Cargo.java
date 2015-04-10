package by.balan.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ultrabook on 07.04.2015.
 */
public class Cargo implements Serializable {

    private Long cargoID;
    private boolean cargoDanger;
    private String cargoOperation;
    private String cargoProperties;
    private String cargoDateOperation;
    private int containerID;
    private int shipID;
    private double cargoWeight;
    private Ship ship;
    private Container container;
    private String number;
    private int cargoQuantity;

    public int getCargoQuantity() {
        return cargoQuantity;
    }

    public void setCargoQuantity(int cargoQuantity) {
        this.cargoQuantity = cargoQuantity;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getCargoProperties() {
        return cargoProperties;
    }

    public void setCargoProperties(String cargoProperties) {
        this.cargoProperties = cargoProperties;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }


    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }



    public int getShipID() {
        return shipID;
    }

    public void setShipID(int shipID) {
        this.shipID = shipID;
    }


    public Long getCargoID() {
        return cargoID;
    }

    public void setCargoID(Long cargoID) {
        this.cargoID = cargoID;
    }

    public boolean isCargoDanger() {
        return cargoDanger;
    }

    public void setCargoDanger(boolean cargoDanger) {
        this.cargoDanger = cargoDanger;
    }

    public String getCargoOperation() {
        return cargoOperation;
    }

    public void setCargoOperation(String cargoOperation) {
        this.cargoOperation = cargoOperation;
    }

    public String getCargoDateOperation() {
        return cargoDateOperation;
    }

    public void setCargoDateOperation(String cargoDateOperation) {
        this.cargoDateOperation = cargoDateOperation;
    }

    public int getContainerID() {
        return containerID;
    }

    public void setContainerID(int containerID) {
        this.containerID = containerID;
    }


}
