package by.balan.command;



import by.balan.command.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
public class EmptyCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.error");
        return page;
    }
}
