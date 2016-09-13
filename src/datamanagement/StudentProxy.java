/*
 
 * Author: Khue Dinh
 * Date: 17/8/2016
 * Version: 1.0
 * Moderator: Jayatunga siriwardana
 * Reader: Shaluka Heshan samarakoon Epitagedara
 * Recorder:
 * Inspector: Wing Kui Tsoi
 * 
 */
package datamanagement;
public class StudentProxy implements IStudent 
{
	
	private Integer id;
	private String fn;
	private String ln;
    private StudentManager sm;
    //this is a constructor of StudentProxy class
    public StudentProxy( Integer id, String fn, String ln) 
    {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
        this.sm = StudentManager.get();
    }
    //this method returns student id
    public Integer getID() { return id;}
    //this method returns student first name
    public String getFirstName() {return fn; }
    //this method returns student last name
    public String getLastName() { return ln;}
    //this method sets student first name
    public void setFirstName(String firstName) 
    {sm.getStudent(id).setFirstName(firstName);}
    //this method sets student last name
    public void setLastName(String lastName) 
    {sm.getStudent(id).setLastName(lastName);}

    //this method adds student unit records according to student id
    public void addUnitRecord(IStudentUnitRecord record) {sm.getStudent(id).addUnitRecord(record);}
    //this method gets student unit record according to student id
    public IStudentUnitRecord getUnitRecord(String unitCode) {return sm.getStudent(id).getUnitRecord(unitCode);}
    //this method gets student unit records according to student id
    public StudentUnitRecordList getUnitRecords() { return sm.getStudent(id).getUnitRecords();}
 
}
