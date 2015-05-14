package by.balan.command.factory;




import by.balan.command.ActionCommand;
import by.balan.command.ConfigurationManager;
import by.balan.command.Logic.LoginLogic;
import by.balan.command.MessageManager;
import by.balan.controller.persistence.Factory;
import by.balan.model.entity.Customer;
import by.balan.model.info.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "mail";
    private static final String PARAM_NAME_PASSWORD = "pass";

    public String execute(HttpServletRequest request) {
        String page = null;
        Customer custLog=new Customer();
        if(request.getParameter("reg")!=null)
        {
            page = ConfigurationManager.getProperty("path.page.registration");
        }
        else if(request.getParameter("log")!=null){
            custLog.setMail(request.getParameter(PARAM_NAME_LOGIN));
            custLog.setPassword(request.getParameter(PARAM_NAME_PASSWORD));
            try {
                if(Factory.getInstance().getCustomerDAO().searchEqualsCustomer(custLog)){
                    UserInfo.uesrEmail=custLog.getMail();
                    page = ConfigurationManager.getProperty("path.page.choice");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return page;
    }
}
