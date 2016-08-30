/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 2.0
 * Moderator :Wing Kui Tsoi
 * Reader :Khue Dinh
 * Inspector :Jayatunga siriwardana
 */



package datamanagement;

// This class implements IStudentLister interface
public interface IStudentLister
{

    // This method clear all previous student records
    public void clearStudents();
    // This method adds student recods
    public void addStudent(IStudent student);
    
}  
