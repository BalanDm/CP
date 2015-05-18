package by.balan.model.info;

/**
 * Created by Ultrabook on 15.05.2015.
 */
public class BidInfoAdmin {
    private Long numBid;
    private String nameOrganization;
    private int phone;
    private String email;
    private String numShip;

    public BidInfoAdmin(Long numBid, String nameOrganization,
                        String numShip, String numCargo, String typeOp,
                        boolean danger, String numContainer, String typeContainer) {
        this.numBid = numBid;
        this.nameOrganization = nameOrganization;
        this.numShip = numShip;
        this.numCargo = numCargo;
        this.typeOp = typeOp;
        this.danger = danger;
        this.numContainer = numContainer;
        this.typeContainer = typeContainer;
    }

    private String nameShip;
    private String numCargo;
    private String typeOp;
    private String dateOp;
    private boolean danger;
    private String numContainer;
    private String typeContainer;

    public BidInfoAdmin(Long numBid, String nameOrganization, int phone,
                        String email, String numShip, String nameShip,
                        String numCargo, String typeOp, String dateOp) {
        this.numBid = numBid;
        this.nameOrganization = nameOrganization;
        this.phone = phone;
        this.email = email;
        this.numShip = numShip;
        this.nameShip = nameShip;
        this.numCargo = numCargo;
        this.typeOp = typeOp;
        this.dateOp = dateOp;
    }
    public String getTypeContainer() {
        return typeContainer;
    }

    public void setTypeContainer(String typeContainer) {
        this.typeContainer = typeContainer;
    }

    public String getNumContainer() {
        return numContainer;
    }

    public void setNumContainer(String numContainer) {
        this.numContainer = numContainer;
    }
    public boolean isDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }

    public Long getNumBid() {
        return numBid;
    }

    public void setNumBid(Long numBid) {
        this.numBid = numBid;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumShip() {
        return numShip;
    }

    public void setNumShip(String numShip) {
        this.numShip = numShip;
    }

    public String getNameShip() {
        return nameShip;
    }

    public void setNameShip(String nameShip) {
        this.nameShip = nameShip;
    }

    public String getNumCargo() {
        return numCargo;
    }

    public void setNumCargo(String numCargo) {
        this.numCargo = numCargo;
    }


    public String getTypeOp() {
        return typeOp;
    }

    public void setTypeOp(String typeOp) {
        this.typeOp = typeOp;
    }

    public String getDateOp() {
        return dateOp;
    }

    public void setDateOp(String dateOp) {
        this.dateOp = dateOp;
    }
}
