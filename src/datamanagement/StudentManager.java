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

import org.jdom.*;
import java.util.List;

public class StudentManager {
	//declare a StudentManager object that has a null value
    private static StudentManager self = null;
    //declare a variable with StudentMap type
    private StudentMap sm;
    //declare a variable with HashMap type
    private java.util.HashMap<String, StudentMap> um;
    
    //initiate a new StudentManager object if it is null
    public static StudentManager get() 
    {
        if (self == null) 
            self = new StudentManager();
        return self; 
    }
    //default constructor
    private StudentManager() 
    {
        sm = new StudentMap();
        um = new java.util.HashMap<>();
    }
        
    //this method checks student id is null or not and returns IStudent object
    public IStudent getStudent(Integer id) 
    {
    	IStudent is = sm.get(id);
    	return is != null ? is : createStudent(id);
    }
    
    //this method gets student id from DataManagementDemo_DB.xml file
    private Element getStudentElement(Integer id) 
    {
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentTable").getChildren("student")) 
            if (id.toString().equals(el.getAttributeValue("sid"))) 
            	return el;
        return null;
    }
    
    //this method returns student information including id, first name, last name, records
    //otherwise return a run time exception
    private IStudent createStudent(Integer id) 
    {
        IStudent is;
        Element el = getStudentElement(id);
        if (el != null) 
        {
            StudentUnitRecordList rlist = StudentUnitRecordManager.instance().getRecordsByStudent(id);
            is = new Student(new Integer(el.getAttributeValue("sid")),el.getAttributeValue("fname"),el.getAttributeValue("lname"),rlist);
            sm.put(is.getID(), is);
            return is; 
        }
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }
    
    //this method returns student proxy including id, first name, last name
    //otherwise return a run time exception
    private IStudent createStudentProxy(Integer id) 
    {
        Element el = getStudentElement(id);
        
        if (el != null) 
        	return new StudentProxy(id, el.getAttributeValue("fname"), el.getAttributeValue("lname"));
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }
    
    //this method returns a list of students by chosen unit
    public StudentMap getStudentsByUnit(String uc)
    {
        StudentMap s = um.get(uc);
        if (s != null) 
        {
 
        	return s;
        }

        s = new StudentMap();
        IStudent is;
        StudentUnitRecordList ur = StudentUnitRecordManager.instance().getRecordsByUnit(uc);
        for (IStudentUnitRecord S : ur)
        {
           is = createStudentProxy(new Integer(S.getStudentID()));
           s.put(is.getID(), is);
        }
        um.put( uc, s);
        return s;
    }
}
