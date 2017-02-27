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
package flamingo.common;

/**
 * <pre><strong>INFO:</strong> This (Preconditions) is different of others Preconditions like (Apache and Google),
 * This Preconditions function that check if the (expression) is (true), and don't if the expression is (false),
 * Like function on (Apache and Google).</pre>
 */
public class Preconditions {
	
	/**
	 * <pre>This method check if the (expression) is (true),
	 * And if the (expression) is (true), throw a error (IllegalArgumentException).</pre>
	 * @param expression - the expression.
	 * @param message - the message.
	 */
	public static void checkArgument(boolean expression, String message) {
		if (expression) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * <pre>This method check if the (expression) is (true),
	 * And if the (expression) is (true), throw a error (IllegalStateException).</pre>
	 * @param expression - the expression.
	 * @param message - the message.
	 */
	public static void checkState(boolean expression, String message) {
		if (expression) {
			throw new IllegalStateException(message);
		}
	}
	
	/**
	 * <pre>This method check if the (obj) is null,
	 * And if the (obj) is null, throw a error (NullPointerException).</pre>
	 * @param obj
	 * @param message
	 */
	public static <T> void checkNotNull(T obj, String message) {
		if (obj == null) {
			throw new NullPointerException(message);
		}
	}
}
