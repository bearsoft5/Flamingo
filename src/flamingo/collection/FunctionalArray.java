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

import flamingo.common.Preconditions;

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

	private Object[] elements;
	private int size;
	
	/**
	 * FlamingoArray, conobjuctor.
	 * @param initialCapacity - this represents the initial capacity of string array.
	 */
	public FunctionalArray(int initialCapacity) {
		elements = new Object[initialCapacity];
		size = 0;
	}
	
	/**
	 * This method delete the last index of objing array.
	 * @return - Returns the last index that is now (after that delete the last index).
	 */
	@SuppressWarnings("unchecked")
	public T pop() {
		Preconditions.checkArgument(elements.length == 0, "Don\'t use the method pop(), because the size is 0.");
		
		elements[size - 1] = null;
		size--;
		
		return (T) elements[size - 2];
	}
	
	/**
	 * This method push the (obj) to (string array).
	 * @param obj - the string.
	 * @return - Returns the (obj).
	 */
	@SuppressWarnings("unchecked")
	public T push(T obj) {
		Preconditions.checkArgument(size == elements.length, "Don\'t use the method push(), because the (size) of array is fully, try resize() method.");
		
		elements[size] = obj;
		size++;
		
		return (T) elements[size - 1];
	}
	
	/**
	 * This method resize the parameter.
	 * @param newSize - the new size "length".
	 */
	public void resize(int newSize) {
		Preconditions.checkArgument(elements.length >= newSize, "The array length can\'t less than (newSize).");
		this.elements = ArrayUtils.makeAndPush(this.elements, newSize);
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
		elements[0] = null;
		
		int objl = elements.length - 1;
		
		for (int i = 0; i < objl; i++) {
			elements[i] = elements[i + 1];
		}
		
		return (T) elements[0];
	}
	
	/**
	 * This method get objing array.
	 * @return - Returns the string array.
	 */
	@SuppressWarnings("unchecked")
	public T[] getArray() {
		return (T[]) elements;
	}
	
	/**
	 * This method get size.
	 * @return - Returns the size of string array.
	 */
	public int size() {
		return size;
	}
}
