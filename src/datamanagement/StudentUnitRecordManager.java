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

import java.util.List;
import org.jdom.*;

public class StudentUnitRecordManager 
{

	private static StudentUnitRecordManager s = null;
    private StudentUnitRecordMap rm;
    private java.util.HashMap<String,StudentUnitRecordList> ur;
    private java.util.HashMap<Integer,StudentUnitRecordList> sr;
    
    //this method checks student unit record existing or not
    public static StudentUnitRecordManager instance() 
    {
        if (s == null ) 
        	s = new StudentUnitRecordManager(); 
        return s;
    }
    
    //this is an constructor
    private StudentUnitRecordManager() 
    {
        rm = new StudentUnitRecordMap();
	    ur = new java.util.HashMap<>();
	    sr = new java.util.HashMap<>();
	}
    
    //this method gets record of student according to provided unit code
    public IStudentUnitRecord getStudentUnitRecord( Integer studentID, String unitCode )
    {
    	IStudentUnitRecord ir = rm.get(studentID.toString()+unitCode);
    	return ir != null ? ir : createStudentUnitRecord(studentID, unitCode);
    }

    //this method creates unit records for existing students
    private IStudentUnitRecord createStudentUnitRecord( Integer sid, String uid ) 
    {
        IStudentUnitRecord ir;
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) 
        {
        	if (sid.toString().equals(el.getAttributeValue("sid")) && uid.equals(el.getAttributeValue("uid"))) 
        	{
                ir = new StudentUnitRecord( new Integer(el.getAttributeValue("sid")),el.getAttributeValue("uid"),new Float(el.getAttributeValue("asg1")).floatValue(),new Float(el.getAttributeValue("asg2")).floatValue(),new Float(el.getAttributeValue("exam")).floatValue() );
                rm.put(ir.getStudentID().toString()+ir.getUnitCode(), ir);
                return ir;
        	}
        }
        throw new RuntimeException("DBMD: createStudent : student unit record not in file");
    }
    
    //this method gets student record based on unit code
    public StudentUnitRecordList getRecordsByUnit( String unitCode ) 
    {
        StudentUnitRecordList recs = ur.get(unitCode);
        if ( recs != null ) 
        	return recs; 
        recs = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) 
        {
        	if (unitCode.equals(el.getAttributeValue("uid"))) 
        		recs.add(new StudentUnitRecordProxy( new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid")));
        }
        if ( recs.size() > 0 ) 
            ur.put(unitCode, recs); // be careful - this could be empty
        return recs;
    }


    //this method gets student record list based on student id
    public StudentUnitRecordList getRecordsByStudent( Integer studentID ) 
    {
    	
    	StudentUnitRecordList recs = sr.get(studentID);
    	if ( recs != null ) return recs; 
    	recs = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) 
            if (studentID.toString().equals(el.getAttributeValue("sid"))) 
                recs.add(new StudentUnitRecordProxy( new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid")));
        if ( recs.size() > 0 ) 
            sr.put(studentID, recs); // be careful - this could be empty
        return recs;
    }

    ///this method save new records into XML file
    public void saveRecord( IStudentUnitRecord irec ) 
    {
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) 
        {
            if (irec.getStudentID().toString().equals(el.getAttributeValue("sid")) && irec.getUnitCode().equals(el.getAttributeValue("uid")))
            {
                el.setAttribute("asg1", new Float(irec.getAsg1()).toString());
                el.setAttribute("asg2", new Float(irec.getAsg2()).toString());
                el.setAttribute("exam", new Float(irec.getExam()).toString());
                XMLManager.getXML().saveDocument(); //write out the XML file for continuous save
                return;
            }
            
        }
        
        
     throw new RuntimeException("DBMD: saveRecord : no such student record in data");
     
    }
    
}
