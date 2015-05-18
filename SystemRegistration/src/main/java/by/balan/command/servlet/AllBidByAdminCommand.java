package by.balan.command.servlet;

import by.balan.command.ActionCommand;
import by.balan.command.manager.ConfigurationManager;
import by.balan.controller.persistence.Factory;
import by.balan.model.entity.Bid;
import by.balan.model.entity.Cargo;
import by.balan.model.entity.Customer;
import by.balan.model.entity.Operator;
import by.balan.model.info.BidInfo;
import by.balan.model.info.BidInfoAdmin;
import by.balan.model.info.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ultrabook on 15.05.2015.
 */
public class AllBidByAdminCommand implements ActionCommand {
    public void updateJSP(HttpServletRequest request,List<Bid> bidList)
    {
        Operator operLog=new Operator();
        String dateOp;
        ArrayList<BidInfoAdmin> adminBids=null;
        List<Bid> bids=null;
        Bid tmpBid;
        BidInfoAdmin tmpBidInfo;
        adminBids=new ArrayList<BidInfoAdmin>();
                if(bidList==null) {
                    try {
                        bids = Factory.getInstance().getBidDAO().getAllBidByAdmin();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else bids=bidList;
                if(bids !=null) {
                    for (int i = 0; i < bids.size(); i++) {
                        tmpBid = bids.get(i);
                        if (tmpBid.getDateOp() == null)
                            dateOp = "";
                        else dateOp = tmpBid.getDateOp();
                        tmpBidInfo = new BidInfoAdmin(tmpBid.getIdBid(), tmpBid.getCustomer().getNameOrganization(),
                                tmpBid.getCustomer().getPhone(), tmpBid.getCustomer().getMail(), tmpBid.getCargo().getShip().getIdShip(),
                                tmpBid.getCargo().getShip().getName(), tmpBid.getCargo().getNumber(), tmpBid.getOperation(), dateOp);
                        adminBids.add(tmpBidInfo);
                    }
                    request.setAttribute("allBids", adminBids);
                }
            }

    public String execute(HttpServletRequest request) {
        String page=null;
        List<Bid> bids=null;
        UserInfo user=null;
        Operator oper=new Operator();
        OverallFun ovFun=new OverallFun();
        List<Bid> bidsList;
        AllBidInfoByAdminCommand info=new AllBidInfoByAdminCommand();
        user=(UserInfo)request.getSession(true).getAttribute("user");
        request.setAttribute("nameAdmin",user.getAdminSurname());
        if(request.getParameter("exit")!=null)
        {
            request.getSession(true).invalidate();
            return page = ConfigurationManager.getProperty("path.page.index");
        }
        if(request.getParameter("close") != null)
        {
            updateJSP(request, null);
            page = ConfigurationManager.getProperty("path.page.adminBids");
        }
        else if(request.getParameter("goodBid")!=null)
        {
            String date=request.getParameter("day")+"."+request.getParameter("month")+"."+request.getParameter("year");
            try {
                user=(UserInfo)request.getSession(true).getAttribute("user");
                String numBid = (String)request.getSession(true).getAttribute("bidNum");
                oper.setName(user.getAdminName());
                oper.setLastName(user.getAdminSurname());
                oper.setIdOperator(user.getAdmin());
                Factory.getInstance().getBidDAO().updateDateBid(date,Long.parseLong(numBid),"approved",oper);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            page = ConfigurationManager.getProperty("path.page.adminBids");
        }
        else if(request.getParameter("searchOk")!=null)
        {
            bidsList = ovFun.SearchAdmin(request);
            updateJSP(request, bidsList);
            page = ConfigurationManager.getProperty("path.page.adminBids");
        }else if(request.getParameter("refresh") != null)
        {
            updateJSP(request, null);
            page = ConfigurationManager.getProperty("path.page.adminBids");
        }
        else if(request.getParameter("idUpdate") != null && request.getParameter("idUpdate") != "") {
            request.setAttribute("bidOk",request.getParameter("idUpdate"));
            request.getSession(true).setAttribute("bidNum", request.getParameter("idUpdate"));
            updateJSP(request, null);
            page = ConfigurationManager.getProperty("path.page.adminBids");
        }else
        if(request.getParameter("info")!=null)
        {
            try {
                bids = Factory.getInstance().getBidDAO().getAllBidByAdmin();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            info.updateJSP(request, bids);
            page = ConfigurationManager.getProperty("path.page.adminBidsInfo");
        }
        else if(request.getParameter("id") != null && request.getParameter("id") != "")
        {
            long idReject = Long.valueOf(request.getParameter("id"));
            try {
                Factory.getInstance().getOperatorDAO().searchOperEquals(oper);
                Factory.getInstance().getBidDAO().updateDateBid("--.--.----", idReject, "rejected", oper);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            updateJSP(request,null);
            return page = ConfigurationManager.getProperty("path.page.adminBids");
        }
        else if(request.getParameter("idDelete") != null && request.getParameter("idDelete") != ""){
            long idDel = Long.valueOf(request.getParameter("idDelete"));
            try {
                if (Factory.getInstance().getBidDAO().checkBidById(idDel)) {
                    Factory.getInstance().getBidDAO().delete(idDel);
                }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            updateJSP(request,null);
            page = ConfigurationManager.getProperty("path.page.adminBids");
        }
        return page;
    }
}
