/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 1.0
 * Moderator :Wing Kui Tsoi
 * Reader :Khue Dinh
 * Inspector : Jayatunga siriwardana
 */

package datamanagement;
        
public class ListStudentsCTL
{
// Creating a class as ListStudentCTL

  private StudentManager sm;
  //Declaring Student Manager as sm
  public ListStudentsCTL() {sm = StudentManager.get();}
  //This method gives a list of students base on provide unit code
  public void listStudents( IStudentLister lister, String unitCode ) 
  {
    lister.clearStudents();
    StudentMap students = sm.getStudentsByUnit( unitCode );
    for (Integer id : students.keySet() ) lister.addStudent(students.get(id));
  }
}