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

import java.lang.reflect.Method;

public class MethodUtils {

	/**
	 * <pre>This method get declared method that have the {@code name} and
	 * {@code parameterTypes} from (src) class.</pre>
	 * @param name - the name.
	 * @param parameterTypes - the parameter types.
	 * @param src - the src.
	 * @return - Returns the method.
	 */
	public static Method getDeclaredMethod(String name, Class<?>[] parameterTypes, Class<?> src) {
		try {
			Method m = src.getDeclaredMethod(name, parameterTypes);
			
			// This method check if the method is accessible,
			// If the method is not accessible, make the method like accessible.
			if (!m.isAccessible()) {
				m.setAccessible(true);
			}
			
			return m;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * <pre>This method get method that have the {@code name} and {@code parameterTypes}
	 * from (src) class.</pre>
	 * @param name - the name.
	 * @param parameterTypes - the parameter types.
	 * @param src - the src.
	 * @return - Returns the method.
	 */
	public static Method getMethod(String name, Class<?>[] parameterTypes, Class<?> src) {
		try {
			Method m = src.getMethod(name, parameterTypes);
			// This method check if the method is accessible,
			// If the method is not accessible, make the method like accessible.
			if (!m.isAccessible()) {
				m.setAccessible(true);
			}
			
			return m;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * <pre>This method invoke the method.</pre>
	 * @param method - the method.
	 * @param target - the <code>instance</code> of method.
	 * @param args - the arguments of method.
	 */
	public static void invoke(Method method, Object target, Object... args) {
		try {
			method.invoke(target, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
