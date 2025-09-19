package hashmap.implementation;

import java.util.HashMap;

import com.mendix.systemwideinterfaces.core.IMendixIdentifier;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Helper for MxHashMapImpl: this contains a hashmap (in memory) of all instantiated hashmaps, that can be accessed through the MxHashMap object identifier (GUID)
 * @author mkrouwel 19Feb2025
 *
 */
public class MxHashMapHelper {
	private static HashMap<IMendixIdentifier, MxHashMapImpl> hashmaps = new HashMap<IMendixIdentifier, MxHashMapImpl>();
	
	public static void initializeHashMap(IMendixObject map, String entityType) {
		hashmaps.put(map.getId(), new MxHashMapImpl(entityType, new HashMap<String, IMendixObject>()));
	}
	
	public static MxHashMapImpl getHashMap(IMendixObject map) {
		return hashmaps.get(map.getId());
	}
	
	public static void removeHashMap(IMendixObject map) {
		hashmaps.remove(map.getId());
	}
}