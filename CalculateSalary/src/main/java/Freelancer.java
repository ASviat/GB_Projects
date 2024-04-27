public class Freelancer extends LaborForce {

    /**
     * @param name       Имя фрилансера
     * @param payPerHour Ставка часа работы умножается на все рабочее время за месяц и передается в супер-конструктор
     */
    private Freelancer(String name, double payPerHour) {
        super(name, payPerHour * 20.8 * 8);

    }

    /**
     * @return Декорирование вывода суперкласса с пометкой данного класса
     */
    @Override
    public String toString() {
        return super.toString() + "->Freelancer";
    }

    /**
     * Фабрика Freelancer
     *
     * @param name       - Имя
     * @param payPerHour - ЗП за час работы
     * @return передает нового фрилансера в приватный конструктор
     */
    static Freelancer create(String name, double payPerHour) {
        if (name == null || name.length() < 3) {
            throw new RuntimeException("Некорректное имя человека");
        }
        if (payPerHour <= 0) {
            throw new RuntimeException("Рабство запрещено");
        }
        return new Freelancer(name, payPerHour);
    }

}
