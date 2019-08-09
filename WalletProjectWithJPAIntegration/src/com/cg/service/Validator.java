package com.cg.service;

public interface Validator {

	String aidpattern = "[1-9][0-9][0-9]";
	String mobilepattern = "[1-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
	String namepattern = "([A-Za-z]{3}[A-Za-z]* [A-Za-z]{3}[A-Za-z]*)|([A-Za-z]+'[A-Za-z]*[A-Za-z]{3}[A-Za-z])";
	String salarypattern = "[1-9]{1}([0-9])*|[1-9]{1}([0-9])*.([0-9])+";

	public static boolean validatedata(String data, String pattern) {
		return data.matches(pattern);
	}
}
