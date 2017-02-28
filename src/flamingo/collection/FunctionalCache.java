/*
 * +----------------------------------------------------------------------+
 * | Flamingo Library                                                     |
 * +----------------------------------------------------------------------+
 * | Copyright (c) 2017 Flamingo Group                                    |
 * +----------------------------------------------------------------------+
 * | Licensed under the Apache License, Version 2.0 (the "License");      |
 * | you may not use this file except in compliance with the License.     |
 * | You may obtain a copy of the License at                              |
 * |                                                                      |
 * |	http://www.apache.org/licenses/LICENSE-2.0                        |
 * |                                                                      |
 * | Unless required by applicable law or agreed to in writing, software  |
 * | distributed under the License is distributed on an "AS IS" BASIS,    |
 * | WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or      |
 * | impled. See the License for the specific language governing          |
 * | permissions and limitations under the License.                       |
 * +----------------------------------------------------------------------+
 * | Authors: bearsoft <bearsoft5@hotmail.com>                            |
 * +----------------------------------------------------------------------+
 */
package flamingo.collection;

public class FunctionalCache {

	private String cache = "";
	
	/**
	 * <pre>This method add (key) and (value) to cache.
	 * <strong>This method check if the (key) exists in cache,
	 * And if the key exists update the value.</strong>
	 * </pre>
	 * @param key - the key.
	 * @param value - the value.
	 */
	public void add(String key, Object value) {
		// This condition check if the (key) exists in cache.
		if (containsKey(key)) {
			// test1=1} test2=2
			
			int index = cache.indexOf(key);
			int valueStart = index + key.length() + 1;
			int valueEnd = 0;
			int len = cache.length();
			
			for (int i = valueStart; i < len; i++) {
				if (cache.charAt(i) == '}') {
					valueEnd = i;
					break;
				} else {
					valueEnd = len;
				}
			}
			
			this.cache = this.cache.substring(0, valueStart) + value + this.cache.substring(valueEnd, len);
		} else {
			// This part represents if the cache don't have the (key) in cache.
			if (cache.length() == 0) {
				this.cache += key + "=" + value;
			} else {
				this.cache += "} " + key + "=" + value;
			}
		}
	}
	
	/**
	 * <pre>This method remove the key and value of cache.</pre>
	 * @param key - the key.
	 */
	public void remove(String key) {
		// This condition check if the key exists in cache.
		if (cache.indexOf(key) == -1) return;
		
		int valueStart = cache.indexOf(key);
		int len = cache.length();
		int valueEnd = 0;
		
		for (int i = valueStart; i < len; i++) {
			if (cache.charAt(i) == '}') {
				valueEnd = i;
				break;
			} else {
				valueEnd = len;
			}
		}
		
		this.cache = cache.substring(valueEnd + 2);
	}
	
	/**
	 * <pre>This method get value of key, if the key don't exists,
	 * return (null), otherwise return the value.</pre>
	 * @param key - the key.
	 * @return - Return the value of key.
	 */
	public Object get(String key) {
		int indexKey = cache.indexOf(key);
		
		// This condition check if the key exists.
		// If the key exists (indexKey >= 0), otherwise
		// If the key isn't exists (indexKey == -1).
		if (indexKey == -1) return null;
		
		int valueStart = indexKey + key.length() + 1;
		int valueEnd = 0;
		int len = cache.length();
		
		for (int i = valueStart; i < len; i++) {
			if (cache.charAt(i) == '}') {
				valueEnd = i;
				break;
			} else {
				valueEnd = cache.length();
			}
		}
		
		return cache.substring(valueStart, valueEnd);
	}
	
	/**
	 * <pre>This method check if the cache contains the key <i>key</i>.</pre>
	 * @param key - the key.
	 * @return - Returns (true) if the cache contains key, otherwise return (false).
	 */
	public boolean containsKey(String key) {
		return this.cache.indexOf(key) > -1;
	}
	
	/**
	 * <pre>This method return the size of cache.</pre>
	 * @return - Returns the size of cache.
	 */
	public int size() {
		int j = 0;
		int len = cache.length();
		
		for (int i = 0; i < len; i++) {
			if (cache.charAt(i) == '}') {
				j++;
			}
		}
		
		return j + 1;
	}
	
	/**
	 * <pre>This method clear cache.</pre>
	 */
	public void clear() {
		this.cache = "";
	}
	
	/**
	 * <pre>This method return the cache.</pre>
	 * @return - Returns the cache.
	 */
	public String cache() {
		return cache;
	}
}
