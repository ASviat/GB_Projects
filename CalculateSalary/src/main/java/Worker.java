public class Worker extends LaborForce {

    private Worker(String name, double payPerMonth) {
        super(name, payPerMonth);
    }

    /**
     * @return Декорирование вывода суперкласса с пометкой данного класса
     */
    @Override
    public String toString() {
        return super.toString() + "->Worker";
    }

    static Worker create(String name, double payPerMonth) {
        if (name == null || name.length() < 3) {
            throw new RuntimeException("Некорректное имя человека");
        }
        if (payPerMonth <= 0) {
            throw new RuntimeException("Рабство запрещено");
        }
        return new Worker(name, payPerMonth);
    }

}
