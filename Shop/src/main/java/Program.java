import exceptions.AmountException;
import exceptions.HumanException;
import exceptions.ProductException;
import java.time.LocalDateTime;

public class Program {

    private enum Holidays {
        NOT_A_HOLIDAY(""), NEW_YEAR("12-31"), WOMAN_DAY("3-8"), DEFENDERS_DAY("2-23");
        String date;

        Holidays(String date) {
            this.date = date;
        }

        String getDate() {
            return date;
        }
    }

    public static void main(String[] args) {
        try {

            Employee[] employees = {
                    Employee.createEmployee("Мария", "2000-10-10", "+375 29 451 89 61", "F"),
                    Employee.createEmployee("Феофан", "1998-02-01", "+375 44 365 88 88", "M"),
                    Employee.createEmployee("Юнона", "1985-10-13", "+375 25 105 47 89", "F")
            };


            Object[][] info = {
                    {Shop.getCustomers()[0], Shop.getItems()[0], 2}, //good
                    {Shop.getCustomers()[1], Shop.getItems()[1], -1}, //bad amount -1
                    {Shop.getCustomers()[0], Shop.getItems()[2], 150}, //bad amount >100
                    {Shop.getCustomers()[1], new Item("Цветок", 10), 1}, //no item
                    {Customer.createCustomer("Федор", "2000-07-05", "+3-444-555-66-77", "M"), Shop.getItems()[3], 1}, //no customer
            };

            System.out.println("***Графа поздравлений и сообщений для работников***");
            sendCongratulations(employees);
            System.out.println("***Конец графы поздравлений и сообщений для работников***\n");

            int capacity = 0;
            int i = 0;
            while (capacity != Shop.getOrders().length - 1 || i != info.length) {
                try {

                    Shop.getOrders()[capacity] = Shop.buy((Customer) info[i][0], (Item) info[i][1], (int) info[i][2]);
                    System.out.println("Заказ: #" + (capacity + 1001) + " успешно обработан.");
                    System.out.println("Информация по заказу:\n" + Shop.getOrders()[capacity]);
                    capacity++;
                } catch (ProductException e) {
                    e.printStackTrace();
                } catch (AmountException e) {
                    e.printStackTrace();
                } catch (HumanException e) {
                    e.printStackTrace();
                }
                ++i;
            }
        } catch (HumanException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод отправляет поздравления/сообщения в зависимости от того, какая сегодня дата
     *
     * @param employees списов сотрудников
     */
    public static void sendCongratulations(Employee[] employees) {
        String holidayToday = whatHolidayToday();
        if (holidayToday.equals(Holidays.NEW_YEAR.name())) {
            for (Employee e : employees) {
                System.out.println(e.name + " получил(-a) поздравление:\n" + sendCongratulationsNewYear());
            }
        }
        if (holidayToday.equals(Holidays.DEFENDERS_DAY.name())) {
            for (Employee e : employees) {
                if (e.gender.name().equalsIgnoreCase("male")) {
                    System.out.println(e.name + " получил поздравление:\n" + sendCongratulationsDefendersDay());
                }
            }
        }
        if (holidayToday.equals(Holidays.WOMAN_DAY.name())) {
            for (Employee e : employees) {
                if (e.gender.name().equalsIgnoreCase("female")) {
                    System.out.println(e.name + " получилa поздравление:\n" + sendCongratulationsWomanDay());
                }
            }
        } else {
            for (Employee e : employees) {
                System.out.println(e.name + " получил(-a) сообщение:\n" + sendNoHolidayMessage());
            }
        }
    }

    public static String sendCongratulationsNewYear() {
        return "\tВсего расчудесного к новому году!";
    }

    public static String sendCongratulationsDefendersDay() {
        return "\tВсего расчудесного ко дню защитника отечества!";
    }

    public static String sendCongratulationsWomanDay() {
        return "\tМилая вы наша, всех вам благ!";
    }

    public static String sendNoHolidayMessage() {
        return "\tСолнце еще высоко!";
    }

    /**
     * Метод определяет, какой сегодня праздник
     *
     * @return название праздника из перечисления Holidays
     */
    public static String whatHolidayToday() {
        for (Holidays i : Holidays.values()) {
            if (i.getDate().equals(getCurrentMonthAndDay())) {
                return Holidays.valueOf(i.name()).toString();
            }

        }
        return Holidays.NOT_A_HOLIDAY.toString();
    }

    /**
     * Возвращает сегодняшнюю дату
     * @return дату в String формата месяц-день
     */
    public static String getCurrentMonthAndDay() {
        return String.format("%d-%d", LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
//        return "3-8"; // для 8 марта
//        return "12-31"; // для 8 марта
//        return "2-23"; // для 8 марта
    }
}

