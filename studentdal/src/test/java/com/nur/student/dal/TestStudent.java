package com.nur.student.dal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//Test case : that will test our code

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestStudent {
	
	@BeforeAll
	public static void setUpOnce() {
		System.out.println("Setup only once");
	}
	
	@BeforeEach
	public void setUp() {
		System.out.println("Setup initial data...");
	}
	
	@Test
	public void testSave() {
		System.out.println("testing Save method");
	}
	
	@Test
	public void testUpdate() {
		System.out.println("testing Update method");
	}
	
	@Test
	@Disabled
	public void testDelete() {
		System.out.println("testing Delete method");
	}

	
	@AfterEach
	public void clear() {
		System.out.println("Clear data..");
	}
	
	@AfterAll
	public static void closeAll() {
		System.out.println("Once at end");
	}

}
