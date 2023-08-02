package src;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ModuleAttendeeTest {
  @Before
  public void setup() {
    Module mdl = new Module("OOP", "COMP1234");
    Student student = new Student("John");
    john = new ModuleAttendee(student, mdl);
  }
  
  @Test
  public void testToString() {
    assertEquals("John took COMP1234:OOP, achieving the grade: NONE", john.toString());
  }

  @Test
  public void testSetGrade() {
    john.setGrade(Grade.PASS);
    assertEquals("John took COMP1234:OOP, achieving the grade: PASS", john.toString());
  }
  
  private ModuleAttendee john;
}
