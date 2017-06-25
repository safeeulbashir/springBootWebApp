package com.safee.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "salary")
public class Salary {
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "employee"))
	@Id
	@GeneratedValue(generator = "generator")
	Integer employeeNo;
	Integer salary;
	@OneToOne(fetch = FetchType.LAZY,optional=true)
	@PrimaryKeyJoinColumn
	Employee employee;
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the employeeNo
	 */
	public Integer getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo
	 *            the employeeNo to set
	 */
	public void setEmployeeNo(Integer employeeNo) {
		this.employeeNo = employeeNo;
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

}
