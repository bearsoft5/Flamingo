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
package flamingo.network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetworkUtils {

	/**
	 * <pre>This method get MAC address of computer.</pre>
	 * @param host - the host.
	 * @return - Returns the MAC address.
	 */
	public static String getMACAddress(String host) {
		try {
//			InetAddress address = InetAddress.getByName(host);
//			NetworkInterface ni = NetworkInterface.getByInetAddress(address);
//			byte[] mac = ni.getHardwareAddress();
			
			// Make this to consume less memory, when execute the method.
			byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getByName(host)).getHardwareAddress();

			String macAddress = "";
			for (int i = 0; i < mac.length; i++) {
				macAddress += String.format("%02X-", mac[i]);
			}
			return macAddress.substring(0, macAddress.length() - 1);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}

		return null;
	}
}
