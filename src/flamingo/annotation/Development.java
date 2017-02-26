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
package flamingo.annotation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Development {

	/**
	 * This represents the description of the development about the annotation.
	 */
	String desc() default "";
}
