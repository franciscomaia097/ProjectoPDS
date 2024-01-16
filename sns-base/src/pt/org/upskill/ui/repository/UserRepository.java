package pt.org.upskill.ui.repository;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.ui.auth.Email;
import pt.org.upskill.ui.auth.User;
import pt.org.upskill.ui.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Persistable {
    private static final List<User> users = new ArrayList<>();

    public boolean add(User user) {
        try {
            users.add(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User userByEmail(String address) throws Exception {
        for (User user : users) {
            if (user.email().address().equals(address)) {
                return user;
            };
        }
        return null;
    }

    public Employee createEmployee(Email email, String name) {
        return new Employee(email, name);
    }


    @Override
    public boolean save(Object object) {
        if (validateDelete(object)){
            users.add((User) object);
            return true;
        }
        return false;
    }

    public boolean delete(Object object){
        if (validateDelete(object)){
            users.remove(object);
            return true;
        }
        return false;
    }

    private Boolean validateDelete(Object object) {
        return true;
    }
    private Boolean validateSave(Object object) {
        return true;
    }


}
