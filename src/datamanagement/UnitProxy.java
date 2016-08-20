/*
 
 * Author: Tsoi Wing Kui
 * Date: 20/8/2016
 * Version: 1.0
 * Moderator:
 * Reader:
 * Recorder:
 * Inspector:
  
 */

package datamanagement;

public class UnitProxy implements IUnit {
	
	//Initiates variables.
	private String UC;
	private String un;
	UnitManager   um;
	
	//Constructor.
	public UnitProxy( String unitCode, String unitName ) {
		this.UC = unitCode;
		this.un = unitName;
		um = UnitManager.UM(); 
	}
	
	//This method returns UC.
	public String getUnitCode() { 
		return this.UC;
	}
	
	//This method returns un.
	public String getUnitName() { 
		return this.un; 
	}
	
	//Academic result functions.
	public void setPsCutoff1(float cutoff) {
		um.getUnit(UC).setPsCutoff1(cutoff);
	}
	public float getPsCutoff() {
		return um.getUnit(UC).getPsCutoff();
	}
	public void setCrCutoff(float cutoff) {
		um.getUnit(UC).setCrCutoff(cutoff);
	}
	public float getCrCutoff() {
		return um.getUnit(UC).getCrCutoff();
	}
	public void setDiCutoff(float cutoff) {
		um.getUnit(UC).setDiCutoff(cutoff);
	}
	public float getDiCuttoff() {
		return um.getUnit(UC).getDiCuttoff();
	}
	public void setHdCutoff(float cutoff) {
		um.getUnit(UC).setHdCutoff(cutoff);
	}
	public float getHdCutoff() {
		return um.getUnit(UC).getHdCutoff();
	}
	public void setAeCutoff(float cutoff) {
		um.getUnit(UC).setAeCutoff(cutoff);
	}
	public float getAeCutoff() {
		return um.getUnit(UC).getAeCutoff();
	}
	
	//Get grade function.
	public String getGrade(float f1, float f2, float f3) {
		return um.getUnit(UC).getGrade(f1, f2, f3);
	}
	
	//Student record function.
	public void addStudentRecord(IStudentUnitRecord record) { 
		um.getUnit(UC).addStudentRecord(record);
	}
	
	//Student record report function.
	public IStudentUnitRecord getStudentRecord(int s) {
		return um.getUnit(UC).getStudentRecord(s);
	}
	
	//Student record list function.
	public StudentUnitRecordList listStudentRecords() {
		return um.getUnit(UC).listStudentRecords();
	}
	
	//Assignment and exam weight function.
	public int getAsg1Weight() {
		return um.getUnit(UC).getAsg1Weight();
	}
	public int getAsg2Weight() {
		return um.getUnit(UC).getAsg2Weight();
	}
	public int getExamWeight() {
		return um.getUnit(UC).getExamWeight();
	}
	
	//Assignment and exam weight operation.
	public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt) {
		um.getUnit(UC).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);
	}
}