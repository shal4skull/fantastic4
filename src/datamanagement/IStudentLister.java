
/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 1.0
 * Moderator :Wing Kui Tsoi
 * Reader :Khue Dinh
 * Inspector : Jayatunga siriwardana
 */

package datamanagement;

public interface IStudentLister
{
// This class implements IStudentLister interface

    public void clearStudents();
    // This method clear all previous student records
    public void addStudent(IStudent student);
    // This method adds student recods
}  
