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
package flamingo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import flamingo.common.Preconditions;

public class DateUtils {

	public static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	/**
	 * <pre>This methd format the now date.</pre>
	 * @return - Returns the date string.
	 */
	public static String now() {
		return FORMAT.format(new Date());
	}
	
	/**
	 * <pre>This method format the now date, with a <i>format</i></pre>
	 * @param format - the format.
	 * @return - Returns teh date format.
	 */
	public static String now(DateFormat format) {
		Preconditions.checkNotNull(format, "The format is null.");
		return format.format(new Date());
	}
	
	/**
	 * <pre>This method parse the <i>string</i> to long.</pre>
	 * @param string - the string.
	 * @return - Returns the long.
	 */
	@SuppressWarnings("deprecation")
	public static long stringToDateLong(String string) {
		try {
			return Date.parse(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0L;
	}
}
