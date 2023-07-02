package com.uploaddownload;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class junit {

	MathUtils u;
	TestReporter testreporter;
	TestInfo testinfo;
	
	@BeforeEach
	void init(TestInfo testinfo, TestReporter testreporter) {
		this.testinfo= testinfo;
		this.testreporter=testreporter;
		System.out.println("this is printing before each methods");
		u=new MathUtils();
	}
	
	@BeforeAll
	void asdf() {
		System.out.println("I'm execting before all ");
	}
	
	@AfterEach
	void asdff() {
		System.out.println("this is AfterEach;");
	}
	
	@AfterAll
	void adfas() {
		System.out.println("this is Afterall");
	}
	@Test
	@RepeatedTest(5)
	void test() {
	 int expected=93;
	int actual=u.add(1, 92);
	assertEquals(expected, actual,()->"THE EXPECTED RESULT:"+ expected  +"the actual result is"+actual);
	
	}
	
	@Test
	@DisplayName("set of method in one command")
	@Tag("math")

	void tesa() {
		System.out.println("Running"+testinfo.getDisplayName()+"tag"+testinfo.getTags());
	testreporter.publishEntry("Running"+testinfo.getDisplayName()+
			"tag"+testinfo.getTags());
	assertAll	(
				()->assertEquals(452.389342116902, u.areaofCircle(12),"give right input"),
				()->assertEquals(452.389342116902, u.areaofCircle(12),"give right input"),
				()->assertEquals(452.3893421169302, u.areaofCircle(12),"give right input")
			
			);
	}
	@Nested
	@DisplayName("add method ")
	class jsjera{
		@Test
		void tess()	{
			assertEquals( 23,u.dividebyzero(1, 0),"divide by zero must throw exception");
		}
		@Test
		void tesse()	{
			assertThrows(ArithmeticException.class, ()->u.dividebyzero(1, 0),"divide by zero must throw exception");
		}
	}
	
	@Test
	void tesse() {
		assertThrows(ArithmeticException.class, ()->u.dividebyzero(1, 0),"divide by zero must throw exception");
	}
	@Disabled
	@Test
	@DisplayName("it's not tested")
	void tes() {
		assertThrows(ArithmeticException.class, ()->u.dividebyzero(1, 0),"divide by zero must throw exception");
	}
}
