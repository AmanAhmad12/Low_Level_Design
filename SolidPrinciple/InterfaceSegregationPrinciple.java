package SolidPrinciple;
// this code demonstrates the Interface Segregation Principle (ISP)
// ISP states that no client should be forced to depend on methods it does not use
// here we have segregated the interfaces based on the type of shapes
// if we had a single interface for all shapes then the 2D shapes would have to implement the volume method which they do not need
// thus violating the ISP

abstract class TwoDShape{
    abstract void area();
}
abstract class ThreeDShape{
    abstract void volume();
}
class Circle extends TwoDShape{
    public void area(){
        System.out.println("Area of the Circle : ");
    }
}
class Square extends TwoDShape{
    public void area(){
        System.out.println("Area of the Square : ");
    }
}
class Rectangle extends TwoDShape{
    public void area(){
        System.out.println("Area of the Rectangle : ");
    }
    public void volume(){
        throw new UnsupportedOperationException("Rectangle does not have volume");// to overcome this problem we have segregated the interfaces
    }
}
class Cube extends ThreeDShape{
    void area(){
        System.out.println("Area of the Cube : ");
    }
    public void volume(){
        System.out.println("Volume of the Cube : ");
    }
}
class Sphere extends ThreeDShape{
    void area(){
        System.out.println("Area of the Sphere : ");
    }
    public void volume(){
        System.out.println("Volume of the Sphere : ");
    }
}
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.area();
        Square s = new Square();
        s.area();
        Cube cu = new Cube();
        cu.area();
        cu.volume();
    }
}
