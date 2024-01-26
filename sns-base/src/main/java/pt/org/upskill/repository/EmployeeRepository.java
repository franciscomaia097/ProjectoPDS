package pt.org.upskill.repository;

import pt.org.upskill.auth.Email;
import pt.org.upskill.db.ConnectionFactory;
import pt.org.upskill.db.DatabaseConnection;
import pt.org.upskill.db.EmployeeDB;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.EmployeeDTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.session.Context;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements PersistableRepo {

    public EmployeeRepository() {}

    private List<Employee> employeeList = new ArrayList<>();

    public int nextId() {
        int maxId = 0;
        for (Employee employee : employeeList) {
            if (employee.getId() > maxId) {
                maxId = employee.getId();
            }
        }
        return maxId + 1;
    }

    public Employee getById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    private Boolean validateSave(Employee employee) {
        return true;
    }

    private Boolean validateDelete(Employee employee) {
        return true;
    }

    public Employee createEmployee(DTO dto) throws Exception {
        EmployeeDTO employeeDTO = (EmployeeDTO) dto;
        return new Employee.Builder()
                .withId(employeeDTO.getId())
                .withEmail(new Email(employeeDTO.getEmailDTO().address()))
                .withName(employeeDTO.getName())
                .withPosition(employeeDTO.getPosition())
                .withPhone(employeeDTO.getPhone())
                .build();
    }

    @Override
    public boolean save(Object object) {
        ConnectionFactory cf = Context.getConnectionFactory();
        DatabaseConnection dbc = cf.getDatabaseConnection();
        Connection conn = dbc.getConnection();
        //
        try {
            conn.setAutoCommit(false);
            //
            EmployeeDB employeeDB = new EmployeeDB();
            employeeDB.save(conn, (Employee) object);
            //
            conn.commit();
            return true;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public boolean delete(Object object) {
        ConnectionFactory cf = Context.getConnectionFactory();
        DatabaseConnection dbc = cf.getDatabaseConnection();
        Connection conn = dbc.getConnection();
        //
        try {
            conn.setAutoCommit(false);
            //
            EmployeeDB employeeDB = new EmployeeDB();
            employeeDB.delete(conn, (Employee) object);
            //
            conn.commit();
            return true;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    public List<Employee> employeeList() {
        return employeeList;
    }

    public List<KeyValueDTO> keyValueDTOList() {
        List<KeyValueDTO> dtoList = new ArrayList<>();
        for (Employee item : employeeList()) {
            EmployeeDTO dto = item.toDTO();
            dtoList.add(new KeyValueDTO(dto.getId().toString(), dto.getName()));
        }
        return dtoList;
    }
}
