package by.balan.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ultrabook on 07.04.2015.
 */
public class Container implements Serializable {

    private Long containerID;
    private String containerType;
    private double containerWeight;
    private double containerHeight;
    private double containerWidth;
    private Set cargos = new HashSet();

    public Set getCargos() {
        return cargos;
    }

    public void setCargos(Set cargos) {
        this.cargos = cargos;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public double getContainerWeight() {
        return containerWeight;
    }

    public void setContainerWeight(double containerWeight) {
        this.containerWeight = containerWeight;
    }

    public double getContainerHeight() {
        return containerHeight;
    }

    public void setContainerHeight(double containerHeight) {
        this.containerHeight = containerHeight;
    }

    public double getContainerWidth() {
        return containerWidth;
    }

    public void setContainerWidth(double containerWidth) {
        this.containerWidth = containerWidth;
    }

    public Long getContainerID() {
        return containerID;
    }

    public void setContainerID(Long containerID) {
        this.containerID = containerID;
    }

}
