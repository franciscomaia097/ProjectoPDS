package pt.org.upskill.ui.ui;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.ui.controller.VaccineTechController;
import pt.org.upskill.ui.ui.utils.Utils;

public class RegisterVaccineTechUI extends UI {
    private final VaccineTechController vaccineTechController = new VaccineTechController();

    public void run() {
        System.out.println("");
        System.out.println("CREATE VACCINE TECHNOLOGY");
        System.out.println("-----------");

        try {
            String name = Utils.readLineFromConsole("Vaccine Technology Name: ");
            String description = Utils.readLineFromConsole("Vaccine Technology Description: ");

            //Set data
            vaccineTechController.createVaccineTech(name, description);

            //Confirm
            vaccineTechController.confirm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
