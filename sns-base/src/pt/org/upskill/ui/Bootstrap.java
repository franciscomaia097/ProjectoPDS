package pt.org.upskill.ui;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.ui.auth.Email;
import pt.org.upskill.ui.auth.Password;
import pt.org.upskill.ui.auth.User;
import pt.org.upskill.ui.domain.Role;
import pt.org.upskill.ui.repository.Repositories;
import pt.org.upskill.ui.repository.RoleRepository;
import pt.org.upskill.ui.repository.UserRepository;
import pt.org.upskill.ui.session.Context;
import pt.org.upskill.ui.ui.*;
import pt.org.upskill.ui.ui.menu.Drawable;
import pt.org.upskill.ui.ui.menu.Menu;
import pt.org.upskill.ui.ui.menu.MenuDrawer;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addRoles();
        addUsers();
        addMenus();
    }

    private void addRoles() {
        //TODO: add application user roles here
        RoleRepository roleRepository = Repositories.getInstance().roleRepository();

        roleRepository.add(new Role(RoleRepository.ROLE_ADMIN));
        roleRepository.add(new Role(RoleRepository.ROLE_NURSE));
        roleRepository.add(new Role(RoleRepository.ROLE_RECEPTIONIST));
        roleRepository.add(new Role(RoleRepository.ROLE_SNSUSER));
    }

    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        UserRepository userRepository = Repositories.getInstance().userRepository();
        RoleRepository roleRepository = Repositories.getInstance().roleRepository();

        try {
            userRepository.add(new User("adm", roleRepository.roleByName(RoleRepository.ROLE_ADMIN), new Email("admin@upskill.pt"), new Password("admin")));
            userRepository.add(new User("nur", roleRepository.roleByName(RoleRepository.ROLE_NURSE), new Email("nurse@upskill.pt"), new Password("nurse")));
            userRepository.add(new User("rec", roleRepository.roleByName(RoleRepository.ROLE_RECEPTIONIST), new Email("receptionist@upskill.pt"), new Password("receptionist")));
            userRepository.add(new User("usr", roleRepository.roleByName(RoleRepository.ROLE_SNSUSER), new Email("snsuser@upskill.pt"), new Password("snsuser")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addMenus() {
        //This is where we define the menu structure and respective permissions.
        RoleRepository roleRepository = Repositories.getInstance().roleRepository();

        Menu menu;

        Drawable drawer = new MenuDrawer();
        Context.getInstance().setDrawer(drawer);

        Menu mainMenu = new Menu(null, 1,"Main Menu", null);
        Context.getInstance().setMainMenu(mainMenu);

        //Everyone
        Menu menuLogin = new Menu(Context.getInstance().mainMenu(), 1,"Login", new LoginUI());
        menu = new Menu(Context.getInstance().mainMenu(), 2,"Logout", new LogoutUI());
        menu = new Menu(Context.getInstance().mainMenu(), 9,"About", new AboutUI());

        //Admin
        // menu = new Menu(menuLogin, 1, "Register User", new CreateUserUI());
        //menu.addPermission((Role) roleRepository.roleByName(ROLE_ADMIN));
        menu = new Menu(menuLogin, 2, "Register Vaccine Technology", new RegisterVaccineTechUI());
        menu.addPermission((Role) roleRepository.roleByName(RoleRepository.ROLE_ADMIN));
        menu = new Menu(menuLogin, 3, "Register Vaccine Type", new RegisterVaccineTypeUI());
        menu.addPermission((Role) roleRepository.roleByName(RoleRepository.ROLE_ADMIN));
        menu = new Menu(menuLogin, 4, "Register Vaccine", new RegisterVaccineUI());
        menu.addPermission((Role) roleRepository.roleByName(RoleRepository.ROLE_ADMIN));
        menu = new Menu(menuLogin, 5, "Register Vaccination Center", new RegisterVaccinationCenterUI());
        //menu.addPermission((Role) roleRepository.roleByName(ROLE_ADMIN));
        //menu = new Menu(menuLogin, 11, "List Employees With Role", new ListEmployeesWithRoleUI());
        //menu.addPermission((Role) roleRepository.roleByName(ROLE_ADMIN));
        menu = new Menu(menuLogin, 12, "List Vaccine Technologies", new ListVaccineTechsUI());
        menu.addPermission((Role) roleRepository.roleByName(RoleRepository.ROLE_ADMIN));
        menu = new Menu(menuLogin, 13, "List Vaccine Types", new ListVaccineTypesUI());
        menu.addPermission((Role) roleRepository.roleByName(RoleRepository.ROLE_ADMIN));
        //menu = new Menu(menuLogin, 14, "List Vaccines", new ListVaccinesUI());
        //menu.addPermission((Role) roleRepository.roleByName(ROLE_ADMIN));

        //Receptionist
        menu = new Menu(menuLogin, 1, "Register SNS User", new RegisterUserUI());
        menu.addPermission((Role) roleRepository.roleByName(RoleRepository.ROLE_RECEPTIONIST));
        menu = new Menu(menuLogin, 2, "Schedule Vaccination", new ScheduleVaccinationOnBehalfOfUserUI());
        menu.addPermission((Role) roleRepository.roleByName(RoleRepository.ROLE_RECEPTIONIST));
        //menu = new Menu(menuLogin, 3, "Register SNS User Arrival", new RegisterUserArrivalUI());
        //menu.addPermission((Role) roleRepository.roleByName(ROLE_RECEPTIONIST));

        //SNS USer
        //menu = new Menu(menuLogin, 1, "Schedule Vaccination", new ScheduleVaccinationUI());
        //menu.addPermission((Role) roleRepository.roleByName(ROLE_RECEPTIONIST));

        //Nurse
        //menu = new Menu(menuLogin, 1, "List User Waiting", new ListUsersWaitingUI());
        //menu.addPermission((Role) roleRepository.roleByName(ROLE_NURSE));
    }
}