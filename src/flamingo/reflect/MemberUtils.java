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
package flamingo.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public class MemberUtils {

	/**
	 * This method set (AccessibleObject) like accessible.
	 * @param ao - the accessible object.
	 */
	public static void setAccessibleWorkaround(final AccessibleObject ao) {
		
		// Check if the (ao) equals null, or the (ao) is accessible.
		if (ao == null || ao.isAccessible()) return;
		
		// Make the (AccessibleObject) like accessible.
		ao.setAccessible(true);
	}
	
	/**
	 * <pre>This method set (AccessibleObject) like acessible,
	 * But this method have a (IMethodInvoker) this parameter in
	 * Method setAccesibleWorkaroundInvoke, the accessible object is accessible,
	 * And the (IMethodInvoker) invoke the method, and after the method is finished,
	 * The accessible object is not accessible.</pre>
	 * @param ao - the accessible object.
	 * @param methodInvoker - the method invoker.
	 */
	public static void setAccessibleWorkaroundInvoke(final AccessibleObject ao, IMethodInvoker methodInvoker) {
		// Check if the (ao) equals null, or the (ao) is accessible.
		if (ao == null || ao.isAccessible()) return;
		
		// Make the (ao) like accessible.
		ao.setAccessible(true);
		
		// Invoke the method of (IMethodInvoker).
		methodInvoker.invoke();
		
		ao.setAccessible(false);
	}
	
	/**
	 * This method check if the {@code Member} is accessible.
	 * @param m - the member.
	 * @return - Returns (true) if the member is accessible, otherwise return (false).
	 */
	public static boolean isAccessible(final Member m) {
		return m != null && Modifier.isPublic(m.getModifiers()) && !m.isSynthetic();
	}
}
