package pt.org.upskill.ui.ui;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.ui.controller.VaccineTechController;
import pt.org.upskill.ui.controller.VaccineTypeController;
import pt.org.upskill.ui.domain.VaccineTech;
import pt.org.upskill.ui.ui.utils.Utils;

import java.util.List;

public class RegisterVaccineTypeUI extends UI {
    private final VaccineTypeController vaccineTypeController = new VaccineTypeController();
    private final VaccineTechController vaccineTechController = new VaccineTechController();

    public void run() {
        System.out.println("");
        System.out.println("CREATE VACCINE TYPE");
        System.out.println("-----------");

        try {
            String code = Utils.readLineFromConsole("Vaccine Type Code: ");
            String shortDescription = Utils.readLineFromConsole("Vaccine Type Short Description: ");

            System.out.println("Vaccine Technologies");
            List<VaccineTech> vaccineTechList = vaccineTechController.vaccineTechList();
            for (VaccineTech vaccineTech : vaccineTechList) {
                System.out.println(vaccineTech.id() + " - " + vaccineTech.name());
            }
            int key = Utils.readIntegerFromConsole("Select a vaccine technology: ");

            //data
            vaccineTypeController.createVaccineType(code, shortDescription, key);

            //confirmation
            vaccineTypeController.confirm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
