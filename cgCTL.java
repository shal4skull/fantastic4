/*
 
 * Author: jayatunga Siriwardana
 * Date: 21/8/2016
 * Version: 
 * Moderator:
 * Reader:
 * Recorder:
 * Inspector:
 * 
 */




package datamanagement;

public class cgCTL {

	cgUI CGUI;
	String cuc = null;
	Integer currentStudentID = null;
	boolean changed = false;

	public cgCTL() {
	}

	public void execute() {
		CGUI = new cgUI(this);
		CGUI.setState1(false);

		CGUI.setState2(false);
		CGUI.setState3(false);
		CGUI.setState4(false);
		CGUI.setState5(false);
		CGUI.setState6(false);
		CGUI.Refresh3();

		ListUnitsCTL luCTL = new ListUnitsCTL();
		luCTL.listUnits(CGUI);
		CGUI.setVisible(true);
		CGUI.setState1(true);
	}

	public void unitSelected(String code) {
		//if code equal NONE set state2 to false
		if (code.equals("NONE"))
			CGUI.setState2(false);
		else {
			//create ListStudentsCTL object
			ListStudentsCTL lsCTL = new ListStudentsCTL(); 
			lsCTL.listStudents(CGUI, code);
			cuc = code;
			CGUI.setState2(true);
		}
		CGUI.setState3(false);
	}

	public void studentSelected(Integer id) {
		currentStudentID = id; 
		//assign id value to currentStudentID
		//check CurrentStudentID 0 or not
		if (currentStudentID.intValue() == 0) {
			CGUI.Refresh3();
			CGUI.setState3(false);
			CGUI.setState4(false);
			CGUI.setState5(false);
			CGUI.setState6(false);
		}

		else {
			//get Student by ID
			IStudent s = StudentManager.get().getStudent(id); 

			IStudentUnitRecord r = s.getUnitRecord(cuc);

			CGUI.setRecord(r);
			CGUI.setState3(true);
			CGUI.setState4(true);
			CGUI.setState5(false);
			CGUI.setState6(false);
			changed = false;

		}
	}

	//Check the grade of the student	
	public String checkGrade(float f, float g, float h) {
		IUnit u = UnitManager.UM().getUnit(cuc);
		String s = u.getGrade(f, g, h);
		CGUI.setState4(true);
		CGUI.setState5(false);
		if (changed) {
			CGUI.setState6(true);
		}
		return s;
	}

	public void enableChangeMarks() {
		CGUI.setState4(false);
		CGUI.setState6(false);
		CGUI.setState5(true);
		changed = true;
	}
	//Save the student grades
	public void saveGrade(float asg1, float asg2, float exam) {

		IUnit u = UnitManager.UM().getUnit(cuc);
		IStudent s = StudentManager.get().getStudent(currentStudentID);

		IStudentUnitRecord r = s.getUnitRecord(cuc);
		r.setAsg1(asg1);
		r.setAsg2(asg2);
		r.setExam(exam);
		StudentUnitRecordManager.instance().saveRecord(r);
		CGUI.setState4(true);
		CGUI.setState5(false);
		CGUI.setState6(false);
	}
}
