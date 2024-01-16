package pt.org.upskill.ui.controller;

import pt.org.upskill.ui.auth.Email;
import pt.org.upskill.ui.domain.Employee;
import pt.org.upskill.ui.repository.UserRepository;

public class UserController {
    UserRepository userRepository = new UserRepository();

    private Employee employee;

    public void createEmployee(Email email, String name){
        employee = userRepository.createEmployee(email, name);
    }

    public boolean confirm(){
        userRepository.save(employee);
        return true;
    }



}
