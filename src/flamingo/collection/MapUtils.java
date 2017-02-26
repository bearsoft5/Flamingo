/*
 * +----------------------------------------------------------------------+
 * | Flamingo Library                                                     |
 * +----------------------------------------------------------------------+
 * | Copyright (c) 2017 Flamingo Group                                    |
 * +----------------------------------------------------------------------+
 * | Licensed under the Apache License, Version 2.0 (the "License");      |
 * | you may not use this file except in compliance with the License.     |
 * | You may obtain a copy of the License at  							  |
 * |																      |
 * |	http://www.apache.org/licenses/LICENSE-2.0						  |
 * | 																	  |
 * | Unless required by applicable law or agreed to in writing, software  |
 * | distributed under the License is distributed on an "AS IS" BASIS,    |
 * | WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or	  |
 * | impled. See the License for the specific language governing 		  |
 * | permissions and limitations under the License.					      |
 * +----------------------------------------------------------------------+
 * | Authors: bearsoft <bearsoft5@hotmail.com>                            |
 * +----------------------------------------------------------------------+
 */
package flamingo.collection;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {
	
	/**
	 * <pre>This method parse the string to Map.</pre>
	 * @param mapString - the map string.
	 * @return - Returns the map.
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> parseMap(String mapString) {
		// TODO: Check if hte string is not null.
		
		// {test1=a, test2=b}
		//  test1=a, test2=b
		Map<K, V> map = new HashMap<>();
		
		mapString = mapString.substring(1, mapString.length() - 1);

		// Get the keys and values.
		String[] mapString_split_k = mapString.split(", ");

		// Get the key and value.
		for (String mapString_split_k_v : mapString_split_k) {
			String[] mapString_split_k_v_1 = mapString_split_k_v.split("=");
			map.put((K) mapString_split_k_v_1[0].trim(), (V) mapString_split_k_v_1[1].trim());
		}
		
		return map;
	}
}
