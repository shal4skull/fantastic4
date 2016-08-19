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

public class StudentUnitRecord implements IStudentUnitRecord 
{
	private Integer sid;
	private String uc;
	private float a1, a2, ex;

	//this is an constructor
	public StudentUnitRecord(Integer id, String code, float asg1, float asg2,float exam)
	{
		this.sid = id;
		this.uc = code;
		this.setAsg1(asg1);
		this.setAsg2(asg2);
		this.setExam(exam);
	}
	//this method returns student id
	public Integer getStudentID() 
	{
		return sid;
	}
	//this method returns unit code
	public String getUnitCode() 
	{
		return uc;
	}

	//this method sets mark of assignment 1 if it satisfies assignment 1 weight
	public void setAsg1(float a1) 
	{
		if (a1 < 0 || a1 > UnitManager.UM().getUnit(uc).getAsg1Weight()) 
		{
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment 1 weight");
		}
		this.a1 = a1;
	}
	
	//this function returns assignment 1 mark
	public float getAsg1() 
	{

		return a1;
	}

	//this method sets mark of assignment 2 if it satisfies assignment 2 weight
	public void setAsg2(float a2) 
	{
		if (a2 < 0 || a2 > UnitManager.UM().getUnit(uc).getAsg2Weight()) 
		{
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment 2 weight");
		}
		this.a2 = a2;

	}

	//this function returns assignment 2 mark
	public float getAsg2() 
	{
		return a2;
	}

	//this method sets mark of exam if it satisfies exam weight
	public void setExam(float ex) 
	{
		if (ex < 0 || ex > UnitManager.UM().getUnit(uc).getExamWeight()) 
		{
				throw new RuntimeException("Mark cannot be less than zero or greater than exam weight");
		}
		this.ex = ex;
	}

	//this function returns exam mark
	public float getExam() 
	{
		return ex;
	}

	//this function returns total mark
	public float getTotal() 
	{
		return a1 + a2 + ex;

	}
}
