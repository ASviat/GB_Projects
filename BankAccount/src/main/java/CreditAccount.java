import Exceptions.IllegalArgumentException;
import Exceptions.IllegalNameException;

public class CreditAccount extends Account {

    private static final long LIMIT = -2_000;

    private CreditAccount(String name, long balance) {
        super(name, balance);
    }

    public static CreditAccount createAccount(String name, long balance) throws IllegalNameException, IllegalArgumentException {
        if (name.length() < 3) {
            throw new IllegalNameException("Not correct name: " + name);
        }
        if (balance < LIMIT) {
            throw new IllegalArgumentException("Account balance < LIMIT: " + balance + " < " + LIMIT);
        }
        return new CreditAccount(name, balance);
    }
}
