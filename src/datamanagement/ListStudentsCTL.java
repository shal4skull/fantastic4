/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 1.0
 * Moderator :
 * Reader :
 * Recorder :
 * Inspector :
 */

package datamanagement;
        
public class ListStudentsCTL
{
// Creating a class as ListStudentCTL

  private StudentManager sm;
  //Declaring Student Manager as sm
  public ListStudentsCTL() {sm = StudentManager.get();}
  public void listStudents( IStudentLister lister, String unitCode ) 
  {
    lister.clearStudents();
    StudentMap students = sm.getStudentsByUnit( unitCode );
    for (Integer id : students.keySet() ) lister.addStudent(students.get(id));
  }
}