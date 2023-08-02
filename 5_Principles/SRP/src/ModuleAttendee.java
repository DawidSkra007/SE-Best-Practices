package src;


public class ModuleAttendee {

  private Module module;
  
  public ModuleAttendee(Student name, Module module) {
    this.name = name;
    this.setGrade(Grade.NONE);
    this.module = module;
  }

  public void setGrade(Grade grade) {
    this.grade = grade;
  }

  public String toString() {
    return String.format("%s took %s, achieving the grade: %s", name.toString(), module.toString(), grade);
  }

  private Student name;
  private Grade grade;
}
