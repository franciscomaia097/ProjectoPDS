package pt.org.upskill.ui.controller;

import pt.org.upskill.ui.domain.VacinationCenter;
import pt.org.upskill.ui.repository.Repositories;
import pt.org.upskill.ui.repository.VaccinationCenterRepository;

import java.util.List;

public class VaccinationCenterController {

    VaccinationCenterRepository vaccinationCenterRepository = Repositories.getInstance().vaccinationCenterRepository();

    private VacinationCenter vacinationCenter;

    public void createVaccinationCenter(String adress, String pandemicName){
        vacinationCenter = vaccinationCenterRepository.createVacinationCenter(adress, pandemicName);

    }

    public boolean confirm() {
        vaccinationCenterRepository.save(vacinationCenter);
        return true;
    }


    public List<VacinationCenter> getVacineCenterList() {
        return vaccinationCenterRepository.getVacineCenterList();
    }
}
