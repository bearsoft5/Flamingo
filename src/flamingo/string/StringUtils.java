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
package flamingo.string;

import flamingo.common.Preconditions;

public class StringUtils {

	/**
	 * This field represents the Characters.
	 */
	public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";

	/**
	 * This method make a random string, with the length.
	 * @param strlen - the string length.
	 * @return - Returns the string.
	 */
	public static String randomString(int strlen) {
		StringBuilder strb = new StringBuilder();
		
		for (int i = 0; i < strlen; i++) {
			strb.append(CHARACTERS.charAt((int) (Math.random() * CHARACTERS.length())));
		}
		
		return strb.toString();
	}
	
	/**
	 * This method remove the (strrem) if contains in string (str).
	 * @param str - the string.
	 * @param strrem - the string remove.
	 * @return - Returns the string.
	 */
	public static String strrem(String str, String strrem) {
		// Check if the strrem contains on str.
		if (str.contains(strrem)) {
			str = str.replace(strrem, "");
		}
		
		return str;
	}
	
	/**
	 * This method check if the (str1) is equals (str2).
	 * @param str1 - the string 1.
	 * @param str2 - the string 2.
	 * @return - Returns (true) if the string is equals, otherwise return (false).
	 */
	public static boolean equals(String str1, String str2) {
		// Check if the string length is different.
		if (str1.length() != str2.length()) return false;

		// Check if the bytes is equals.
		for (int i = 0; i < str1.length(); i++) {
			if (str1.getBytes()[i] != str2.getBytes()[i]) return false;
		}
		
		return true;
	}
	
	/**
	 * This method check if the string is a blank string.
	 * @param cs - the char sequence.
	 * @return - Returns (true) if the char sequence is totally blank, return (false) if the char sequence have a character.
	 */
	public static boolean isBlank(final CharSequence cs) {
		int strl = cs.length();
		
		// Check if the (cs) is null or (cs length) is 0.
		if (cs == null || strl == 0) return true;
		
		for (int i = 0; i < strl; i++) {
			
			// This method check if the (cs charAt(i)) is a (whitespace character).
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * This method check if the string is not blank string.
	 * @param cs - the char sequence.
	 * @return - Returns (true) if the char sequence is not blank, return (false) if the char sequence is blank.
	 */
	public static boolean isNotBlank(final CharSequence cs) {
		return !isBlank(cs);
	}
	
	/**
	 * <pre>This method combie the (string array 1) with (string array 2)</pre>
	 * @param str_a1 - the string array 1.
	 * @param str_a2 - the string array 2.
	 * @return - Returns the (string array) with (str_a1) and (str_a2).
	 */
	public static String[] combine(String[] str_a1, String[] str_a2) {
		int str_a_size = str_a1.length + str_a2.length; // 5, 5
		String[] str_a = new String[str_a_size]; // 10
		
		for (int i = 0, j = 0; i < str_a_size; i++) { // 0 - 9 ( < 10 )
			if (j == str_a1.length) {
				j = 0;
			}
			
			if (i < str_a1.length) { // =5 (0, 1, 2, 3, 4) (<5)
				str_a[i] = str_a1[j];
			} else {
				str_a[i] = str_a2[j];
			}
			
			j++;
		}
		
		return str_a;
	}
	
	/**
	 * <pre>This method check if the (char sequence) is numeric.
	 * 
	 * isNumeric("+123") = false
	 * isNumeric("-123") = false
	 * isNumeric("a123") = false
	 * isNumeric(" 123") = false
	 * isNumeric("123") = true
	 * </pre>
	 * @param cs - the char sequence.
	 * @return - Return (true) if the (char sequence) is numeric, otherwise return (false).
	 */
	public static boolean isNumeric(final CharSequence cs) {
		for (int i = 0; i < cs.length(); i++) {
			if (!Character.isDigit(cs.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * <pre>This method check if the <i>char sequence</i> is empty.</pre>
	 * @param cs - the char sequence.
	 * @return - Returns (true) if the <i>char sequence</i> is empty, otherwise return (false).
	 */
	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}	
	
	/**
	 * <pre>This method substring the (string), with start index and end index.
	 * <strong>INFO: This method check if the string is (null or empty), before substring the string.</strong>
	 * </pre>
	 * @param string - the string.
	 * @param start - the start.
	 * @param end - the end.
	 * @return - Returns the string.
	 */
	public static String substring(final String string, int start, int end) {
		Preconditions.checkArgument(isEmpty(string), "The string is empty or null.");
		return string.substring(start, end);
	}
	
	/**
	 * <pre>This method substring the (string), with index.
	 * <strong>INFO: This method check if the string is (null or empty), before substring the string.</strong><
	 * </pre>
	 * @param string
	 * @param index
	 * @return
	 */
	public static String substring(final String string, int index) {
		Preconditions.checkArgument(isEmpty(string), "The string is empty or null.");
		return string.substring(index);
	}
	
	/**
	 * <pre>This method abbreviate the string with (start) index and (end) index.</pre>
	 * @param string - the string.
	 * @param start - the start.
	 * @param end - the end.
	 * @return - Returns the string.
	 */
	public static String abbreviate(final String string, int start, int end) {
		String s = "..." + substring(string, start, end) + "...";
		return s;
	}
	
	/**
	 * <pre>This method abbreviate the string with start index.</pre>
	 * @param string - the string.
	 * @param index - the index.
	 * @return - Returns the string.
	 */
	public static String abbreviateStart(final String string, int index) {
		String s = "..." + substring(string, index);
		return s;
	}
	
	/**
	 * <pre>This method abbreviate the string with end index.</pre>
	 * @param string - the string.
	 * @param index - the index.
	 * @return - Returns the string.
	 */
	public static String abbreviateEnd(final String string, int index) {
		String s = substring(string, 0, string.length() - index) + "...";
		return s;
	}
	
	/**
	 * <pre>This method inverse the string.</pre>
	 * @param string - the string.
	 * @return - Returns the string.
	 */
	public static String inverse(final String string) {
		char[] stra = string.toCharArray();
		int strlen = stra.length - 1;

		char[] c = new char[stra.length];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = stra[strlen - i];
		}
		
		return new String(c);
	}
}
