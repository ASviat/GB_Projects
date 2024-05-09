import Exceptions.IllegalArgumentException;
import Exceptions.IllegalNameException;
import Exceptions.InsufficientFundsException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int selectedChoice;
        try (Scanner scanner = new Scanner(System.in)) {
            Account[] accounts = {CreditAccount.createAccount("Fruasar", 5000),
                    DebitAccount.createAccount("Lola", 1600),
                    CreditAccount.createAccount("Alex", -120),
                    DebitAccount.createAccount("Julie", 500)};

            System.out.println("What operation you'd like to perform?\n" +
                    "Press 1 to print all account\n" +
                    "Press 2 to send money\n" +
                    "Press 3 to get his/her money:");
            selectedChoice = scanner.nextInt();
            switch (selectedChoice) {
                case 1 -> printAccounts(accounts);
                case 2 -> {
                    giveMoney(accounts);
                    printAccounts(accounts);
                }
                case 3 -> {
                    getMoney(accounts);
                    printAccounts(accounts);
                }
            }
        } catch (IllegalArgumentException | IllegalNameException | InsufficientFundsException e) {
            e.printStackTrace();
        }
    }

    public static void printAccounts(Account[] accounts) {
        for (Account i : accounts) {
            System.out.println(i);
        }
    }

    public static void giveMoney(Account[] accounts) {
        printAccounts(accounts);
        System.out.println("Whom would you like to send money?\nType his/her name: ");
        try (Scanner input = new Scanner(System.in)) {
            String name = input.nextLine();
            for (Account i : accounts) {
                if (name.equalsIgnoreCase(i.name)) {
                    System.out.println("Name correct.");
                    System.out.println("How much money you'd like to send?");
                    long moneyToSend = input.nextLong();
                    i.balance += moneyToSend;
                    System.out.println("Money sent successfully.");
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getMoney(Account[] accounts) throws InsufficientFundsException {
        printAccounts(accounts);
        System.out.println("From who you would like to get money?\nType his/her name: ");
        try (Scanner input = new Scanner(System.in)) {
            String name = input.nextLine();
            for (Account i : accounts) {
                if (name.equalsIgnoreCase(i.name)) {
                    System.out.println("Name correct.");
                    System.out.println("How much money you'd like to get?");
                    long moneyToGet = input.nextLong();

                    if (isMinusOperationOK((DebitAccount) i, moneyToGet)) {
                        i.balance -= moneyToGet;
                        System.out.println("Money got successfully.");
                    } else {
                        throw new InsufficientFundsException("Balance can't be under 0: " + (i.balance - moneyToGet));
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isMinusOperationOK(DebitAccount account, long amount) {
//        System.out.println(account.getClass());
        if (account.balance - amount > 0) {
            return true;
        } else {
            return false;
        }


    }
}
