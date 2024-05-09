import Exceptions.IllegalArgumentException;
import Exceptions.IllegalNameException;

public class DebitAccount extends Account {
    private DebitAccount(String name, long balance) {
        super(name, balance);
    }

    public static DebitAccount createAccount(String name, long balance) throws IllegalNameException, IllegalArgumentException {
        if (name.length() < 3) {
            throw new IllegalNameException("Not correct name: " + name);
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Account balance < 0: " + balance);
        }
        return new DebitAccount(name, balance);
    }
}
