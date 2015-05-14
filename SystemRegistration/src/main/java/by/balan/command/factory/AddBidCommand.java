package by.balan.command.factory;

import by.balan.command.ActionCommand;
import by.balan.command.ConfigurationManager;
import by.balan.controller.persistence.Factory;
import by.balan.model.entity.Bid;
import by.balan.model.entity.Cargo;
import by.balan.model.entity.Container;
import by.balan.model.entity.Ship;
import by.balan.model.info.BidInfo;
import by.balan.model.info.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public class AddBidCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
        String oper=null;
        String danger=null;
        String type=null;
        BidInfo bid=new BidInfo();
        if (request.getParameter("reg")!=null) {
            bid.setNumShip(request.getParameter("shipNum"));
            bid.setNameShip(request.getParameter("shipName"));
            bid.setNumCargo(request.getParameter("cargoNum"));
            bid.setNameCargo(request.getParameter("cargoName"));
            oper=request.getParameter("typeOp");
            if("in".equals(oper))
                bid.setTypeOp("loading");
            else if("out".equals(oper))
                bid.setTypeOp("shipping");
            danger=request.getParameter("dangerCargo");
            if("danger".equals(danger))
                bid.setDanger(true);
            else bid.setDanger(false);
            bid.setNumContainer(request.getParameter("containerNum"));
            type=request.getParameter("containerType");
            if(type.equals("20DC"))
                bid.setTypeContainer("20DC");
            else if(type.equals("40DC"))
                bid.setTypeContainer("40DC");
            else if(type.equals("40HC"))
                bid.setTypeContainer("40HC");
            else if(type.equals("45HC"))
                bid.setTypeContainer("45HC");
            Ship newShip=new Ship();
            newShip.setIdShip(bid.getNumShip());
            newShip.setName(bid.getNameShip());
            Container newContainer=new Container();
            newContainer.setIdContainer(bid.getNumContainer());
            newContainer.setType(bid.getTypeContainer());
            newContainer.setHeight(1);
            newContainer.setWeight(2);
            newContainer.setWidth(3);
            Cargo newCargo=new Cargo();
            newCargo.setNumber(bid.getNumCargo());
            newCargo.setDanger(bid.isDanger());
            newCargo.setContainer(newContainer);
            newCargo.setShip(newShip);
            Bid newBid=new Bid();
            newBid.setCargo(newCargo);
            newBid.setOperation(bid.getTypeOp());
            try {
                newBid.setCustomer(Factory.getInstance().getCustomerDAO().getEqualsCustomer(UserInfo.uesrEmail));
                Factory.getInstance().getShipDAO().addShip(newShip);
                Factory.getInstance().getContainerDAO().addContainer(newContainer);
                Factory.getInstance().getCargoDAO().addCargo(newCargo);
                Factory.getInstance().getBidDAO().addBid(newBid);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            page = ConfigurationManager.getProperty("path.page.choice");
        }
        return page;
    }
}
