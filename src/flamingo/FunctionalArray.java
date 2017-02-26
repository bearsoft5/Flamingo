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
package flamingo;

import flamingo.object.ObjectUtils;

/**
 * StringArray, class.
 * <br>
 * <strong> INFO: This class consume (16 bytes) on startly. </strong>
 * <br>
 * <strong> This class take a new methods, and a easy string array. </strong>
 * @author bearsoft
 *
 */
public class FunctionalArray<T> {

	private Object[] obj_a;
	private int size;
	
	/**
	 * FlamingoArray, conobjuctor.
	 * @param initial_capacity - this represents the initial capacity of string array.
	 */
	public FunctionalArray(int initial_capacity) {
		obj_a = new Object[initial_capacity];
		size = 0;
	}
	
	/**
	 * This method delete the last index of objing array.
	 * @return - Returns the last index that is now (after that delete the last index).
	 */
	@SuppressWarnings("unchecked")
	public T pop() {
		if (obj_a.length == 0) throw new IllegalArgumentException("Don\'t use the method pop(), (objing array) length is 0.");
		
		obj_a[size - 1] = null;
		size--;
		
		return (T) obj_a[obj_a.length - 2];
	}
	
	/**
	 * This method push the (obj) to (string array).
	 * @param obj - the string.
	 * @return - Returns the (obj).
	 */
	@SuppressWarnings("unchecked")
	public T push(T obj) {
		if (size == obj_a.length) throw new IllegalArgumentException("Don\'t use the method push(obj), because the (size) of objing array is fully, try use the resize() method.");
		
		obj_a[size] = obj;
		size++;
		
		return (T) obj_a[size - 1];
	}
	
	/**
	 * This method resize the parameter.
	 * @param new_size - the new size "length".
	 */
	public void resize(int new_size) {
		if (obj_a.length >= new_size) throw new IllegalArgumentException("The (objing array) length can\'t less than or equals (new_size).");
		
		Object[] obj_a_resize = new Object[new_size];
		this.obj_a = ObjectUtils.join(obj_a_resize, obj_a);
	}
	
	/**
	 * This method delete the first index of string array.
	 * @return This method return the new first index of string array.
	 */
	@SuppressWarnings("unchecked")
	public T shift() {
		// Check if the size is 0.
		if (size == 0) return null;
		
		// The first index.
		obj_a[0] = null;
		
		int objl = obj_a.length - 1;
		
		// 0 - 0, 1 - 1, 2 - 2, 3 - 3, 4 - 4
		// 0 - 1, 1 - 2, 2 - 3, 3 - 4
		
		for (int i = 0; i < objl; i++) {
			obj_a[i] = obj_a[i + 1];
		}
		
		return (T) obj_a[0];
	}
	
	/**
	 * This method get objing array.
	 * @return - Returns the string array.
	 */
	@SuppressWarnings("unchecked")
	public T[] get_obj_a() {
		return (T[]) obj_a;
	}
	
	/**
	 * This method get size.
	 * @return - Returns the size of string array.
	 */
	public int size() {
		return size;
	}
}
