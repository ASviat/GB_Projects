import exceptions.HumanException;

import java.time.LocalDate;
import java.time.Period;

public class Employee extends Human {


    private Employee(String name, String dateOfBirth, String phone, Gender gender) {
        super(name, dateOfBirth, phone, gender);

    }

    static Employee createEmployee(String name, String dateOfBirth, String phone, String gender)
            throws HumanException {

        int age;
        LocalDate ld = LocalDate.parse(dateOfBirth);
        age = Period.between(ld, LocalDate.now()).getYears();

        if (age < 18) throw new HumanException("Incorrect age:" + age + ".\nMust be 18+");
        if (!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f")) {
            throw new HumanException("Wrong gender entered:" + gender);
        }
        if (gender.equalsIgnoreCase("m")) {
            Gender male = Gender.Male;
            return new Employee(name, dateOfBirth, phone, male);
        }
        if (gender.equalsIgnoreCase("f")) {
            Gender female = Gender.Female;
            return new Employee(name, dateOfBirth, phone, female);
        }
        return createEmployee(name, dateOfBirth, phone, gender);
    }

}
