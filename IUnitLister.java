/*
 * Author: Shaluka Samarakoon
 * Date : 17/8/2016
 * Version : 1.0
 * Moderator :Wing Kui Tsoi
 * Reader :Khue Dinh
 * Inspector : Jayatunga siriwardana
 */

package datamanagement;

// This class implements IUnitLister interface
public interface IUnitLister 
{

    // This method clear all previous Units records
    public void clearUnits();
    // This method adds Units recods
    public void addUnit(IUnit unit);
    

}
