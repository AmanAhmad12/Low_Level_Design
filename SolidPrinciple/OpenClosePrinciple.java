package SolidPrinciple;
// this code demonstrates the Open/Closed Principle (OCP)
// classes are open for extension but closed for modification

import java.util.*;

// ProductCart → manages cart
class ProductCart {
    private List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
    }

    List<Product> getAllProducts() {
        return products;
    }
}

// ProductDisplay → displays product
class ProductDisplay {
    void displayProduct(Product product) {
        System.out.println(
            "Product Name: " + product.productName +
            ", Price: " + product.price
        );
    }
}

// Abstraction → OPEN for extension 
// but CLOSED for modification

abstract class AddToDatabase {
    abstract void addProductToDatabase(Product product);
}

// Extension 1 → MySQL
class MySQLDatabase extends AddToDatabase {
    @Override
    void addProductToDatabase(Product product) {
        System.out.println("Adding " + product.productName + " to MySQL Database");
    }
}

// Extension 2 → MongoDB
class MongoDBDatabase extends AddToDatabase {
    @Override
    void addProductToDatabase(Product product) {
        System.out.println("Adding " + product.productName + " to MongoDB Database");
    }
}


// Main class
public class OpenClosePrinciple {

    public static void main(String[] args) {

        Product prod1 = new Product("Laptop", 1200.00);
        Product prod2 = new Product("Smartphone", 800.00);

        ProductCart cart = new ProductCart();
        cart.addProduct(prod1);
        cart.addProduct(prod2);

        ProductDisplay display = new ProductDisplay();
        for (Product prod : cart.getAllProducts()) {
            display.displayProduct(prod);
        }

        // OCP in action
        AddToDatabase mysqlDb = new MySQLDatabase();
        mysqlDb.addProductToDatabase(prod1);

        AddToDatabase mongoDb = new MongoDBDatabase();
        mongoDb.addProductToDatabase(prod2);
    }
}
