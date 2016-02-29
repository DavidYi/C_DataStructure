package interfaces.bca.util;

/**
 * An object that maps keys to values. A map cannot contain duplicate keys; each
 * key can map to at most one value.
 *
 * <p>
 * While some java.util.Map implementations permit null keys and/or values, for BCAMap the
 * key and value must be non-null. Attempting to insert a null key or value will
 * result in a <tt>NullPointerException</tt>.
 */
public interface BCAMap {
	/**
	 * Returns the number of key-value mappings in this map.
	 *
	 * @return the number of key-value mappings in this map
	 */
	int size();

	/**
	 * Returns <tt>true</tt> if this map contains no key-value mappings.
	 *
	 * @return <tt>true</tt> if this map contains no key-value mappings
	 */
	boolean isEmpty();

	/**
	 * Returns <tt>true</tt> if this map contains a mapping for the specified
	 * key.
	 *
	 * @param key
	 *            key whose presence in this map is to be tested
	 * @return <tt>true</tt> if this map contains a mapping for the specified
	 *         key
	 * @throws NullPointerException
	 *             if the specified key is null.
	 */
	boolean containsKey(String key);

	/**
	 * Returns <tt>true</tt> if this map maps one or more keys to the specified
	 * value.
	 * 
	 * @param value
	 *            value whose presence in this map is to be tested
	 * @return <tt>true</tt> if this map maps one or more keys to the specified
	 *         value
	 * @throws NullPointerException
	 *             if the specified value is null.
	 */
	boolean containsValue(Object value);

	/**
	 * Returns the value to which the specified key is mapped.
	 * 
	 * @param key
	 *            the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped
	 * @throws NullPointerException
	 *             if the specified key is null.
	 */
	Object get(String key);

	/**
	 * Returns the value to which the specified key is mapped. Or the
	 * defaultValue if the key is not already in the map.
	 * 
	 * @param key
	 *            the key whose associated value is to be returned
	 * @param defaultValue
	 *            the value to return if the key is not in the map.
	 * @return the value to which the specified key is mapped or the
	 *         defaultValue
	 * @throws NullPointerException
	 *             if the specified key is null.
	 */
	Object getOrDefault(String key, Object defaultValue);

	/**
	 * Associates the specified value with the specified key in this map. If the
	 * map previously contained a mapping for the key, the old value is replaced
	 * by the specified value.
	 * 
	 * @param key
	 *            key with which the specified value is to be associated
	 * @param value
	 *            value to be associated with the specified key
	 * @return the previous value associated with <tt>key</tt>, or <tt>null</tt>
	 *         if there was no mapping for <tt>key</tt>.
	 * @throws NullPointerException
	 *             if the specified key or value is null.
	 */
	Object put(String key, Object value);

	/**
	 * Removes the mapping for a key from this map if it is present.
	 *
	 * <p>
	 * Returns the value to which this map previously associated the key, or
	 * <tt>null</tt> if the map contained no mapping for the key.
	 *
	 * @param key
	 *            key whose mapping is to be removed from the map
	 * @return the previous value associated with <tt>key</tt>, or <tt>null</tt>
	 *         if there was no mapping for <tt>key</tt>.
	 * @throws NullPointerException
	 *             if the specified key is null.
	 */
	Object remove(String key);

	/**
	 * Removes all of the mappings from this map.
	 */
	void clear();

	/** 
	 * Returns an array containing the current key,value pairs in the map.
	 */
	BCAEntry[] toArray();

	/** 
	 * Returns an array containing the keys in the map.
	 */
	String[] keys();

	/** 
	 * Returns an array containing the values in the map.
	 */
	Object[] values();
}
