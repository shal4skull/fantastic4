/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 2.0
 * Moderator :Wing Kui Tsoi
 * Reader :Khue Dinh
 * Inspector :Jayatunga siriwardana
 */

package datamanagement;

// This class implements IStudent interface
public interface IStudent
{

    // This method returns student ID
    public Integer getID();
    // This method returns student first name
    public String getFirstName();
    // This method sets student first name
    public void setFirstName(String firstName);
    // This method returns student last name
    public String getLastName();
    // This method sets student last name
    public void setLastName(String lastName);
    // This method adds student records
    public void addUnitRecord( IStudentUnitRecord record );
    //This is an abstract method gets student records based on provided student id
    public IStudentUnitRecord getUnitRecord( String unitCode );
    //This is an abstract method lists student records 
    public StudentUnitRecordList getUnitRecords();
    

}
