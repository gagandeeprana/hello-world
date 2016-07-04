package com.cloudsmartz;

public class EmpDB {

	public double calculateYearlySalary(Emp emp) {
		double yearlySalary = 0;
		yearlySalary = emp.getSalary() * 12;
		return yearlySalary;
	}

	public double calculateAppraisal(Emp emp) {

		double appraisal = 0;

		if (emp.getSalary() < 10000) {
			appraisal = 500;

		} else {
			appraisal = 1000;
		}

		return appraisal;
	}
}