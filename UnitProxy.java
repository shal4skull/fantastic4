/*
 
 * Author: Tsoi Wing Kui
 * Date: 26/8/2016
 * Version: 1.1
 * Moderator: Khue Dinh
 * Reader: Jayatunga siriwardana
 * Inspector: Shaluka Heshan samarakoon Epitagedara
 
*/

package datamanagement;

public class UnitProxy implements IUnit {
	
	//Initiates variables.
	private String UC;
	private String un;
	UnitManager   um;
	
	//Creates a constructor.
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
	
	//These methods are academic result functions.
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
	
	//This is a get-grade function.
	public String getGrade(float f1, float f2, float f3) {
		return um.getUnit(UC).getGrade(f1, f2, f3);
	}
	
	//This is a student record function.
	public void addStudentRecord(IStudentUnitRecord record) { 
		um.getUnit(UC).addStudentRecord(record);
	}
	
	//This is a student record report function.
	public IStudentUnitRecord getStudentRecord(int s) {
		return um.getUnit(UC).getStudentRecord(s);
	}
	
	//This is a student record list function.
	public StudentUnitRecordList listStudentRecords() {
		return um.getUnit(UC).listStudentRecords();
	}
	
	//Theses are assignment and exam weight functions.
	public int getAsg1Weight() {
		return um.getUnit(UC).getAsg1Weight();
	}
	public int getAsg2Weight() {
		return um.getUnit(UC).getAsg2Weight();
	}
	public int getExamWeight() {
		return um.getUnit(UC).getExamWeight();
	}
	
	//This is an assignment and exam weight operation.
	public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt) {
		um.getUnit(UC).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);
	}
}