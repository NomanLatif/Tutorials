package com.noman.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.noman.rest.entity.Employee;
import com.noman.rest.entity.Employees;

@Path("employees")
public class EmployeeService
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employees getAllEmployees()
	{
		Employees list = new Employees();
		list.setEmployeeList(new ArrayList<Employee>());

		list.getEmployeeList().add(new Employee(1, "Noman Latif"));
		list.getEmployeeList().add(new Employee(2, "Anders Andersson"));
		list.getEmployeeList().add(new Employee(3, "Marai Daehne"));

		return list;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployee(@PathParam("id") Integer id)
	{
		Employee employee = new Employee(id, "Noman Latif");
		GenericEntity<Employee> entity = new GenericEntity<Employee>(employee, Employee.class);
		return Response.ok().entity(entity).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee employee) throws URISyntaxException
	{
		if (employee == null)
		{
			return Response.status(400).entity("Please add employee details !!").build();
		}

		if (employee.getName() == null)
		{
			return Response.status(400).entity("Please provide the employee name !!").build();
		}

		return Response.created(new URI("/rest/employees/" + employee.getId())).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployeeById(@PathParam("id") Integer id, Employee e)
	{
		Employee updatedEmployee = new Employee();

		if (e.getName() == null)
		{
			return Response.status(400).entity("Please provide the employee name !!").build();
		}

		updatedEmployee.setId(id);
		updatedEmployee.setName(e.getName());

		return Response.ok().entity(updatedEmployee).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEmployeeById(@PathParam("id") Integer id)
	{
		return Response.status(202).entity("Employee deleted successfully !!").build();
	}
}
