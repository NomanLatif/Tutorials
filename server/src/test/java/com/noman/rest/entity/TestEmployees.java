package com.noman.rest.entity;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TestEmployees
{
	@Test
	public void testSetList()
	{
		Employee emp1 = new Employee(1, "Noman Latif");
		Employee emp2 = new Employee(2, "Yuxin Li");
		List<Employee> empList = Arrays.asList(emp1, emp2);

		Employees employees = new Employees();
		employees.setEmployeeList(empList);

		Assertions.assertThat(employees.getEmployeeList()).isSameAs(empList);
	}
}
