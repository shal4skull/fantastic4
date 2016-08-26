/*
 
 * Author: Tsoi Wing Kui
 * Date: 26/8/2016
 * Version: 1.1
 * Moderator: Khue Dinh
 * Reader: Jayatunga siriwardana
 * Inspector: Shaluka Heshan samarakoon Epitagedara
 
*/

package datamanagement;

import java.util.List;
import org.jdom.*;

public class UnitManager {
	
	//Initiates variables.
	private static UnitManager self = null;
	private UnitMap UM;
	
	//Starts running of UnitManager.
	public static UnitManager UM() {
		if (self == null)self = new UnitManager();
		return self;
	}
	
	//Calls UnitMap class.
	private UnitManager() {
		UM = new UnitMap();
	}
	
	//Creates a new unit.
	public IUnit getUnit(String uc) {
		IUnit iu = UM.get(uc);
		return iu != null ? iu : createUnit(uc);
	}
	
	//Lists units and their documents.
	private IUnit createUnit(String unitCode) {
		IUnit iu;
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("unitTable").getChildren("unit"))
			if (unitCode.equals(el.getAttributeValue("uid"))) {
				StudentUnitRecordList slist;
				slist = null;
				iu = new Unit(el.getAttributeValue("uid"),
					el.getAttributeValue("name"), Float.valueOf(
					el.getAttributeValue("ps")).floatValue(), Float
					.valueOf(el.getAttributeValue("cr"))
					.floatValue(), Float.valueOf(
					el.getAttributeValue("di")).floatValue(), Float
					.valueOf(el.getAttributeValue("hd"))
					.floatValue(), Float.valueOf(
					el.getAttributeValue("ae")).floatValue(),
					Integer.valueOf(el.getAttributeValue("asg1wgt"))
					.intValue(), Integer.valueOf(
					el.getAttributeValue("asg2wgt")).intValue(),
					Integer.valueOf(el.getAttributeValue("examwgt"))
					.intValue(), StudentUnitRecordManager
					.instance().getRecordsByUnit(unitCode));
				UM.put(iu.getUnitCode(), iu);
				return iu;
			}
		throw new RuntimeException("DBMD: createUnit : unit not in file");
	}

	//Gets units for UnitMap (data structure).
	public UnitMap getUnits() {
		UnitMap uM;
		IUnit iu;
		uM = new UnitMap();
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("unitTable").getChildren("unit")) {
			iu = new UnitProxy(el.getAttributeValue("uid"),
					el.getAttributeValue("name"));
			uM.put(iu.getUnitCode(), iu);
		} // unit maps are filled with PROXY units
		return uM;
	}
}