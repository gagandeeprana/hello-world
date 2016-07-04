package com.cloudsmartz;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEmployeeDetails {
	EmpDB empBusinessLogic = new EmpDB();
	Emp employee = new Emp();

	@Test
	public void testCalculateAppriasal() {

		employee.setId(25);
		employee.setName("Rajeev");
		employee.setSalary(8000);

		double appraisal = empBusinessLogic.calculateAppraisal(employee);
		Assert.assertEquals(500, appraisal, 0.0, "500");
	}

	@Test
	public void testCalculateYearlySalary() {

		employee.setId(25);
		employee.setName("Rajeev");
		employee.setSalary(8000);

		double salary = empBusinessLogic.calculateYearlySalary(employee);
		Assert.assertEquals(96000, salary, 0.0, "8000");
	}
}