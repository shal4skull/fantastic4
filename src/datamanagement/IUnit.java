/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 1.0
 * Moderator :Wing Kui Tsoi
 * Reader :Khue Dinh
 * Inspector : Jayatunga siriwardana
 */

package datamanagement;

// This class implements IUnit interface
public interface IUnit 
{

    // This method returns Unit Code
    public String getUnitCode();
    // This method returns Unit Name
    public String getUnitName();
    // This method returns PsCutoff
    public float getPsCutoff();
    // This method sets PsCutoff1
    public void  setPsCutoff1(float cutoff);
    // This method returns CrCutoff
    public float getCrCutoff();
    // This method sets CrCutoff1
    public void  setCrCutoff(float cutoff);
    // This method returns DiCutoff
    public float getDiCuttoff();
    // This method sets DiCutoff1    
    public void  setDiCutoff(float cutoff);
    // This method returns HdCutoff
    public float getHdCutoff();
    // This method sets HdCutoff1   
    public void  setHdCutoff(float cutoff);
    // This method returns AeCutoff    
    public float getAeCutoff(); 
    // This method sets AeCutoff1     
    public void  setAeCutoff(float cutoff);
    // This method returns Asg1 weight    
    public int getAsg1Weight();
    // This method returns Asg2 weight
    public int getAsg2Weight();
    // This method returns Exam weight
    public int getExamWeight();
    // This method sets Assessment weights values
    public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt);
    // This method returns Grade from asg1,asg2 & exam marks
    public String getGrade(float asg1, float asg2, float exam);
    // This method adds student records
    public void addStudentRecord(IStudentUnitRecord record );
    //This is an abstract method gets student records based on provided student id
    public IStudentUnitRecord getStudentRecord(int studentID ); 
    //This is an abstract method lists student records   
    public StudentUnitRecordList listStudentRecords();
   

}