/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 2.0
 * Moderator :Wing Kui Tsoi
 * Reader :Khue Dinh
 * Inspector :Jayatunga siriwardana
 */


package datamanagement;

// Creating a class as ListStudentCTL        
public class ListStudentsCTL
{

  //Declaring Student Manager as sm
  private StudentManager sm;
  //This method gives a list of students base on provide unit code
  public ListStudentsCTL() {sm = StudentManager.get();}
  public void listStudents( IStudentLister lister, String unitCode ) 
  {
    lister.clearStudents();
    StudentMap students = sm.getStudentsByUnit( unitCode );
    for (Integer id : students.keySet() ) lister.addStudent(students.get(id));
  }
}