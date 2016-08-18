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
    // This method adds student recods
    public IStudentUnitRecord getUnitRecord( String unitCode );
    //This method overrides getunitmethod in the istudentUnitRecord interface and returns IStudentUnitRecord
    public StudentUnitRecordList getUnitRecords();
    //This methodreturns a list of IstudentUnitRecord

}
