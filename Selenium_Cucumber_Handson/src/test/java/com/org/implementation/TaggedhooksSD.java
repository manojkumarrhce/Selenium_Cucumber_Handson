//package com.org.implementation;
//
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.Given;
//
//public class TaggedhooksSD {
//
//	@Before(order=0)
//	public void setup0() {
//		System.out.println("setup0");
//	}
//
//	@After(order=0)
//	public void teardown0() {
//		System.out.println("teardown0");
//	}
//	@Before(order=1)
//	public void setup1() {
//		System.out.println("setup1");
//	}
//
//	@After(order=1)
//	public void teardown1() {
//		System.out.println("teardown1");
//	}
//	@Before("@First")
//	public void setupforfirst() {
//		System.out.println("before specific to first test case alone");
//	}
//
//	@After("@First")
//	public void teardownforfirst() {
//		System.out.println("after specific first test case alone");
//	}
//	@Given("^first test case$")
//	public void first_test_case() throws Throwable {
//		System.out.println("testcase#1");
//	}
//
//	@Given("^second test case$")
//	public void second_test_case() throws Throwable {
//		System.out.println("testcase#2");
//	}
//
//}
