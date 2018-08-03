package com;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

	@Test
	public void createStudent() {
		Student studentObj = new Student();
		Assert.assertNotNull(studentObj);
	}
	

}
