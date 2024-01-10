package pt.org.upskill.ui.controller;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.ui.domain.VaccineTech;
import pt.org.upskill.ui.domain.VaccineType;

import pt.org.upskill.ui.repository.Repositories;
import pt.org.upskill.ui.repository.VaccineTechRepository;
import pt.org.upskill.ui.repository.VaccineTypeRepository;

import java.util.List;

public class VaccineTypeController {
    VaccineTypeRepository vaccineTypeRepository = Repositories.getInstance().vaccineTypeRepository();
    private VaccineType vaccineType;

    public void createVaccineType(String code, String shortDescription, int vaccineTechId) {
        VaccineTechRepository vaccineTechRepository = Repositories.getInstance().vaccineTechRepository();
        VaccineTech vaccineTech = vaccineTechRepository.getById(vaccineTechId);

        this.vaccineType = vaccineTypeRepository.createVaccineType(code, shortDescription, vaccineTech);
    }

    public List<VaccineType> vaccineTypeList() {
        return vaccineTypeRepository.vaccineTypeList();
    }

    public boolean confirm() {
        vaccineTypeRepository.save(vaccineType);
        return true;
    }
}
