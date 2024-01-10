package pt.org.upskill.ui.repository;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

public interface Persistable {
    boolean save(Object object);
    boolean delete(Object object);
}
