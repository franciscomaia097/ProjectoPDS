package pt.org.upskill.ui.ui.menu;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.ui.domain.Role;

public class Permission {
    Role role;

    public Permission(Role role) {
        this.role = role;
    }

    public Role role() {
        return this.role;
    }
}
