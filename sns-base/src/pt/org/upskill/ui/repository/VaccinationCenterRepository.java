package pt.org.upskill.ui.repository;

import pt.org.upskill.ui.domain.VacinationCenter;

import java.util.ArrayList;
import java.util.List;

public class VaccinationCenterRepository implements Persistable {
    public VaccinationCenterRepository() {
    }

    private List<VacinationCenter> vacinationCenterList = new ArrayList<>();

    public VacinationCenter createVacinationCenter(String address, String pandemicName) {
        return new VacinationCenter(address, pandemicName);
    }

    public List<VacinationCenter> getVacineCenterList() {
        return new ArrayList<>(vacinationCenterList);
    }

    @Override
    public boolean save(Object object) {
        if (validateSave(object)) {
            vacinationCenterList.add((VacinationCenter) object);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Object object) {

        if (validateDelete(object)) {
            vacinationCenterList.remove(object);
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
