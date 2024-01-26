package pt.org.upskill.ui;

import pt.org.upskill.controller.VaccinationCenterController;
import pt.org.upskill.domain.Address;
import pt.org.upskill.dto.AddressDTO;
import pt.org.upskill.dto.VaccinationCenterDTO;

import java.util.Objects;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class RegisterVaccinationCenterUI extends UI {

    private final VaccinationCenterController vaccinationCenterController = new VaccinationCenterController();

    public void run() {
        System.out.println("");
        System.out.println("REGISTER VACCINATION CENTER");
        System.out.println("---------------------------");

        try {
            int id = Integer.parseInt(readLineFromConsole("Id: "));

            String name = readLineFromConsole("Name: ");
            String streetName = readLineFromConsole("Rua: ");
            String zipCode = readLineFromConsole("ZipCode: ");
            String cityName = readLineFromConsole("City: ");


            AddressDTO addressDTO = new AddressDTO.Builder()
                    .withStreetName(streetName)
                    .withPostalCode(zipCode)
                    .withCityName(cityName)
                    .build();

            //DTO
            VaccinationCenterDTO vaccinationCenterDTO = new VaccinationCenterDTO.Builder()
                    .withId(id)
                    .withName(name)
                    .withAddressDTO(addressDTO)
                    .build();


            vaccinationCenterController.registerVaccinationCenter(vaccinationCenterDTO);
            vaccinationCenterController.save();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
