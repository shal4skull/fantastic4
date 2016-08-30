/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 2.0
 * Moderator :Wing Kui Tsoi
 * Reader :Khue Dinh
 * Inspector :Jayatunga siriwardana
 */

package datamanagement;

// This interface provides abstract methods for IStudentUnitRecord interface
public interface IStudentUnitRecord 
{

    // This method returns student ID
    public Integer getStudentID();
    // This method returns Unit Code
    public String getUnitCode();
    // This method sets Asg1 marks
    public void setAsg1(float mark);
    // This method returns Asg1 marks
    public float getAsg1();
    // This method sets Asg2 marks
    public void setAsg2(float mark);
    // This method returns Asg2 marks
    public float getAsg2();
    // This method sets Exam marks
    public void setExam(float mark);
    // This method returns Exam marks
    public float getExam();
    // This method returns Total marks
    public float getTotal();
    

}