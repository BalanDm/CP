package by.balan.command;



import javax.servlet.http.HttpServletRequest;
public class EmptyCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.error");
        return page;
    }
}