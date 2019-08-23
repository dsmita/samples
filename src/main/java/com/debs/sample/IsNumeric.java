package com.debs.sample;

public class IsNumeric {

	public static boolean isNumeric(String s) {
		if (s == null || s.equals(""))
			return false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (i == 0 && c == 'e')
				return false;
			if (i == 0 && c == '-')
				continue;
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

}
