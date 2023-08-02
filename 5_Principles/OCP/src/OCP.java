package src;

public class OCP {
  public static void main(String[] args) {
    Square square = new Square(9.1);
    PostageStamp stamp = new PostageStamp(square);
    System.out.println(stamp.toString());
    /////////
    Circle circle = new Circle(9.1);
    PostageStamp stamp2 = new PostageStamp(circle);
    System.out.println(stamp2.toString());
  }
}
