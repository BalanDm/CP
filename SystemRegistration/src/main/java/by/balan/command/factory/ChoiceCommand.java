package by.balan.command.factory;

import by.balan.command.ActionCommand;
import by.balan.command.ConfigurationManager;
import by.balan.controller.persistence.Factory;
import by.balan.model.entity.Bid;
import by.balan.model.entity.Cargo;
import by.balan.model.entity.Customer;
import by.balan.model.info.BidInfo;
import by.balan.model.info.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ultrabook on 12.05.2015.
 */
public class ChoiceCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
        String operName=null;
        String operSurname=null;
        String dateOp;
        ArrayList<BidInfo> custBids=null;
        List<Bid> bids=null;
        Bid tmpBid;
        BidInfo tmpBidInfo;
        if (request.getParameter("add")!=null) {
                page = ConfigurationManager.getProperty("path.page.bid");
        }else if(request.getParameter("view")!=null) {
            custBids=new ArrayList<BidInfo>();
            Customer customer;
            Cargo cargo=null;
            try {
                customer = Factory.getInstance().getCustomerDAO().getEqualsCustomer(UserInfo.uesrEmail);
                bids = Factory.getInstance().getBidDAO().getAllUserBid(customer.getIdCustomer());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < bids.size(); i++) {
                tmpBid = bids.get(i);
                try {
                    cargo=Factory.getInstance().getCargoDAO().getCargo(tmpBid.getCargo().getIdCargo());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(tmpBid.getOperator()==null)
                {
                    operName="";
                    operSurname="";
                }else
                {
                    operName=tmpBid.getOperator().getName();
                    operSurname=tmpBid.getOperator().getLastName();
                }
                if(tmpBid.getDateOp()==null)
                    dateOp="";
                else dateOp=tmpBid.getDateOp();
                tmpBidInfo=new BidInfo(tmpBid.getIdBid(),dateOp, operName, operSurname, cargo.getShip().getIdShip(), cargo.getNumber(), tmpBid.getOperation(),cargo.getDanger(), cargo.getContainer().getIdContainer());
                custBids.add(tmpBidInfo);
            }
            request.setAttribute("customers", custBids);
            page = ConfigurationManager.getProperty("path.page.custBids");
        }
        return page;
    }
}
