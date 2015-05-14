package by.balan.command.factory;
import by.balan.command.ActionCommand;

/**
 * Created by Ultrabook on 05.05.2015.
 */
public enum CommandEnum {

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    REGISTRATION
            {
                {
                    this.command=new RegistrationCommand();
                }
            },
    CHOICE
            {
                {
                    this.command=new ChoiceCommand();
                }
            },
    BID
    {
        {
            this.command=new AddBidCommand();
        }
    },
    GETALL{
        {
            this.command=new AllBidCustomer();
        }
    };

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
