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
package flamingo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import flamingo.common.Preconditions;

public class FieldUtils {

	/**
	 * <pre>This method get field of the (src) that is class,
	 * but this method can be a field that the class (src) are extends,
	 * case get the field that (src) have declared use the method
	 * <i>{@code getDeclaredField}</i> to do this.</pre>
	 * @param name - the field name.
	 * @param src - the src.
	 * @return - Returns the field.
	 */
	public static Field getField(String name, Class<?> src) {
		Preconditions.notNull(src, "The class (src) is null.");
		Preconditions.isTrue(name.length() == 0 || name == null, "The field name (name) is length 0, or is null.");

		try {
			Field f = src.getField(name);
			
			// This method check if the field is not accessible,
			// If the field is not accessible, make the field like accessible.
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			
			return f;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <pre>This method get field of the (src) that is class,
	 * but this method only get the field that the (src) class are declared.</pre>
	 * @param name - the field name.
	 * @param src - the src.
	 * @return - Returns the field.
	 */
	public static Field getDeclaredField(String name, Class<?> src) {
		Preconditions.notNull(src, "The class (src) is null.");
		Preconditions.isTrue(name.length() == 0 || name == null, "The field name (name) is length 0, or is null.");

		try {
			Field f = src.getDeclaredField(name);
			
			// This method check if the field is not accessible,
			// If the field is not accessible, make the field like accessible.
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}

			return f;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <pre>This method read static declared field, this method
	 * get the declared field that have name (name), and get the value,
	 * This field have a (forceAccess), what is this?
	 * 
	 * Force Access:
	 * The force access, if the field is not accessible,
	 * make the field accessible to can get the value.
	 * </pre>
	 * 
	 * @param name - the field name.
	 * @param obj - the object, that is a class.
	 * @return - Returns the value of static declared field.
	 */
	public static Object readStaticDeclaredField(String name, Class<?> src) {
		Preconditions.notNull(src, "The object is null.");
		Preconditions.isTrue(name.length() == 0 || name == null, "The field name (name) is length 0, or is null.");
		try {
			Field f = src.getDeclaredField(name);
			Preconditions.isTrue(!Modifier.isStatic(f.getModifiers()), "The field is not static.");
			
			// This method check if the field is not accessible,
			// If the field is not accessible, make the field like accessible.
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			
			// This part only return the value of the static field.
			return f.get(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <pre>This method read static field, this method
	 * get the declared field that have name (name), and get the value,
	 * This field have a (forceAccess), what is this?
	 * 
	 * Force Access:
	 * The force access, if the field is not accessible,
	 * make the field accessible to can get the value.
	 * </pre>
	 * 
	 * @param name - the field name.
	 * @param obj - the object, that is a class.
	 * @return - Returns the value of static declared field.
	 */
	public static Object readStaticField(String name, Class<?> src) {
		Preconditions.notNull(src, "The object is null.");
		Preconditions.isTrue(name.length() == 0 || name == null, "The field name (name) is length 0, or is null.");

		try {
			Field f = src.getField(name);
			Preconditions.isTrue(!Modifier.isStatic(f.getModifiers()), "The field is not static.");
			
			// This method check if the field is not accessible,
			// If the field is not accessible, make the field like accessible.
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			
			// This part only return the value of the static field.
			return f.get(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <pre>This method write the value to the declared field.</pre>
	 * @param name - the field name.
	 * @param value - the value.
	 * @param src - the source that is class.
	 */
	public static void writeDeclaredField(String name, Object target, Object value, Class<?> src) {
		Field f = getDeclaredField(name, src);
		
		try {
			// This method set the new value of the field.
			f.set(target, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <pre>This method write the value to the field.</pre>
	 * @param name - the field name.
	 * @param value - the value.
	 * @param src - the source that is class.
	 */
	public static void writeField(String name, Object target, Object value, Class<?> src) {
		Field f = getField(name, src);
		
		try {
			// This method set the new value of the field.
			f.set(target, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <pre>This method write the value to the static declared field.</pre>
	 * @param name - the field name.
	 * @param value - the value.
	 * @param src - the src that is class.
	 */
	public static void writeStaticDeclaredField(String name, Object value, Class<?> src) {
		try {
			Field f = src.getDeclaredField(name);
			Preconditions.isTrue(!Modifier.isStatic(f.getModifiers()), "The field is not static.");
			
			// This method check if the field is not accessible,
			// If the field is not accessible, make the field like accessible.
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			
			// This method get the declared field,
			// And set the value.
			f.set(null, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <pre>This method write the value to the static field.</pre>
	 * @param name - the field name.
	 * @param value - the value.
	 * @param src - the src that is class.
	 */
	public static void writeStaticField(String name, Object value, Class<?> src) {
		try {
			Field f = src.getField(name);
			Preconditions.isTrue(!Modifier.isStatic(f.getModifiers()), "The field is not static.");
			
			// This method check if the field is not accessible,
			// If the field is not accessible, make the field like accessible.
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			
			// This method get the declared field,
			// And set the value.
			f.set(null, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
