package src;

public class Circle implements Shape {
    public Circle(double radius){
        this.radius = radius;
    }
    
    public String toString(){
        return "circle, side of the radius " + radius;
    }
    
    private double radius;
}
    
