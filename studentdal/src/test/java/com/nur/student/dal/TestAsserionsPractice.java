package com.nur.student.dal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAsserionsPractice {
	
	@Test
	public void testA() {
		 String expected="Hello world";
		 String actual="Hello";
		 
		 Assertions.assertEquals(expected, actual);
	}
}
