/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 1.0
 * Moderator :Wing Kui Tsoi
 * Reader :Khue Dinh
 * Inspector : Jayatunga siriwardana
 */

package datamanagement;

public interface IUnit 
{
// This class implements IUnit interface

    public String getUnitCode();
    // This method returns Unit Code
    public String getUnitName();
    // This method returns Unit Name
    public float getPsCutoff();
    // This method returns PsCutoff
    public void  setPsCutoff1(float cutoff);
    // This method sets PsCutoff1
    public float getCrCutoff();
    // This method returns CrCutoff
    public void  setCrCutoff(float cutoff);
    // This method sets CrCutoff1
    public float getDiCuttoff();
    // This method returns DiCutoff    
    public void  setDiCutoff(float cutoff);
    // This method sets DiCutoff1
    public float getHdCutoff();
    // This method returns HdCutoff   
    public void  setHdCutoff(float cutoff);
    // This method sets HdCutoff1    
    public float getAeCutoff(); 
    // This method returns AeCutoff     
    public void  setAeCutoff(float cutoff);
    // This method sets AeCutoff1    
    public int getAsg1Weight();
    // This method returns Asg1 weight
    public int getAsg2Weight();
    // This method returns Asg2 weight
    public int getExamWeight();
    // This method returns Exam weight
    public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt);
    // This method sets Assessment weights values
    public String getGrade(float asg1, float asg2, float exam);
    // This method returns Grade from asg1,asg2 & exam marks
    public void addStudentRecord(IStudentUnitRecord record );
    // This method adds student records
    public IStudentUnitRecord getStudentRecord(int studentID ); 
    //This is an abstract method gets student records based on provided student id   
    public StudentUnitRecordList listStudentRecords();
   //This is an abstract method lists student records

}