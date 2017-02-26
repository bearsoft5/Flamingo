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
package flamingo.object;

public class ObjectUtils {

	/**
	 * This method add object array (ob_a2) in (obj_a1).
	 * @param obj_a1 - the object array 1.
	 * @param obj_a2 - the object array 2.
	 * @return - Returns the object array with (obj_a1) and (obj_a2).
	 */
	public static Object[] join(Object[] obj_a1, Object[] obj_a2) {
		int obj_a_size = obj_a1.length + obj_a2.length; // 5, 5
		Object[] obj_a = new Object[obj_a_size]; // 10
		
		for (int i = 0, j = 0; i < obj_a_size; i++) { // 0 - 9 ( < 10 )
			if (j == obj_a1.length) {
				j = 0;
			}
			
			if (i < obj_a1.length) { // =5 (0, 1, 2, 3, 4) (<5)
				obj_a[i] = obj_a1[j];
			} else {
				obj_a[i] = obj_a2[j];
			}
			
			j++;
		}
		
		return obj_a;
	}
	
	/**
	 * This method make the string of object array.
	 * @param obj_a - the object array.
	 * @return - Returns the string.
	 */
	public static String toStringObjectArray(Object[] obj_a) {
		StringBuilder s = new StringBuilder();
		
		s.append(obj_a[0]);
		
		for (int i = 1; i < obj_a.length; i++) {
			s.append(", " + obj_a[i]);
		}
		
		return s.toString();
	}
}
