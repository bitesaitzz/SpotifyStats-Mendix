package hashmaputil.implementation;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

import com.mendix.systemwideinterfaces.core.IMendixObject;

public class HashMapUtil {
	static ThreadLocal<Map<String, Map<String, IMendixObject>>> localContentMaps = new ThreadLocal<Map<String, Map<String, IMendixObject>>>();
	static Map<String, Map<String, IMendixObject>> staticContentMaps = new ConcurrentHashMap<String, Map<String, IMendixObject>>();

	private static Map<String, Map<String, IMendixObject>> getLocalContentMaps() {
		if (localContentMaps.get() == null) {
			localContentMaps.set(new WeakHashMap<String, Map<String, IMendixObject>>());
		}
		return localContentMaps.get();
	}

	public static void putLocalContentMap(String handle, Map<String, IMendixObject> contentMap) {
		getLocalContentMaps().put(handle, contentMap);
	}

	public static void putStaticContentMap(String handle, Map<String, IMendixObject> contentMap) {
		staticContentMaps.put(handle, contentMap);
	}

	public static Map<String, IMendixObject> getContentMap(String handle) {
		Map<String, IMendixObject> contentMap = getLocalContentMaps().get(handle);
		if (contentMap != null) {
			return contentMap;
		} else {
			contentMap = staticContentMaps.get(handle);
			return contentMap;
		}
	}

	public static void removeContentMap(String handle) {
		getLocalContentMaps().remove(handle);
		staticContentMaps.remove(handle);
	}


	// For HashSet functions
	static ThreadLocal<Map<String, Set<IMendixObject>>> contentSets = new ThreadLocal<Map<String, Set<IMendixObject>>>();

	private static Map<String, Set<IMendixObject>> getContentSets() {
		if (contentSets.get() == null) {
			contentSets.set(new WeakHashMap<String, Set<IMendixObject>>());
		}
		return contentSets.get();
	}

	public static void putContentSet(String handle, Set<IMendixObject> contentSet) {
		getContentSets().put(handle, contentSet);
	}

	public static Set<IMendixObject> getContentSet(String handle) {
		Set<IMendixObject> contentSet = getContentSets().get(handle);
		return contentSet;
	}

	public static void removeContentSet(String handle) {
		getContentSets().remove(handle);
	}

}
