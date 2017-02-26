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

public class Validate {

	/**
	 * <pre>This method check if the (expression) is true,
	 * and if the (expression) is true throw a error (IllegalArgumentException) with message (message).</pre>
	 * @param expression - the expression.
	 * 					   This expression will be checked.
	 * @param message - the message.
	 * 					This message is the message that will be send if the (expression) is true.
	 */
	public static void isTrue(boolean expression, String message) {
		if (expression) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * <pre>This method check if the (obj) is null,
	 * And if the object is null throw a error (NullPointerException) with message (message).</pre>
	 * @param obj - the object.
	 * 				This objet will be checked.
	 * @param message
	 * 				The message that will be send if the object is null.
	 */
	public static <T> void notNull(T obj, String message) {
		if (obj == null) {
			throw new NullPointerException(message);
		}
	}
}
