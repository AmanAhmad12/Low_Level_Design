// Factory Design Pattern in Java
//--------------------------------------------------------------------------
//
//          Simple Factory design pattern : It is a design pattern that provides a static method to 
//                                          create objects based on input parameters. It is not a true
//                                          design pattern but rather a simple way to encapsulate object creation logic.
//
//--------------------------------------------------------------------------

// abstract class Burger{
//     void Prepere(){};
// }
// class BasicBurger extends Burger{
//     @Override
//     void Prepere() {
//         System.out.println("Preparing Basic Burger");
//     }
// }
// class CheeseBurger extends Burger{
//     @Override
//     void Prepere() {
//         System.out.println("Preparing Cheese Burger");
//     }
// }
// class PrimiumBurger extends Burger{
//     @Override
//     void Prepere() {
//         System.out.println("Preparing Primium Burger");
//     }
// }
// class BurgerFactory{
//     public static Burger createBurger(String type){//method to create burger based on type
//         if(type=="Basic"){
//             return new BasicBurger();
//         }else if(type=="CheeseBurger"){
//             return new CheeseBurger();
//         }else if(type=="PrimiumBurger"){
//             return new PrimiumBurger();
//         }else{
//             System.out.println("Invalid choice !!!  ");
//             return null;
//         }
//     }
// }
// public class FactoryDesignPattern {
//     public static void main(String[] args) {
//         Burger b1 = BurgerFactory.createBurger("Basic");
//         b1.Prepere();
//         Burger b2 = BurgerFactory.createBurger("CheeseBurger");
//         b2.Prepere();
//         Burger b3 = BurgerFactory.createBurger("Primium");
//         b3.Prepere();
//         Burger b4= BurgerFactory.createBurger("xyz");
//         b4.Prepere();
        
//     }
// }


//----------------------------------------------------------------------------------------------------
//
//                   FACTORY METHOD :  It is a creational design pattern that provides an interface for creating objects in a superclass,
//                                     but allows subclasses to alter the type of objects that will be created.     
//----------------------------------------------------------------------------------------------------

// abstract class Burger{
//     void PrepareBurger(){};
// }
// class BasicBurger extends Burger{
//     @Override
//     public void PrepareBurger() {
//         System.out.println("Preparing Basic Burger");
//     }
// }
// class CheeseBurger extends Burger{
//     @Override
//     public void PrepareBurger() {
//         System.out.println("Preparing Cheese Burger");
//     }
// }
// class PrimiumBurger extends Burger{
//     @Override
//     public void PrepareBurger() {
//         System.out.println("Preparing Primium Burger");
//     }
// }
// class BasicWeatBurger extends Burger{
//     @Override
//     public void PrepareBurger() {
//         System.out.println("Preparing Basic Weat Burger");
//     }
// }
// class cheeseWeatBurger extends Burger{
//     @Override
//     public void PrepareBurger() {
//         System.out.println("Preparing Cheese Weat Burger");
//     }
// }
// class PrimiumWeatBurger extends Burger{
//     @Override
//     public void PrepareBurger() {
//         System.out.println("Preparing Primium Weat Burger");
//     }
// }

// abstract class BurgerFactory{ //abstract factory class
//     abstract Burger createBurger(String type);
// }
// class NormalBurgerFactory extends BurgerFactory{//concrete factory class for normal burgers
//                                                 // concrete class : those classes that implement the abstract class and provide implementation for the abstract method
//     @Override
//     public Burger createBurger(String type) {
//         if(type=="Basic"){
//             return new BasicBurger();
//         }else if(type=="CheeseBurger"){
//             return new CheeseBurger();
//         }else if(type=="PrimiumBurger"){
//             return new PrimiumBurger();
//         }else{
//             System.out.println("Invalid choice !!!  ");
//             return null;
//         }
//     }
// }
// class WeatBurgerFactory extends BurgerFactory{//concrete factory class for weat burgers
//     @Override
//     public Burger createBurger(String type) {
//         if(type=="Basic"){
//             return new BasicWeatBurger();
//         }else if(type=="CheeseBurger"){ 
//             return new cheeseWeatBurger();
//         }else if(type=="PrimiumBurger"){
//             return new PrimiumWeatBurger();
//         }else{
//             System.out.println("Invalid choice !!!  ");
//             return null;
//         }
//     }
// }   

// public class FactoryDesignPattern {
//     public static void main(String[] args) {
//         BurgerFactory normalFactory = new NormalBurgerFactory();
//         Burger b1 = normalFactory.createBurger("Basic");
//         b1.PrepareBurger();
//         Burger b2 = normalFactory.createBurger("CheeseBurger");
//         b2.PrepareBurger();

//         BurgerFactory weatFactory = new WeatBurgerFactory();
//         Burger b3 = weatFactory.createBurger("PrimiumBurger");
//         b3.PrepareBurger();
//         Burger b4= weatFactory.createBurger("xyz");
//         b4.PrepareBurger();
        
//     }
// }


//----------------------------------------------------------------------------------------------------
//
//                   Abstract Factory : It is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes.
//                                     It is a super factory that creates other factories. It is used when there are multiple families of products, and you want to ensure that the products from one family are used together.
//----------------------------------------------------------------------------------------------------  


abstract class Burger{
    void prepare(){};
}
class BasicBurger extends Burger{
    @Override
    void prepare() {
        System.out.println("Preparing Basic Burger");
    }
}
class cheeseBurger extends Burger{
    @Override
    void prepare() {
        System.out.println("Preparing Cheese Burger");
    }
}
class PrimiumBurger extends Burger{
    @Override
    void prepare() {
        System.out.println("Preparing Primium Burger");
    }
}
class BasicWeatBurger extends Burger{
    @Override
    void prepare() {
        System.out.println("Preparing Basic Weat Burger");
    }
}
class cheeseWeatBurger extends Burger{
    @Override
    void prepare() {
        System.out.println("Preparing Cheese Weat Burger");
    }
}
class PrimiumWeatBurger extends Burger{
    @Override
    void prepare() {
        System.out.println("Preparing Primium Weat Burger");
    }
}
abstract class GarlicBread{
    void prepare(){};
}
class BasicGarlicBread extends GarlicBread{
    @Override
    void prepare() {
        System.out.println("Preparing Basic Garlic Bread");
    }
}
class CheeseGarlicBread extends GarlicBread{
    @Override
    void prepare() {
        System.out.println("Preparing Cheese Garlic Bread");
    }
}
class PrimiumGarlicBread extends GarlicBread{
    @Override
    void prepare() {
        System.out.println("Preparing Primium Garlic Bread");
    }
}
class BasicWheatGarlicBread extends GarlicBread{
    @Override
    void prepare() {
        System.out.println("Preparing Basic Wheat Garlic Bread");
    }
}
class CheeseWheatGarlicBread extends GarlicBread{
    @Override
    void prepare() {
        System.out.println("Preparing Cheese Wheat Garlic Bread");
    }
}
class PrimiumWheatGarlicBread extends GarlicBread{
    @Override
    void prepare() {
        System.out.println("Preparing Primium Wheat Garlic Bread");
    }
}

abstract class FoodFactory{
    abstract Burger createBurger(String type);
    abstract GarlicBread createGarlicBread(String type);
}
class NormalFoodFactory extends FoodFactory{
    @Override
    public Burger createBurger(String type) {
        if(type=="Basic"){
            return new BasicBurger();
        }else if(type=="CheeseBurger"){
            return new cheeseBurger();
        }else if(type=="PrimiumBurger"){
            return new PrimiumBurger();
        }else{
            System.out.println("Invalid choice !!!  ");
            return null;
        }
    }
    @Override
    public GarlicBread createGarlicBread(String type) {
        if(type=="Basic"){
            return new BasicGarlicBread();
        }else if(type=="CheeseGarlicBread"){
            return new CheeseGarlicBread();
        }else if(type=="PrimiumGarlicBread"){
            return new PrimiumGarlicBread();
        }else{
            System.out.println("Invalid choice !!!  ");
            return null;
        }
    }
}
class WeatFoodFactory extends FoodFactory{
    @Override
    public Burger createBurger(String type) {
        if(type=="Basic"){
            return new BasicWeatBurger();
        }else if(type=="CheeseBurger"){ 
            return new cheeseWeatBurger();
        }else if(type=="PrimiumBurger"){
            return new PrimiumWeatBurger();
        }else{
            System.out.println("Invalid choice !!!  ");
            return null;
        }
    }
    @Override
    public GarlicBread createGarlicBread(String type) {
        if(type=="Basic"){
            return new BasicWheatGarlicBread();
        }else if(type=="CheeseGarlicBread"){
            return new CheeseWheatGarlicBread();
        }else if(type=="PrimiumGarlicBread"){
            return new PrimiumWheatGarlicBread();
        }else{
            System.out.println("Invalid choice !!!  ");
            return null;
        }
    }
}
class FactoryDesignPattern {
    public static void main(String[] args) {
        FoodFactory normalFactory = new NormalFoodFactory();
        Burger b1 = normalFactory.createBurger("Basic");
        b1.prepare();
        GarlicBread g1 = normalFactory.createGarlicBread("CheeseGarlicBread");
        g1.prepare();

        FoodFactory weatFactory = new WeatFoodFactory();
        Burger b2 = weatFactory.createBurger("PrimiumBurger");
        b2.prepare();
        GarlicBread g2= weatFactory.createGarlicBread("xyz");
        g2.prepare();
        
    }
}