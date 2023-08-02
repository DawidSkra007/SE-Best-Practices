package src;

public class SRP {
    public static void main(String[] args) {
        Module module = new Module("OOP", "COMP1234");
        Student john = new Student("John");
        ModuleAttendee john_enrolled = new ModuleAttendee(john, module);
        System.out.println(john_enrolled.toString());
    }
}
