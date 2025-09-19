package hashmap.implementation;

import java.util.HashMap;

import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Actual implementation of the Mendix hashmap: combination of a Java hashmap (key=string, value=IMendixObject) and the Mendix object type (String)
 * @author mkrouwel 19Feb2025
 *
 */
public class MxHashMapImpl {
	private String dataType;
	private HashMap<String, IMendixObject> map;
	
	public MxHashMapImpl(String dataType, HashMap<String, IMendixObject> map) {
		this.dataType = dataType;
		this.map = map;
	}
	
	public String getType()  {
		return this.dataType;
	}
	
	public HashMap<String, IMendixObject> getMap() {
		return this.map;
	}
}
