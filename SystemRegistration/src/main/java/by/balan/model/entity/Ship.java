package by.balan.model.entity;

import java.util.Set;

/**
 * Created by Ultrabook on 11.05.2015.
 */
public class Ship {
    private String name;
    private Set<Cargo> cargos;
    private String idShip;

    public String getIdShip() {
        return idShip;
    }

    public void setIdShip(String idShip) {
        this.idShip = idShip;
    }

    public Set<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
