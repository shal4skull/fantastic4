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

public interface IStudentUnitRecord 
{
// This class implements IStudentUnitRecord interface

    public Integer getStudentID();
    // This method returns student ID
    public String getUnitCode();
    // This method returns Unit Code
    public void setAsg1(float mark);
    // This method sets Asg1 marks
    public float getAsg1();
    // This method returns Asg1 marks
    public void setAsg2(float mark);
    // This method sets Asg2 marks
    public float getAsg2();
    // This method returns Asg2 marks
    public void setExam(float mark);
    // This method sets Exam marks
    public float getExam();
    // This method returns Exam marks
    public float getTotal();
    // This method returns Total marks

}