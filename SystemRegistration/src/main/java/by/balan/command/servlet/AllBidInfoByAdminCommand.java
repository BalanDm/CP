package by.balan.command.servlet;

import by.balan.command.ActionCommand;
import by.balan.command.manager.ConfigurationManager;
import by.balan.controller.persistence.Factory;
import by.balan.model.entity.Bid;
import by.balan.model.info.BidInfoAdmin;
import by.balan.model.info.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ultrabook on 16.05.2015.
 */
public class AllBidInfoByAdminCommand implements ActionCommand {
    public void  updateJSP(HttpServletRequest request,List<Bid> bidsSerach)
    {
        List<Bid> bids=null;
        Bid tmpBid;
        BidInfoAdmin tmpBidInfo;
        List<BidInfoAdmin> adminBids=new ArrayList<BidInfoAdmin>();
        try {
            if(bidsSerach==null) {
                bids = Factory.getInstance().getBidDAO().getAllBidByAdmin();
            }else bids=bidsSerach;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(bids!=null) {
            for (int i = 0; i < bids.size(); i++) {
                tmpBid = bids.get(i);
                tmpBidInfo = new BidInfoAdmin(tmpBid.getIdBid(), tmpBid.getCustomer().getNameOrganization(), tmpBid.getCargo().getShip().getIdShip(),
                        tmpBid.getCargo().getNumber(), tmpBid.getOperation(), tmpBid.getCargo().getDanger(), tmpBid.getCargo().getContainer().getIdContainer(),
                        tmpBid.getCargo().getContainer().getType());
                adminBids.add(tmpBidInfo);
            }
            request.setAttribute("allBids", adminBids);
        }
    }

    public String execute(HttpServletRequest request) {
        String page=null;
        OverallFun ovFun=new OverallFun();
        List<Bid> bidsList;
        UserInfo user;
        user=(UserInfo)request.getSession(true).getAttribute("user");
        request.setAttribute("nameAdmin",user.getAdminSurname());
        if(request.getParameter("exit")!=null)
        {
            request.getSession(true).invalidate();
            return page = ConfigurationManager.getProperty("path.page.index");
        }
        if(request.getParameter("back")!=null)
        {
            AllBidByAdminCommand bids=new AllBidByAdminCommand();
            bids.updateJSP(request,null);
            page = ConfigurationManager.getProperty("path.page.adminBids");
        }else
        if(request.getParameter("search")!=null)
        {
            bidsList = ovFun.SearchAdmin(request);
            updateJSP(request,bidsList);
            page = ConfigurationManager.getProperty("path.page.adminBidsInfo");
        }
        return page;
    }
}
