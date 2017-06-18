package com.safee.model;

import java.sql.Date;

public class EmployeeInformations {

	private int empNo;
	private String firstName;
	private String lastName;
	private Date joinDate;
	private String deptartmentName;
	private int salary;

	public double calculateGrossSalary() // (basic salary + 30% basic salary)
	{
		return this.salary + 0.3 * this.salary;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * @return the empNo
	 */
	public int getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo
	 *            the empNo to set
	 */
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the joinDate
	 */
	public Date getJoinDate() {
		return joinDate;
	}

	/**
	 * @param joinDate
	 *            the joinDate to set
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * @return the deptartmentName
	 */
	public String getDeptartmentName() {
		return deptartmentName;
	}

	/**
	 * @param deptartmentName
	 *            the deptartmentName to set
	 */
	public void setDeptartmentName(String deptartmentName) {
		this.deptartmentName = deptartmentName;
	}

}
