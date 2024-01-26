package pt.org.upskill.db;

import pt.org.upskill.domain.VaccinationCenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VaccinationCenterDB implements PersistableObject<VaccinationCenter> {

    @Override
    public boolean save(Connection connection, VaccinationCenter object) {
        String sqlCmd = "select * from VaccinationCenter where id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
            ps.setInt(1, object.id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sqlCmd = "update VaccinationCenter set name = ?, address = ? where id = ?";
                } else {
                    sqlCmd = "insert into VaccinationCenter(name, address, id) values (?, ?, ?)";
                }

                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
                    ps2.setString(1, object.name());
                    ps2.setString(2, object.address().toString());
                    ps2.setInt(3, object.id());
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
    public boolean delete(Connection connection, VaccinationCenter object) {
        try {
            String sqlCmd = "delete from VaccinationCenter where id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, object.id());
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();  // Log or handle the exception appropriately
            return false;
        }
    }

    @Override
    public VaccinationCenter getById(Connection connection, int id) {
        return null;
    }
}
