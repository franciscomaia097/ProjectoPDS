package pt.org.upskill.repository;

import pt.org.upskill.db.ConnectionFactory;
import pt.org.upskill.db.DatabaseConnection;
import pt.org.upskill.db.VaccinationCenterDB;
import pt.org.upskill.domain.Address;
import pt.org.upskill.domain.VaccinationCenter;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.dto.VaccinationCenterDTO;
import pt.org.upskill.session.Context;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VaccinationCenterRepository implements PersistableRepo {

    private List<VaccinationCenter> vaccinationCenterList = new ArrayList<VaccinationCenter>();


    public VaccinationCenter getById(int id) {
        for (VaccinationCenter vaccinationCenter : vaccinationCenterList) {
            if (vaccinationCenter.id() == id) {
                return vaccinationCenter;
            };
        }
        return null;
    }

    public VaccinationCenter createVaccinationCenter(DTO dto) throws IllegalArgumentException {
        VaccinationCenterDTO vaccinationCenterDTO = (VaccinationCenterDTO) dto;
        return new VaccinationCenter.Builder()
                .withId(vaccinationCenterDTO.getId())
                .withName(vaccinationCenterDTO.getName())
                .withAddress(new Address(
                        vaccinationCenterDTO.addressDTO().streetName(),
                        vaccinationCenterDTO.addressDTO().postalCode(),
                        vaccinationCenterDTO.addressDTO().cityName()))
                .build();
    }


    @Override
    public boolean save(Object object) {
        ConnectionFactory connectionFactory = Context.getConnectionFactory();
        DatabaseConnection dbc = connectionFactory.getDatabaseConnection();
        Connection conn = dbc.getConnection();

        try {
            conn.setAutoCommit(false);
            //
            VaccinationCenterDB vaccinationCenterDB = new VaccinationCenterDB();
            vaccinationCenterDB.save(conn, (VaccinationCenter) object);
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
    public boolean delete(Object object) throws SQLException {
        ConnectionFactory cf = Context.getConnectionFactory();
        DatabaseConnection dbc = cf.getDatabaseConnection();
        Connection conn = dbc.getConnection();

        try {
            conn.setAutoCommit(false);
            //
            VaccinationCenterDB vaccinationCenterDB = new VaccinationCenterDB();
            vaccinationCenterDB.delete(conn, (VaccinationCenter) object);
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

    public List<KeyValueDTO> keyValueDTOList() {
        List<KeyValueDTO> keyValueDTOList = new ArrayList<>();
        for (VaccinationCenter vaccinationCenter : vaccinationCenterList) {
            keyValueDTOList.add(new KeyValueDTO(vaccinationCenter.id().toString(), vaccinationCenter.name()));
        }
        return keyValueDTOList;
    }
}
