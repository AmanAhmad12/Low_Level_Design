// package DesignPatterns;
// import java.util.*;
// // =======================
// // Strategy Design Pattern Example
// // =======================

// // expalnation: The Strategy Design Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
// // This allows the algorithm to vary independently from clients that use it.
// // In this example, we define a Strategy interface with different implementations for addition, subtraction, and multiplication.
// // The client class uses a Strategy object to execute the desired algorithm without being tightly coupled to any specific implementation.
// // =======================  

// interface Strategy {
//     int execute(int a, int b);
// }
// class Addition implements Strategy {
//     public int execute(int a, int b) {
//         return a + b;
//     }
// }
// class Subtraction implements Strategy {
//     public int execute(int a, int b) {
//         return a - b;
//     }
// }
// class Multiplication implements Strategy {
//     public int execute(int a, int b) {
//         return a * b;
//     }
// }
// class client {
//     private Strategy strategy;
//     public client(Strategy strategy) {
//         this.strategy = strategy;
//     }
//     public int executeStrategy(int a, int b) {
//         return strategy.execute(a, b);
//     }
// }
// public class StrategyDesignPattern {
// public static void main(String[] args) {
//     client addClient = new client(new Addition());
//     System.out.println("10 + 5 = " + addClient.executeStrategy(10, 5));

//     client subClient = new client(new Subtraction());
//     System.out.println("10 - 5 = " + subClient.executeStrategy(10, 5));

//     client mulClient = new client(new Multiplication());
//     System.out.println("10 * 5 = " + mulClient.executeStrategy(10, 5));
//     //complete the code
    


//     }
// }

//-------------------------------------------------------------------------------------------------------------
//0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
//=============================================================================================================

//second example : 
// Strategy Design Pattern - Full Code (Single File)

// ----------- Strategy Interfaces -----------
// import java.util.*;
// interface WalkBehavior {
//     void walk();
// }

// interface TalkBehavior {
//     void talk();
// }

// interface FlyBehavior {
//     void fly();
// }

// // ----------- Walk Strategies -----------
// class NormalWalk implements WalkBehavior {
//     public void walk() {
//         System.out.println("Normal Walking");
//     }
// }

// class FastWalk implements WalkBehavior {
//     public void walk() {
//         System.out.println("Fast Walking");
//     }
// }

// class NoWalk implements WalkBehavior {
//     public void walk() {
//         System.out.println("No Walking");
//     }
// }

// // ----------- Talk Strategies -----------
// class NormalTalk implements TalkBehavior {
//     public void talk() {
//         System.out.println("Normal Talking");
//     }
// }

// class FastTalk implements TalkBehavior {
//     public void talk() {
//         System.out.println("Fast Talking");
//     }
// }

// class NoTalk implements TalkBehavior {
//     public void talk() {
//         System.out.println("No Talking");
//     }
// }

// // ----------- Fly Strategies -----------
// class NormalFly implements FlyBehavior {
//     public void fly() {
//         System.out.println("Normal Flying");
//     }
// }

// class FastFly implements FlyBehavior {
//     public void fly() {
//         System.out.println("Fast Flying");
//     }
// }

// class NoFly implements FlyBehavior {
//     public void fly() {
//         System.out.println("No Flying");
//     }
// }

// // ----------- Context Class -----------
// //context class : means : the class that uses the strategy interfaces to perform actions.
// //here, the Robot class is the context class that uses the WalkBehavior, TalkBehavior, and FlyBehavior interfaces to perform actions.

// abstract class Robot {
//     protected WalkBehavior walkBehavior;
//     protected TalkBehavior talkBehavior;
//     protected FlyBehavior flyBehavior;

//     public Robot(WalkBehavior w, TalkBehavior t, FlyBehavior f) {
//         this.walkBehavior = w;
//         this.talkBehavior = t;
//         this.flyBehavior = f;
//     }

//     public void performActions() {
//         walkBehavior.walk();
//         talkBehavior.talk();
//         flyBehavior.fly();
//     }
// }

// // ----------- Concrete Robots -----------
// class HumanoidRobot extends Robot {
//     public HumanoidRobot(WalkBehavior w, TalkBehavior t, FlyBehavior f) {
//         super(w, t, f);
//     }
// }

// class AnimalRobot extends Robot {
//     public AnimalRobot(WalkBehavior w, TalkBehavior t, FlyBehavior f) {
//         super(w, t, f);
//     }
// }

// // ----------- Main Class -----------

// //this is the main class where we create different robots with various combinations of behaviors and execute their actions.
// //this is the perfect example of the strategy design pattern as we are able to change the behavior of the robots at runtime by passing different strategy implementations to the constructor of the Robot class.
// //we can easily add new behaviors or new types of robots without modifying the existing code, adhering to the Open/Closed Principle.
// //the strategy design pattern promotes composition over inheritance, allowing us to create flexible and reusable code by encapsulating behaviors in separate classes and delegating the execution to those classes.
// //this design pattern is particularly useful when we have multiple algorithms for a specific task and want to switch between them dynamically at runtime without changing the client code that uses those algorithms.
// //the strategy design pattern is a powerful tool for designing flexible and maintainable software systems, allowing us to decouple the behavior of an object from its implementation and enabling us to change the behavior at runtime 
// // without modifying the client code.   
// public class StrategyDesignPattern {
//     public static void main(String[] args) {

//         Robot robot1 = new HumanoidRobot(
//                 new NormalWalk(),
//                 new NormalTalk(),
//                 new NormalFly()
//         );

         
//         Robot robot2 = new HumanoidRobot(
//                 new FastWalk(),
//                 new FastTalk(),
//                 new FastFly()
//         );

//         Robot robot3 = new HumanoidRobot(
//                 new NoWalk(),
//                 new NoTalk(),
//                 new NoFly()
//         );

//         Robot robot4 = new AnimalRobot(
//                 new NormalWalk(),
//                 new NoTalk(),
//                 new NoFly()
//         );

//         Robot robot5= new AnimalRobot(new NoWalk(),new NoTalk(),new NormalFly()); // this is passing different strategies to the AnimalRobot ( new reference of the class)
//         System.out.println("Robot 1:");
//         robot1.performActions();

//         System.out.println("\nRobot 2:");
//         robot2.performActions();

//         System.out.println("\nRobot 3:");
//         robot3.performActions();

//         System.out.println("\nRobot 4:");
//         robot4.performActions();

//         System.out.println("\nRobot 5:");
//         robot5.performActions();

//     }
// }


//-------------------------------------------------------------------------------------------------------------
//                                    THIRD EXAMPLE
//-------------------------------------------------------------------------------------------------------------
// Strategy Design Pattern - E-Commerce Payment System Example
// In this example, we define a PaymentSystem interface with different implementations for UPI, Credit/Debit Card, Net Banking, and Cash On Delivery.
// The ECommercePlatform class uses a PaymentSystem object to process payments without being tightly coupled to any specific implementation.
// 
interface PaymentSystem{
    void PayNow();
}
abstract class  UPI implements PaymentSystem{
    public void PayNow(){
        System.out.println("Payment done by using UPI  !  ");
    }
}
abstract class Credit_Debit_Card implements PaymentSystem {
    public void PayNow() {
        System.out.println("Payment done by using Credit/Debit Card  !  ");
    }
}
abstract class NetBanking implements PaymentSystem {
    public void PayNow() {
        System.out.println("Payment done by using Net Banking  !  ");
    }
}
abstract class CashOnDelivery implements PaymentSystem {
    public void PayNow() {
        System.out.println("Payment done by using Cash On Delivery  !  ");
    }
}
class Paytm extends UPI {
    public void PayNow() {
        System.out.println("Payment done by using Paytm UPI  !  ");
    }
}
class PhonePe extends UPI {
    public void PayNow() {
        System.out.println("Payment done by using PhonePe UPI  !  ");
    }
}
class AmazonPay extends UPI {
    public void PayNow() {
        System.out.println("Payment done by using Amazon Pay UPI  !  ");
    }
}
class HDFC_Card extends Credit_Debit_Card {
    public void PayNow() {
        System.out.println("Payment done by using HDFC Credit/Debit Card  !  ");
    }
}
class ICICI_Card extends Credit_Debit_Card {
    public void PayNow() {
        System.out.println("Payment done by using ICICI Credit/Debit Card  !  ");
    }
}
class SBI_Card extends Credit_Debit_Card {
    public void PayNow() {
        System.out.println("Payment done by using SBI Credit/Debit Card  !  ");
    }
}
class HDFC_NetBanking extends NetBanking {
    public void PayNow() {
        System.out.println("Payment done by using HDFC Net Banking  !  ");
    }
}
class ICICI_NetBanking extends NetBanking {
    public void PayNow() {
        System.out.println("Payment done by using ICICI Net Banking  !  ");
    }
}
class SBI_NetBanking extends NetBanking {
    public void PayNow() {
        System.out.println("Payment done by using SBI Net Banking  !  ");
    }
}
class ECommercePlatform {
    private PaymentSystem paymentSystem;

    public ECommercePlatform(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public void processPayment() {
        paymentSystem.PayNow();
    }
}
public class StrategyDesignPattern {
    public static void main(String[] args) {
        ECommercePlatform platform1 = new ECommercePlatform(new Paytm());
        platform1.processPayment();

        ECommercePlatform platform2 = new ECommercePlatform(new HDFC_Card());
        platform2.processPayment();

        ECommercePlatform platform3 = new ECommercePlatform(new ICICI_NetBanking());
        platform3.processPayment();

        ECommercePlatform platform4 = new ECommercePlatform(new CashOnDelivery(){});
        platform4.processPayment();
    }
}