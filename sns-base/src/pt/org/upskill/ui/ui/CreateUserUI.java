package pt.org.upskill.ui.ui;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.ui.controller.RoleController;
import pt.org.upskill.ui.controller.UserController;

import static pt.org.upskill.ui.ui.utils.Utils.readLineFromConsole;

public class CreateUserUI extends UI {
    //Controller
    private final UserController userController = new UserController();
    private final RoleController roleController = new RoleController();

    public void run() {
        System.out.println("");
        System.out.println("CREATE USER");
        System.out.println("-----------");

        try {
            //Requests data
            String email = readLineFromConsole("Email: ");
            String password = readLineFromConsole("Password: ");

            //TODO: Your code here
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
