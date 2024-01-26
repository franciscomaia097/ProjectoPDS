package pt.org.upskill.db;

import pt.org.upskill.auth.Email;
import pt.org.upskill.domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDB implements PersistableObject<Employee> {

    @Override
    public boolean save(Connection connection, Employee object) {
        String sqlCmd = "select * from Employee where id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
            ps.setInt(1, object.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sqlCmd = "update Employee set email = ?, name = ?, position = ?, phone = ? where id = ?";
                } else {
                    sqlCmd = "insert into Employee(id, email, name, position, phone) values (?, ?, ?, ?, ?)";
                }

                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
                    ps2.setInt(1, object.getId());
                    ps2.setString(2, object.getEmail().address());
                    ps2.setString(3, object.getName());
                    ps2.setString(4, object.getPosition());
                    ps2.setString(5, object.getPhone());
                    ps2.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();  // Log or handle the exception appropriately
            return false;
        }
    }

    @Override
    public boolean delete(Connection connection, Employee object) {
        try {
            String sqlCmd = "delete from Employee where id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, object.getId());
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();  // Log or handle the exception appropriately
            return false;
        }
    }

    @Override
    public Employee getById(Connection connection, int id) {
        try {
            String sqlCmd = "select * from Employee where id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // Assuming you have appropriate constructor in Employee class
                        return new Employee(
                                rs.getInt("id"),
                                new Email(rs.getString("email")),
                                rs.getString("name")
                        );
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();  // Log or handle the exception appropriately
        }
        return null;
    }
}
