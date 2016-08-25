/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 1.0
 * Moderator :Wing Kui Tsoi
 * Reader :Khue Dinh
 * Inspector : Jayatunga siriwardana
 */

package datamanagement;

public interface IStudent
{
// This class implements IStudent interface

    public Integer getID();
    // This method returns student ID
    public String getFirstName();
    // This method returns student first name
    public void setFirstName(String firstName);
    // This method sets student first name
    public String getLastName();
    // This method returns student last name
    public void setLastName(String lastName);
    // This method sets student last name
    public void addUnitRecord( IStudentUnitRecord record );
    // This method adds student records
    public IStudentUnitRecord getUnitRecord( String unitCode );
    //This is an abstract method gets student records based on provided student id 
    public StudentUnitRecordList getUnitRecords();
    //This is an abstract method lists student records

}
