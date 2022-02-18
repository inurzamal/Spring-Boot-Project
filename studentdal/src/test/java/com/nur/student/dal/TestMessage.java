package com.nur.student.dal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nur.student.dal.entities.Message;

public class TestMessage {
	
	@Test
	public void testshowMsg() {
		
		String expected = "Welcome Rahul";
		
		Message m = new Message();
		String actual = m.showMsg("Rahul");
		
		Assertions.assertEquals(expected, actual);
	}

}
