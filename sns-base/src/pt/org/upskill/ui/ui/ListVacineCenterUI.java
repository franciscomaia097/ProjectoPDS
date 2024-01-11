package pt.org.upskill.ui.ui;

import pt.org.upskill.ui.controller.VaccinationCenterController;
import pt.org.upskill.ui.domain.VacinationCenter;

import java.util.List;

public class ListVacineCenterUI extends UI {

    private final VaccinationCenterController vaccinationCenterController = new VaccinationCenterController();

    public void run() {
        System.out.println("Vaccination center list:");

        try {
            List<VacinationCenter> vacinationCenterList = vaccinationCenterController.getVacineCenterList();

            if (vacinationCenterList.isEmpty()) {
                System.out.println("No vaccination centers available.");
            } else {
                for (VacinationCenter center : vacinationCenterList) {
                    System.out.println("Vaccination Center Name: " + center.getAdress());
                    System.out.println("Pandemic Name: " + center.getPandemicName());
                    System.out.println("---------------------------");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for detailed error information.
        }
    }
}
