package pt.org.upskill.controller;

import pt.org.upskill.domain.Employee;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.repository.EmployeeRepository;
import pt.org.upskill.repository.Repositories;

import java.util.List;

public class EmployeeController implements UIable {
    private EmployeeRepository employeeRepository = Repositories.getInstance().employeeRepository();

    private Employee employee;

    @Override
    public void register(DTO dto) throws Exception {
        employee = employeeRepository.createEmployee(dto);
    }

    @Override
    public boolean save() {
        return employeeRepository.save(employee);
    }

    @Override
    public List<KeyValueDTO> keyValueDTOList() {
        return employeeRepository.keyValueDTOList();
    }
}
