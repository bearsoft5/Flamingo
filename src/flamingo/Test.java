package flamingo;

import flamingo.network.NetworkUtils;

public class Test {

	int a = 10;
	static int b = 9;
	
	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();
		
		System.out.println(NetworkUtils.getMACAddress("192.168.1.35"));
		
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
}
