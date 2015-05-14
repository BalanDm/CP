package by.balan.model.info;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public class BidInfo {

    private Long numBid;
    private String dateOp;
    private Long idOperator;
    private String nameOper;
    private String surnameOper;
    private String numShip;
    private String nameShip;
    private String nameCargo;
    private String numCargo;
    private String typeOp;
    private boolean danger;
    private String typeContainer;
    private String numContainer;

    public BidInfo(){}
    public BidInfo(Long numBid, String dateOp, String nameOper, String surnameOper,
                   String numShip, String numCargo, String typeOp, boolean danger,
                   String numContainer) {
        this.numBid = numBid;
        this.dateOp = dateOp;
        this.nameOper = nameOper;
        this.surnameOper = surnameOper;
        this.numShip = numShip;
        this.numCargo = numCargo;
        this.typeOp = typeOp;
        this.danger = danger;
        this.numContainer = numContainer;
    }

    public String getDateOp() {
        return dateOp;
    }

    public void setDateOp(String dateOp) {
        this.dateOp = dateOp;
    }

    public String getNameOper() {
        return nameOper;
    }

    public void setNameOper(String nameOper) {
        this.nameOper = nameOper;
    }

    public String getSurnameOper() {
        return surnameOper;
    }

    public void setSurnameOper(String surnameOper) {
        this.surnameOper = surnameOper;
    }


    public Long getNumBid() {
        return numBid;
    }

    public void setNumBid(Long numBid) {
        this.numBid = numBid;
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

    public String getNameCargo() {
        return nameCargo;
    }

    public void setNameCargo(String nameCargo) {
        this.nameCargo = nameCargo;
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

    public boolean isDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
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
    public Long getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(Long idOperator) {
        this.idOperator = idOperator;
    }
}
