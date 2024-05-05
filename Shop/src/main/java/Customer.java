import exceptions.HumanException;

import java.time.LocalDate;
import java.time.Period;

public class Customer extends Human {


    private Customer(String name, String dateOfBirth, String phone, Gender gender) {
        super(name, dateOfBirth, phone, gender);
    }

    static Customer createCustomer(String name, String dateOfBirth, String phone, String gender) throws HumanException {
        int age;
        LocalDate ld = LocalDate.parse(dateOfBirth);

        age = Period.between(ld, LocalDate.now()).getYears();

        if (age < 18) {
            throw new HumanException("Incorrect age:" + age + ".");
        }
        if (!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f")) {
            throw new HumanException("Wrong gender entered:" + gender);
        }
        if (gender.equalsIgnoreCase("m")) {
            Gender male = Gender.Male;
            return new Customer(name, dateOfBirth, phone, male);
        }
        if (gender.equalsIgnoreCase("f")) {
            Gender female = Gender.Female;
            return new Customer(name, dateOfBirth, phone, female);
        }
        return createCustomer(name, dateOfBirth, phone, gender);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phone='" + phone + '\'' +
                "} ";
    }
}