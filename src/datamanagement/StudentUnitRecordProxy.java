/*
 
 * Author: Khue Dinh
 * Date: 17/8/2016
 * Version: 1.0
 * Moderator:
 * Reader:
 * Recorder:
 * Inspector:
 * 
 */
package datamanagement;
public class StudentUnitRecordProxy implements IStudentUnitRecord 
{
	

	private Integer studentID;

	private String unitCode;

	private StudentUnitRecordManager mngr;

	//this is a constructor
	public StudentUnitRecordProxy( Integer id, String code ) 
	{
		this.studentID = id;
		this.unitCode = code;
		this.mngr = StudentUnitRecordManager.instance();
		
	}
	
	//this method gets student id
	public Integer getStudentID() { return studentID;}

	///this method gets unit code
	public String getUnitCode() { return unitCode;}

	//this method sets assignment 1 mark
	public void setAsg1(float mark) {mngr.getStudentUnitRecord( studentID, unitCode ).setAsg1(mark);}

	//this function gets assignment 1 mark
	public float getAsg1() 
	{
		return mngr.getStudentUnitRecord( studentID, unitCode ).getAsg1();
		
	}

	//this method sets assignment 2 mark
	public void setAsg2(float mark) { mngr.getStudentUnitRecord( studentID, unitCode ).setAsg2(mark);}

	//this function gets assignment 2 mark
	public float getAsg2() {return mngr.getStudentUnitRecord( studentID, unitCode ).getAsg2();}

	//this method sets exam mark
	public void setExam(float mark) {mngr.getStudentUnitRecord( studentID, unitCode ).setExam(mark);}

	//this function gets exam mark
	public float getExam(){return mngr.getStudentUnitRecord( studentID, unitCode ).getExam();}

	//this function gets total mark
	public float getTotal() {return mngr.getStudentUnitRecord( studentID, unitCode ).getTotal();}
	
}
