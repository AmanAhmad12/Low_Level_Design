package SolidPrinciple;
import java.util.*;
// this code demonstrates the Single Responsibility Principle (SRP)
// each class has a single responsibility means it should have to do only one work 

// ProductCart → manages cart products only
class ProductCart {
    private List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
    }

    List<Product> getAllProducts() {
        return products;
    }
}

// ProductDisplay → responsible only for display
class ProductDisplay {
    void displayProduct(Product product) {
        System.out.println(
            "Product Name: " + product.productName +
            ", Price: " + product.price
        );
    }
}

// TotalPrice → responsible only for price calculation
class TotalPrice {
    double calculateTotalPrice(List<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }
}

// Main class (Entry point)

// all classes follow the (has-a) relationship and single responsibility principle;
//note srp does not take place in inheritance because in inheritance (is-a) relationship
//  a class can have multiple responsibilities 
// and here each class is focused on a single task
// thus making the code more maintainable and scalable
//important note  :== we can use inheritance along with srp but we have to 
// make sure that each derived class should have only one responsibility

public class SingleResposibilityPrinciple {

    public static void main(String[] args) {

        // Create products
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Mobile", 20000);

        // Add products to cart
        ProductCart cart = new ProductCart();
        cart.addProduct(p1);
        cart.addProduct(p2);

        // Display products
        ProductDisplay display = new ProductDisplay();
        for (Product product : cart.getAllProducts()) {
            display.displayProduct(product);
        }

        // Calculate total price
        TotalPrice totalPrice = new TotalPrice();
        double total = totalPrice.calculateTotalPrice(cart.getAllProducts());

        System.out.println("Total Cart Price: " + total);
    }
}


// Output:
// Product Name: Laptop, Price: 50000.0
// Product Name: Mobile, Price: 20000.0
// Total Cart Price: 70000.0

