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

public class ArrayUtils {
	
	/**
	 * <pre>This method make the string with <i>generic</i> array.</pre>
	 * @param array - the array.
	 * @return - Returns the string.
	 */
	public static <T> String toStringArray(T[] array) {
		StringBuilder s = new StringBuilder();
		s.append(array[0]);
		
		for (int i = 1; i < array.length; i++) {
			s.append(", " + array[i]);
		}
		
		return s.toString();
	}
	
	/**
	 * <pre>This method combine the <code>array1</code> with <code>array2</code>,
	 * And return a array, with array combined.</pre>
	 * @param array1 - the array 1.
	 * @param array2 - the array 2.
	 * @return - Returns the array.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] combine(T[] array1, T[] array2) {
		int array_size = array1.length + array2.length;
		Object[] array = new Object[array_size];
		
		for (int i = 0, j = 0; i < array_size; i++) {
			if (j == array1.length) {
				j = 0;
			}
			
			if (i < array1.length) {
				array[i] = array1[j];
			} else {
				array[i] = array2[j];
			}
			
			j++;
		}
		return (T[]) array;
	}
	
	/**
	 * <pre>This method convert the <i>...</i> to <i>[]</i.></pre>
	 * @param t - the elements.
	 * @return - Return the array.
	 */
	@SafeVarargs
	public static <T> T[] toArray(T... t) {
		return t;
	}
}
