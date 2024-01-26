package pt.org.upskill.controller;

import pt.org.upskill.domain.VaccinationCenter;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.dto.VaccinationCenterDTO;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.VaccinationCenterRepository;

import java.util.List;

public class VaccinationCenterController implements UIable {

    VaccinationCenterRepository vaccinationCenterRepository = Repositories.getInstance().vaccinationCenterRepository();

    VaccinationCenter vaccinationCenter;

    @Override
    public void register(DTO dto) {
        vaccinationCenter = vaccinationCenterRepository.createVaccinationCenter(dto);
    }

    @Override
    public boolean save() {
        return vaccinationCenterRepository.save(vaccinationCenter);
    }

    @Override
    public List<KeyValueDTO> keyValueDTOList() {
        return vaccinationCenterRepository.keyValueDTOList();
    }

    public void registerVaccinationCenter(VaccinationCenterDTO vaccinationCenterDTO) throws Exception {
        vaccinationCenter = vaccinationCenterRepository.createVaccinationCenter(vaccinationCenterDTO);
    }
}
