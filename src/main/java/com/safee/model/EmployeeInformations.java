package com.safee.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class EmployeeInformations implements Serializable {

	private Integer empNo;
	private String firstName;
	private String lastName;
	private java.util.Date joinDate;
	private String deptartmentName;
	private Integer salary;

	public double calculateGrossSalary() // (basic salary + 30% basic salary)
	{
		return this.salary + 0.3 * this.salary;
	}

	/**
	 * @return the salary
	 */
	public Integer getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	/**
	 * @return the empNo
	 */
	public Integer getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo
	 *            the empNo to set
	 */
	public void setEmpNo(Integer empNo) {
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
	public java.util.Date getJoinDate() {
		return joinDate;
	}

	/**
	 * @param joinDate
	 *            the joinDate to set
	 */
	public void setJoinDate(java.util.Date joinDate) {
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
