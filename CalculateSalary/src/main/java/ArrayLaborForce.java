public class ArrayLaborForce {
    private final LaborForce[] laborForces;

    public ArrayLaborForce(LaborForce[] laborForces) {
        this.laborForces = laborForces;
    }

    void printArray() {
        for (LaborForce i : laborForces) {
            System.out.println(i);
        }
    }
}
