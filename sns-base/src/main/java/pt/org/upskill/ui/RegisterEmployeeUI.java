package pt.org.upskill.ui;

import pt.org.upskill.auth.Email;
import pt.org.upskill.controller.EmployeeController;
import pt.org.upskill.dto.EmployeeDTO;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class RegisterEmployeeUI extends UI {

    private final EmployeeController employeeController = new EmployeeController();

    public void run() {
        System.out.println("");
        System.out.println("REGISTER EMPLOYEE");
        System.out.println("-----------------");

        try {
            String name = readLineFromConsole("Employee Name: ");
            String position = readLineFromConsole("Employee Position: ");
            String phone = readLineFromConsole("Employee Phone: ");
            String emailString = readLineFromConsole("Email: ");
            int id = Integer.parseInt(readLineFromConsole("Employee ID: "));

            // Convert the string email to Email object
            Email email = new Email(emailString);

            //DTO
            EmployeeDTO dto = new EmployeeDTO.Builder()
                    .withName(name)
                    .withPosition(position)
                    .withEmailDTO(email.toDTO())
                    .withId(id)
                    .withPhone(phone)
                    .build();

            // Registration
            employeeController.register(dto);

            // Confirmation
            employeeController.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}