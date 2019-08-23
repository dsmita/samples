package com.debs.sample;

public class ValidIP {

	public static boolean solution(String ip) {
		if (ip == null || ip.isEmpty())
			return false;
		String[] arr = ip.split("\\.");
		if (arr.length < 4)
			return false;
		for (String s : arr) {
			if (s.isEmpty()) {
				return false;
			}
			try {
				int i = Integer.parseInt(s);
				if (i < 0 || i > 255) {
					return false;
				}

			} catch (Exception e) {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		String ip = "266.0.3.1";
		boolean val = ValidIP.solution(ip);
		System.out.println(val);
	}

}
