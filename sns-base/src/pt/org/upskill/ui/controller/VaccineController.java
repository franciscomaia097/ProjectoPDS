package pt.org.upskill.ui.controller;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.ui.domain.Brand;
import pt.org.upskill.ui.domain.Vaccine;
import pt.org.upskill.ui.domain.VaccineType;
import pt.org.upskill.ui.repository.BrandRepository;
import pt.org.upskill.ui.repository.Repositories;
import pt.org.upskill.ui.repository.VaccineRepository;
import pt.org.upskill.ui.repository.VaccineTypeRepository;

public class VaccineController {
    VaccineRepository vaccineRepository = Repositories.getInstance().vaccineRepository();
    VaccineTypeRepository vaccineTypeRepository = Repositories.getInstance().vaccineTypeRepository();
    BrandRepository brandRepository = Repositories.getInstance().brandRepository();

    private Vaccine vaccine;

    public void createVaccine(String vaccineTypeCode, String brandName, String vaccineName) {
        VaccineType vaccineType = vaccineTypeRepository.getByCode(vaccineTypeCode);
        Brand band = brandRepository.getByName(brandName);
        vaccine = vaccineRepository.createVaccine(vaccineName, vaccineType, band);
    }
/*
    public List<VaccineTech> vaccineTechList() {
        return vaccineTechRepository.vaccineTechList();
    }

    public String getVaccineTechName(int id) {
        return vaccineTechRepository.getById(id).name();
    }
*/
    public boolean confirm() {
        vaccineRepository.save(vaccine);
        return true;
    }


}
