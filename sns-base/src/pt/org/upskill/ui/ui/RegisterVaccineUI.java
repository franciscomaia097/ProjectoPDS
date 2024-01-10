package pt.org.upskill.ui.ui;

import pt.org.upskill.ui.controller.VaccineController;
import pt.org.upskill.ui.controller.VaccineTypeController;
import pt.org.upskill.ui.controller.BrandController;
import pt.org.upskill.ui.domain.Brand;
import pt.org.upskill.ui.domain.VaccineType;
import pt.org.upskill.ui.ui.utils.Utils;

import java.util.List;

public class RegisterVaccineUI extends UI {

    private final VaccineController vaccineController = new VaccineController();
    private final VaccineTypeController vaccineTypeController = new VaccineTypeController();
    private final BrandController brandController = new BrandController();

    public void run() {
        System.out.println("");
        System.out.println("CREATE VACCINE");
        System.out.println("-----------");

        try {
            List<VaccineType> vaccineTypeList = vaccineTypeController.vaccineTypeList();
            System.out.println("Vaccine Types");
            for (VaccineType vaccineType : vaccineTypeList) {
                System.out.println(vaccineType.code() + " - " + vaccineType.shortDescription());
            }
            String vaccineTypeCode = Utils.readLineFromConsole("Select a vaccine type: ");

            List<Brand> brandList = brandController.brandList();
            System.out.println("Brands");
            for (Brand brand : brandList) {
                System.out.println(brand.name());
            }
            String brandName = Utils.readLineFromConsole("Select a brand: ");

            String vaccineName = Utils.readLineFromConsole("Vaccine Name: ");

            //Set data
            vaccineController.createVaccine(vaccineTypeCode, brandName, vaccineName);

            //Confirm
            vaccineController.confirm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
