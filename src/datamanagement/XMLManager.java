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

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import java.io.FileWriter;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.IOException;
import org.jdom.JDOMException;

/*Class that handles all the operation of 
creating, editing and saving documents.*/
public class XMLManager {
	
	//Initiates variables.
	private static XMLManager self = null;
	private Document doc;
	
	//Creates a new document.
	public static XMLManager getXML() {
		if (self == null) self = new XMLManager();
		return self;
	}
		
	//XMLManager function as a class constructor.
	private XMLManager() {
		init();
	}

	//Method declaration for initiating a new file.
	public void init() {
		String s = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
		//Prevents program crush when exceptions (system error) occur.
		try {
			SAXBuilder b = new SAXBuilder();
			b.setExpandEntities(true);
			doc = b.build(s);
		}
		catch (JDOMException e) {
			System.err.printf( "%s", "DBMD: XMLManager : init : caught JDOMException\n" );
			throw new RuntimeException("DBMD: XMLManager : init : JDOMException");
		} 
		catch (IOException e) {
			System.err.printf( "%s", "DBMD: XMLManager : init : caught IOException\n" );
			throw new RuntimeException("DBMD: XMLManager : init : IOException");
		}  
	}
    
	//Gets the document that sourced the change event.
	public Document getDocument() {
		return doc;
	}

	//Document saving function.
	public void saveDocument() {
		String xmlfile = AppProperties.getInstance().getProperties().getProperty("XMLFILE");
		//Saving file format.
		try (FileWriter fout = new FileWriter(xmlfile)) {
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
			outputter.output(doc, fout);
			fout.close();
		}
		catch (IOException ioe) {
			System.err.printf( "%s\n", "DBMD : XMLManager : saveDocument : Error saving XML to " + xmlfile);
			throw new RuntimeException("DBMD: XMLManager : saveDocument : error writing to file");
		}
	}
}