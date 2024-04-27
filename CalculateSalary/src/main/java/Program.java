import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        Freelancer f1 = Freelancer.create("Alex", 4);
        Worker w1 = Worker.create("Bob", 800);

        LaborForce[] laborForce = new LaborForce[]{
                Freelancer.create("Sultan", 10),
                Worker.create("Olga", 666),
                f1,
                w1
        };

        for (LaborForce i : laborForce) {
            System.out.println(i);
        }

        System.out.println("\nСортировка по ЗП за месяц с использованием foreach\n");
        List<LaborForce> list = Arrays.asList(laborForce);
        Collections.sort(list);

        ArrayLaborForce allLaborForces = new ArrayLaborForce(laborForce);
        allLaborForces.printArray();
    }
}
