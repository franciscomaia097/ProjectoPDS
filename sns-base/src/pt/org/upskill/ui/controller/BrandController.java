package pt.org.upskill.ui.controller;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.ui.domain.Brand;
import pt.org.upskill.ui.repository.Repositories;
import pt.org.upskill.ui.repository.BrandRepository;

import java.util.List;

public class BrandController {
    BrandRepository brandRepository = Repositories.getInstance().brandRepository();

    public List<Brand> brandList() {
        return brandRepository.brandList();
    }

    /*
    private VaccineTech vaccineTech;

    public void createVaccineTech(String name, String description) {
        vaccineTech = vaccineTechRepository.createVaccineTech(name, description);
    }

    public List<VaccineTech> vaccineTechList() {
        return vaccineTechRepository.vaccineTechList();
    }

    public String getVaccineTechName(int id) {
        return vaccineTechRepository.getById(id).name();
    }

    public boolean confirm() {
        vaccineTechRepository.save(vaccineTech);
        return true;
    }

 */
}
