/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 1.0
 * Moderator :
 * Reader :
 * Recorder :
 * Inspector :
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
            
     public void listUnits( IUnitLister lister ) 
      {
        lister.clearUnits();UnitMap units = um.getUnits();
        for (String s : units.keySet() )
        lister.addUnit(units.get(s));
       }
}