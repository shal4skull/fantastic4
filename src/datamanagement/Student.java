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

// This class implements IStudent interface 
public class Student implements IStudent {
    // Initiate Student ID, First Name, Last Name, Student Unit Record List
	private Integer id; 
    private String fn;
    private String ln;
    private StudentUnitRecordList su;

    //Initiate constructor
    public Student( Integer id, String fn, String ln, StudentUnitRecordList su ) { 
    	this.id = id;
    	this.fn = fn;
        this.ln = ln;
        this.su = 
        su == null ? new StudentUnitRecordList() : su;
    }
    //this method returns student id
    public Integer getID() { return this.id; } 
    //this method returns student first name
    public String getFirstName() { return fn; }
    //this method sets student first name
    public void setFirstName( String firstName ) { this.fn = firstName; }
    //this method return student last name
    public String getLastName() { return ln; }
    //this method sets student last name
    public void setLastName( String lastName ) { this.ln = lastName; }
   /* this method adds student id, unit code, assignment 1 mark, assignment 2 mark,
    assignment 3 mark, exam mark and total mark into a list*/
    public void addUnitRecord( IStudentUnitRecord record ) { su.add(record); }
    /*//this method overrides getUnitmethod in the IStudentUnitRecord interface
    // and returns IStudentUnitRecord */ 
    public IStudentUnitRecord getUnitRecord( String unitCode ) {
        	for ( IStudentUnitRecord r : su ) 
        		if ( r.getUnitCode().equals(unitCode)) 
        			return r; 

        			return null;
        
        }
    //this method returns a list of IStudentUnitRecord
    public StudentUnitRecordList getUnitRecords() { return su; }
}
