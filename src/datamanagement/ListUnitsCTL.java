/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 1.0
 * Moderator :Wing Kui Tsoi
 * Reader :Khue Dinh
 * Inspector : Jayatunga siriwardana
 */

package datamanagement;

public class ListUnitsCTL 
{
// Creating a class as ListUnitCTL

    private UnitManager um;
    //Declaring Unit Manager as um
    public ListUnitsCTL() 
     {
       um = UnitManager.UM();
      }
     //This method gets the list of units     
     public void listUnits( IUnitLister lister ) 
      {
        lister.clearUnits();
        UnitMap units = um.getUnits();
        for (String s : units.keySet() )
        	lister.addUnit(units.get(s));
       }
}