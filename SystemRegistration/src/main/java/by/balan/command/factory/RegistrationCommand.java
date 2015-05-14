package by.balan.command.factory;

import by.balan.command.ActionCommand;
import by.balan.command.ConfigurationManager;
import by.balan.controller.persistence.Factory;
import by.balan.model.entity.Customer;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Ultrabook on 06.05.2015.
 */
public class RegistrationCommand implements ActionCommand {
    private static final String PARAM_NAME_ORGANIZATION = "organization";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_PHONE = "phone";
    public String execute(HttpServletRequest request) {
        String page = null;
        String org = request.getParameter(PARAM_NAME_ORGANIZATION);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String email = request.getParameter(PARAM_NAME_EMAIL);
        String phone = request.getParameter(PARAM_NAME_PHONE);
        if (request.getParameter("save")!=null) {
            Customer newCustomer = new Customer();
            newCustomer.setNameOrganization(org);
            newCustomer.setPassword(pass);
            newCustomer.setMail(email);
            newCustomer.setPhone(Integer.parseInt(phone));
            request.setAttribute("setOrganization","");
            request.setAttribute("setPhone","");
            request.setAttribute("setEmail","");
            try {
                Factory.getInstance().getCustomerDAO().addCustomer(newCustomer);
                page = ConfigurationManager.getProperty("path.page.login");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return page;
    }
}
