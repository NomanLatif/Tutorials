package com.noman.rest.entity;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TestEmployee
{
	private static final String NOMAN_LATIF = "Noman Latif";

	@Test
	public void testCreateEmployee()
	{
		Employee emp = new Employee(1, NOMAN_LATIF);

		Assertions.assertThat(emp.getId()).isEqualTo(1);
		Assertions.assertThat(emp.getName()).isEqualTo(NOMAN_LATIF);
	}

	@Test
	public void testCanSetFeilds()
	{
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName(NOMAN_LATIF);

		Assertions.assertThat(emp.getId()).isEqualTo(1);
		Assertions.assertThat(emp.getName()).isEqualTo(NOMAN_LATIF);
	}
}
