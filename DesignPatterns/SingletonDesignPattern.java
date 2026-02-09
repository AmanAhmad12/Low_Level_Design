//-------------------------------------------------------------------------------------
//
//  BEFORE SIGLETON DESIGN PATTERN IMPLEMENTATION: 
//
//-------------------------------------------------------------------------------------


// public class SingletonDesignPattern {
//     private SingletonDesignPattern(){
//         System.out.println("Singleton class Constructor is called !!! ");
//     }
//     public static void main(String[] args){
//         SingletonDesignPattern s1= new SingletonDesignPattern();
//         SingletonDesignPattern s2= new SingletonDesignPattern();// create a new instance of the class
//         System.out.println(s1==s2);// return false because s1 and s2 are different instances of the class
//     }
// }



//-------------------------------------------------------------------------------------
//
//          AFTER SIGLETON DESIGN PATTERN IMPLEMENTATION:
//
//-------------------------------------------------------------------------------------


// Singleton Design Pattern : === 
// The singleton design pattern is a software design pattern that restricts the instantiation
//  of a class to a single instance and provides a global point of access to that instance.
// This is useful when exactly one object is needed to coordinate actions across the system.
// The singleton pattern is often used in scenarios where a single instance of a class is 
// required to manage shared resources, such as database connections, logging, or configuration
//  settings. By ensuring that only one instance of the class exists, the singleton pattern
//  helps to prevent issues related to multiple instances and provides a centralized point 
// of access to the shared resource.


// In Java, the singleton pattern can be implemented using a private constructor and a 
// static method that returns the single instance of the class. The instance is typically 
// stored as a private static variable within the class, and the static method checks 
// if the instance already exists before creating a new one. This ensures that only one 
// instance of the class is created throughout the application.
// Example of Singleton Design Pattern in Java


//-----------------------------------------------------------------------------------------------


// class Singleton{
//     private static Singleton instance;
//     private Singleton(){
//         System.out.println("Singleton class Constructor is called !!! ");
//     }   
//     public static Singleton getInstance(){
//         if(instance==null) instance = new Singleton();
//         return instance;
//     }
// } 

// public class SingletonDesignPattern {
//     public static void main(String[] args){
//         Singleton s1= Singleton.getInstance();
//         Singleton s2= Singleton.getInstance();
//         System.out.println(s1==s2);
//     }
// }


//----------------------------------------------------------------------------------------------
//
//THE ABOVE CODE IS NOT A THREAD-SAFE IMPLEMENTATION OF THE SINGLETON DESIGN PATTERN. 
// IN A MULTI-THREADED ENVIRONMENT, IT IS POSSIBLE FOR MULTIPLE THREADS TO CALL THE getInstance() METHOD SIMULTANEOUSLY,
//
//-----------------------------------------------------------------------------------------------


/*      To make the singleton implementation thread-safe, we can use the synchronized keyword 
        to ensure that only one thread can access the getInstance() method at a time. However, 
        this can lead to performance issues due to the overhead of synchronization. 
        A more efficient way to implement a thread-safe singleton is to use the double-checked 
        locking pattern, which minimizes synchronization overhead while still ensuring thread safety.
*/


public class SingletonDesignPattern {

    private static volatile SingletonDesignPattern instance;

    // volatile keyword ensures that multiple threads handle the instance variable correctly
    // when it is being initialized to the Singleton instance.
    // This is important to prevent issues with instruction reordering and visibility of 
    // changes across threads.

    private SingletonDesignPattern() {
        System.out.println("Singleton class Constructor is called !!!");
    }

    public static SingletonDesignPattern getInstance() {
        if (instance == null) {
            synchronized (SingletonDesignPattern.class) { 
                
    // synchronize on the class object to ensure that only one thread can access this block at a time
    // double-checked locking to minimize synchronization overhead.
    // The first check (if instance == null) is done without synchronization for performance reasons.
    // The second check (inside the synchronized block) is necessary to ensure that the instance is still null
    // after the first thread has created the instance, preventing multiple threads from creating multiple instances.

                if (instance == null) {
                    instance = new SingletonDesignPattern();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args){
        SingletonDesignPattern s1= SingletonDesignPattern.getInstance();
        SingletonDesignPattern s2= SingletonDesignPattern.getInstance();
        System.out.println(s1==s2);// return true because s1 and s2 are the same instance of the class
    }
}

/*      
        In this implementation, the getInstance() method first checks if the instance is null.
        If it is, it enters a synchronized block to ensure that only one thread can create 
        the instance at a time. Inside the synchronized block, it checks again if the instance
        is null before creating a new instance. This double-checked locking mechanism ensures 
        that the singleton instance is created in a thread-safe manner while minimizing 
        synchronization overhead.
*/

