package src;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  String.format("%s",name);
    }
}
