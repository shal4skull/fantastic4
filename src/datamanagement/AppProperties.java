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
import java.util.*;
import java.io.*;
//making singleton class of AppProperties
public class AppProperties {
private static AppProperties self = null;
private Properties properties;

public static AppProperties getInstance() {
	//if AppProperties null create new AppProperties Object
if (self == null ) { self = new AppProperties(); } return self;}
//make AppProperties constructor private
private AppProperties() {properties = new Properties(); //Create  Properties object
try {
	//load properties file using FileInputStream
	properties.load(new FileInputStream("Properties.prop"));}
catch (IOException e)
//if IOException happened throw new RuntimeExeception
{throw new RuntimeException("Could not read property file");}}
   //create public method to return properties
   public Properties getProperties() {return properties;
}}
