package SolidPrinciple;

abstract class DataBase{
    abstract void Save(String Data);
}
class SQLDB extends DataBase{
    void Save(String Data){
        System.out.println("Save to SQL DataBase : "+ Data);
    }
}
class MongoDB extends DataBase{
    void Save(String Data){
        System.out.println("Save to Mongo DataBase : "+ Data);
    }
}
class Client{
    //dependency injection via method parameter
    void SaveData(DataBase db){
        db.Save("Sample Data");
    }
}
//suppose i want to add another database like OracleDB then i just have to create a new class OracleDB
// that extends DataBase and implement the Save method
// thus the Client class is not dependent on any specific database implementation
//example:

class OracleDB extends DataBase{
    void Save(String Data){
        System.out.println("Save to Oracle DataBase : "+ Data);
    }
}





// this code demonstrates the Dependency Inversion Principle (DIP)
// DIP states that high-level modules should not depend on low-level modules    
// both should depend on abstractions
// here Client is a high-level module and SQLDB, MongoDB , OracleDB are low-level modules

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Client client = new Client();
        DataBase sqldb = new SQLDB();
        client.SaveData(sqldb);
        DataBase mongodb = new MongoDB();
        client.SaveData(mongodb);
        DataBase oracledb = new OracleDB();
        client.SaveData(oracledb);

    }  
}
// if we directly use SQLDB or MongoDB in Client class then it would violate the DIP
// because Client would be dependent on specific database implementations
// thus making it difficult to change or add new database implementations in future
// but by depending on the abstraction DataBase both Client and database implementations
// are decoupled and can be changed independently
// thus making the code more maintainable and scalable
// important note:-- DIP is all about depending on abstractions rather than concrete implementations
// this can be achieved using interfaces or abstract classes 