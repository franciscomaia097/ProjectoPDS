package pt.org.upskill.ui.repository;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.ui.auth.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
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
}
