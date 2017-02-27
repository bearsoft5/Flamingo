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
package flamingo;

import flamingo.string.StringUtils;

public class Test {

	int a = 10;
	static int b = 9;
	
	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();
		
		System.out.println(StringUtils.inverse("AEKOP"));
		elapsed(start);
		System.out.println("Finish.");
	}
	
	public static void elapsed(long start) {
		float end = System.currentTimeMillis() - start;
		System.out.println("" + end / 1000 + "s or (" + end + "ms).");
	}
	
	public static void mem(long sm) {
		float em = sm - Runtime.getRuntime().freeMemory();
		System.out.println("" + em / 1048576 + "mb, " + "" + em / 1024 + "kb, " + "" + em + "b.");
	}
	
	public static void test() {
		System.out.println("test1");
	}
}
