package com.noman.rest;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.noman.rest.entity.Employees;

public class TestEmployeeService
{
	private HttpServer server;
	private WebTarget target;

	@Before
	public void setUp() throws Exception
	{
		// start the server
		server = Main.startServer();
	}

	@After
	public void tearDown() throws Exception
	{
		server.shutdownNow();
	}

	@Ignore
	@Test
	public void testCanGetEmployees() throws Exception
	{
		Client client = ClientBuilder.newClient(new ClientConfig().register(String.class));
		WebTarget webTarget = client.target("http://localhost:8080/myapp").path("employees");
		//
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		Employees employees = response.readEntity(Employees.class);
		assertThat(employees.getEmployeeList().size()).isEqualTo(3);
	}
}
