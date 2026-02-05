// package SolidPrinciple;
// // this code demonstrates the Liskov Substitution Principle (LSP)
// // Subtypes must be substitutable for their base types without altering the 
// // correctness of the program
// // Base abstraction: deposit is allowed
// abstract class NonWithdrawableAccount {
//     protected double balance;

//     void deposit(double amount) {
//         balance += amount;
//         System.out.println("Deposit successful. Balance = " + balance);
//     }
// }

// // Extended abstraction: withdraw is allowed
// // only for accounts that support withdrawal
// abstract class WithdrawableAccount extends NonWithdrawableAccount {

//     void withdraw(double amount) {
//         balance -= amount;
//         System.out.println("Withdraw successful. Balance = " + balance);
//     }
// }

// // Savings account – fully honors parent behavior
// class SavingsAccount extends WithdrawableAccount {

//     @Override
//     void deposit(double amount) {
//         super.deposit(amount);
//         System.out.println("SavingsAccount deposit processed");
//     }

//     @Override
//     void withdraw(double amount) {
//         super.withdraw(amount);
//         System.out.println("SavingsAccount withdrawal processed");
//     }
// }

// // Current account – same contract, different type
// class CurrentAccount extends WithdrawableAccount {

//     @Override
//     void deposit(double amount) {
//         super.deposit(amount);
//         System.out.println("CurrentAccount deposit processed");
//     }

//     @Override
//     void withdraw(double amount) {
//         super.withdraw(amount);
//         System.out.println("CurrentAccount withdrawal processed");
//     }
// }

// // Fixed Deposit – no withdrawal allowed
// class FixedDepositAccount extends NonWithdrawableAccount {

//     @Override
//     void deposit(double amount) {
//         super.deposit(amount);
//         System.out.println("FixedDepositAccount deposit processed");
//     }
// }

// // Client code – LSP compliant
// // uses base types without worrying about specific implementations
// class BankClient {
//     // Perform deposit
//     void performDeposit(NonWithdrawableAccount account, double amount) {
//         account.deposit(amount);
//     }
//     // Perform withdraw
//     void performWithdraw(WithdrawableAccount account, double amount) {
//         account.withdraw(amount);
//     }
// }

// // Main class
// public class LiskovSubstitutionPrinciple {

//     public static void main(String[] args) {

//         BankClient client = new BankClient();

//         NonWithdrawableAccount fd = new FixedDepositAccount();
//         client.performDeposit(fd, 1000);

//         WithdrawableAccount savings = new SavingsAccount();
//         client.performDeposit(savings, 2000);
//         client.performWithdraw(savings, 500);

//         WithdrawableAccount current = new CurrentAccount();
//         client.performDeposit(current, 3000);
//         client.performWithdraw(current, 1000);
//     }
// }




package SolidPrinciple;
// this code demonstrates the Liskov Substitution Principle (LSP)
// Subtypes must be substitutable for their base types without altering the
class Organism {
    void eat() {
        System.out.println("Organism is eating");
    }
}
class Animal extends Organism {
    void bark() {
        throw new OutOfMemoryError("This animal cannot bark");
    }
}
class Dog extends Animal {
    void wagTail() {
        //  throw new OutOfMemoryError("This dog cannot wag its tail"); // allowed in lsp
        throw new RuntimeException("This dog cannot wag its tail"); // not allowed in lsp
        // because RuntimeException is unchecked exception aand it alters the expected behavior of the program
        // checked exceptions are part of method signature and must be declared or handled
        // unchecked exceptions are not part of method signature and can be thrown without declaration

    }
}
public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
       
        Animal myAnimal = new Dog();
        myAnimal.eat(); // valid
        myAnimal.bark(); // throws OutOfMemoryError
        Dog myDog = (Dog) myAnimal;
        myDog.wagTail(); // throws RuntimeException
        // thus violating lsp
    }
}