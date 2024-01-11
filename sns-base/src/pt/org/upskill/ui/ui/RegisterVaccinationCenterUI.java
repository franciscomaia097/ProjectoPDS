package pt.org.upskill.ui.ui;

import pt.org.upskill.ui.controller.VaccinationCenterController;
import pt.org.upskill.ui.ui.utils.Utils;

public class RegisterVaccinationCenterUI extends UI {

    private final VaccinationCenterController vaccinationCenterController = new VaccinationCenterController();


    public void run (){
        System.out.println("CREATE VACINATION CENTER");
        System.out.println("-----------");

        try {

            String adress = Utils.readLineFromConsole("Adress:");
            String pandemicName = Utils.readLineFromConsole("Pandemic name:");
            vaccinationCenterController.createVaccinationCenter(adress, pandemicName);
            vaccinationCenterController.confirm();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
