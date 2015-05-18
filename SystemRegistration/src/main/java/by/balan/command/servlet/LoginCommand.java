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

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "mail";
    private static final String PARAM_NAME_PASSWORD = "pass";
    private static final String PARAM_ADMIN = "@admin.site";


    public String execute(HttpServletRequest request) {
        String page = null;
        String adminLogin=null;
        Customer custLog=new Customer();
        Operator operLog=new Operator();
        String dateOp;
        ArrayList<BidInfoAdmin> adminBids=null;
        List<Bid> bids=null;
        Bid tmpBid;
        BidInfoAdmin tmpBidInfo;
        UserInfo user=new UserInfo();
        adminBids=new ArrayList<BidInfoAdmin>();
        if(request.getParameter("reg")!=null)
        {
            page = ConfigurationManager.getProperty("path.page.registration");
        }
        else if(request.getParameter("log")!=null) {
            if (request.getParameter(PARAM_NAME_LOGIN).indexOf(PARAM_ADMIN) != -1) {
                adminLogin=request.getParameter(PARAM_NAME_LOGIN);
                adminLogin=adminLogin.replaceAll(PARAM_ADMIN, "");
                operLog.setLogin(adminLogin);
                operLog.setPassword(request.getParameter(PARAM_NAME_PASSWORD));
                try {
                    if(Factory.getInstance().getOperatorDAO().searchOperEquals(operLog))
                    {
                        user.setAdmin(operLog.getIdOperator());
                        user.setAdminName(operLog.getName());
                        user.setAdminSurname(operLog.getLastName());
                        user.setUser("");
                        request.getSession().setAttribute("user", user);
                        user=(UserInfo)request.getSession(true).getAttribute("user");
                        request.setAttribute("nameAdmin",user.getAdminSurname());
                        try {
                            bids = Factory.getInstance().getBidDAO().getAllBidByAdmin();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < bids.size(); i++) {
                            tmpBid = bids.get(i);
                            if(tmpBid.getDateOp()==null)
                                dateOp="";
                            else dateOp=tmpBid.getDateOp();
                            tmpBidInfo=new BidInfoAdmin(tmpBid.getIdBid(),tmpBid.getCustomer().getNameOrganization(),
                                    tmpBid.getCustomer().getPhone(),tmpBid.getCustomer().getMail(),tmpBid.getCargo().getShip().getIdShip(),
                                    tmpBid.getCargo().getShip().getName(),tmpBid.getCargo().getNumber(),tmpBid.getOperation(),dateOp);
                            adminBids.add(tmpBidInfo);
                        }
                        request.setAttribute("allBids", adminBids);
                        page=ConfigurationManager.getProperty("path.page.adminBids");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                custLog.setMail(request.getParameter(PARAM_NAME_LOGIN));
                custLog.setPassword(request.getParameter(PARAM_NAME_PASSWORD));
                try {
                    if (Factory.getInstance().getCustomerDAO().searchEqualsCustomer(custLog)) {
                        user.setUser(custLog.getMail());
                        user.setUserId(custLog.getIdCustomer());
                        user.setAdminName("");
                        user.setAdminSurname("");
                        request.getSession().setAttribute("user",user);
                        user=(UserInfo)request.getSession(true).getAttribute("user");
                        request.setAttribute("nameClient",user.getUser());
                        page = ConfigurationManager.getProperty("path.page.choice");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return page;
    }
}
