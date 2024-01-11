package pt.org.upskill.ui.ui;

import pt.org.upskill.ui.controller.VaccineController;
import pt.org.upskill.ui.domain.Vaccine;

import java.util.List;

public class ListVaccinesUI extends UI {
    private final VaccineController vaccineController = new VaccineController();


    public void run(){
        System.out.println("Vaccine list:");
        try {
            List<Vaccine> vaccineList = vaccineController.getVaccineList();

            if (vaccineList.isEmpty()){
                System.out.println("No vaccines available.");
            } else {
                for (Vaccine vaccine : vaccineList){
                    System.out.println("--------------");
                    System.out.println("Vaccine name:" + vaccine.getName());
                    System.out.println("Vaccine brand:" + vaccine.getBrand());
                    System.out.println("Vaccine type:" + vaccine.getVaccineType());
                }
            }
        } catch (Exception e){
            System.out.println("Error:" + e.getMessage());
            e.printStackTrace();
        }
    }


}
