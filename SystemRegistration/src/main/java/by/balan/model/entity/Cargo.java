package by.balan.model.entity;

import java.util.Set;

/**
 * Created by Ultrabook on 11.05.2015.
 */
public class Cargo {
    private Long idCargo;
    private Boolean danger;
    private Ship ship;
    private Container container;
    private Set<Bid> bids;
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
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
    

    public Boolean getDanger() {
        return danger;
    }

    public void setDanger(Boolean danger) {
        this.danger = danger;
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }
}
