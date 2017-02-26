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

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
	
	/**
	 * <pre>This method join the (list 1) with (list 2).</pre>
	 * @param listSrc - the list source.
	 * @param listJoin - the list join.
	 * @return - Returns the list.
	 */
	public static <T> List<T> join(List<T> listSrc, List<T> listJoin) {
		// Get the elements of (list_join) and add on (list_src).
		for (T t : listJoin) {
			listSrc.add(t);
		}
		
		return listSrc;
	}
	
	/**
	 * <pre>This method make the list with the elements.</pre>
	 * @param t - the elements.
	 * @return - Returns the list.
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> makeList(T... t) {
		
		// Check if the (array of elements) is null.
		if (t == null) return null;
		
		List<T> list = new ArrayList<>();
		
		// Get the elements of array, and add to list.
		for (T t_ : t) {
			list.add(t_);
		}
		
		return list;
		
	}
	
	/**
	 * <pre>This method parse the string to list.</pre>
	 * @param listString - the string list.
	 * @return - Returns the list.
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> parseList(String listString) {
		if (listString.length() == 0 || listString == null) return null;
		
		listString = listString.substring(1, listString.length() - 1);

		// Get elements.
		String[] listString_k = listString.split(", ");
		
		List<T> list = new ArrayList<>();
		
		for (String listString_k_1 : listString_k) {
			list.add((T) listString_k_1);
		}
		
		return list;
	}
}
