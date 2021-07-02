package com.inetbank.testCases;

public class SharedClass {
	
	private static String custId;

	public static String getCustId() {
		return custId;
	}

	public static void setCustId(String custId) {
		SharedClass.custId = custId;
	}	
	

}
