package by.balan.controller.servlets;

import by.balan.controller.functions.IntFunctions;
import by.balan.controller.functions.StrFuncions;
import by.balan.controller.persistence.Factory;
import by.balan.model.entity.Customer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Ultrabook on 20.04.2015.
 */

@WebServlet("/s")
public class AddCustomer extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ServletContext ctx = getServletContext();
        boolean saveDB=true;
        int phone = 0;
        String organization="";
        String password1="";
        String password2="";
        String email="";
        StrFuncions strFun=new StrFuncions();
        IntFunctions intFun=new IntFunctions();
        if (request.getParameter("save")!=null) {
            organization = request.getParameter("nameOrganization");
            organization=strFun.removeChar(organization,' ');
            if(organization.compareTo("")==0){
                request.setAttribute("err", "Заполните поле Organization!");
                saveDB=false;
            }
            password1 = request.getParameter("password1");
            password2 = request.getParameter("password2");
            email = request.getParameter("email");
            email=strFun.removeChar(email,' ');
            if(email.compareTo("")==0 && saveDB) {
                request.setAttribute("err", "Заполните поле email!");
                saveDB=false;
            }
        if(intFun.checkStringToInt(request.getParameter("phone")))
            phone = Integer.parseInt(request.getParameter("phone"));
        else {
            if( saveDB) {
                saveDB = false;
                request.setAttribute("err", "Введите корректное значение в поле phone!");
            }
        }
            if (password1.compareTo(password2)==0 && saveDB) {
                Customer newCustomer = new Customer();
                newCustomer.setNameOrganization(organization);
                newCustomer.setPassword(password1);
                newCustomer.setMail(email);
                newCustomer.setPhone(phone);
                ctx.setAttribute("costumer", newCustomer);
                request.setAttribute("setOrganization","");
                request.setAttribute("setPhone","");
                request.setAttribute("setEmail","");
                try {
                    if (Factory.getInstance().getCustomerDAO().searchEqualsCustomer(newCustomer))
                    {
                        request.setAttribute("err", "Пользователь с таким телефоном или email уже существует!");
                        saveDB=false;
                    }else{
                        request.setAttribute("isSave", "Регистрация прошла успешно!");
                        Factory.getInstance().getCustomerDAO().addCustomer(newCustomer);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("err", "Повторите пожалуйста регистрацию!");
                }
          } else{
                if(saveDB)
                    request.setAttribute("err", "Введенные пароли не совпадают!");
            }
        }
        if(!saveDB) {
            request.setAttribute("setOrganization", organization);
            if (phone == 0)
                request.setAttribute("setPhone", "");
            else request.setAttribute("setPhone", phone);
            request.setAttribute("setEmail", email);
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
