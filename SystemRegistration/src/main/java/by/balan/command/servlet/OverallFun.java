package by.balan.command.servlet;

import by.balan.controller.functions.LongFunctions;
import by.balan.controller.persistence.Factory;
import by.balan.model.entity.Bid;
import by.balan.model.info.BidInfo;
import by.balan.model.info.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ultrabook on 17.05.2015.
 */
public class OverallFun {
    private List<Bid> bids=null;
    private String type;
    private LongFunctions longFun=new LongFunctions();
    public List<Bid> Search(HttpServletRequest request)
    {
        UserInfo user=(UserInfo)request.getSession(true).getAttribute("user");
        type = request.getParameter("searchType");
        try {
            if (type.equals("bidNum") && longFun.checkStringToLong(request.getParameter("search")))
                bids = Factory.getInstance().getBidDAO().SearchByNumBid(Long.valueOf(request.getParameter("search")),user.getUserId() );
            else if (type.equals("shipNum"))
                bids = Factory.getInstance().getBidDAO().SearchByNumShip(request.getParameter("search"), user.getUserId());
            else if (type.equals("cargoNum") && longFun.checkStringToLong(request.getParameter("search")))
                bids = Factory.getInstance().getBidDAO().SearchByNumCargo(Long.valueOf(request.getParameter("search")), user.getUserId());
            else if (type.equals("numContainer"))
                bids = Factory.getInstance().getBidDAO().SearchByNumContainer(request.getParameter("search"),user.getUserId());
            else if (type.equals("dateOp"))
                bids = Factory.getInstance().getBidDAO().SearchByDateOp(request.getParameter("search"), user.getUserId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bids;
    }
    public List<Bid> SearchAdmin(HttpServletRequest request)
    {
        type = request.getParameter("searchType");
        try {
            if (type.equals("bidNum") && longFun.checkStringToLong(request.getParameter("search")))
                bids = Factory.getInstance().getBidDAO().SearchByNumBid(Long.valueOf(request.getParameter("search")),null);
            else if (type.equals("shipNum"))
                bids = Factory.getInstance().getBidDAO().SearchByNumShip(request.getParameter("search"), null);
            else if (type.equals("cargoNum") && longFun.checkStringToLong(request.getParameter("search")))
                bids = Factory.getInstance().getBidDAO().SearchByNumCargo(Long.valueOf(request.getParameter("search")), null);
            else if (type.equals("numContainer"))
                bids = Factory.getInstance().getBidDAO().SearchByNumContainer(request.getParameter("search"), null);
            else if (type.equals("dateOp"))
                bids = Factory.getInstance().getBidDAO().SearchByDateOp(request.getParameter("search"), null);
            else if (type.equals("client"))
                bids = Factory.getInstance().getBidDAO().SearchClients(request.getParameter("search"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bids;
    }
}
