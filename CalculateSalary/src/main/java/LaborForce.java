/**
 * Абстрактный класс для последующего создания всех типов работников
 */
public abstract class LaborForce implements Comparable<LaborForce> {

    protected String name;
    protected double salaryPerMonth;
    protected static int id;
    protected String counter;


    public LaborForce(String name, double salaryPerMonth) {
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        counter = String.format("%d", ++id);
    }


    /**
     * Главный декоратор печати наследованных объектов класса.
     *
     * @return декорированный вывод
     */
    @Override
    public String toString() {
        return "LaborForce" + "#" + counter + "{" +
                "name='" + name + '\'' +
                ", salaryPerMonth=" + salaryPerMonth +
                '}';
    }

    /**
     * Для сравнения по величине месячной ЗП
     *
     * @param o объект сравнения.
     * @return 1 или 0
     */
    @Override
    public int compareTo(LaborForce o) {
        return Double.compare(this.salaryPerMonth, o.salaryPerMonth);
    }
}
