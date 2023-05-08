package com.gofortrainings.newsportal.core.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class)
@SlingServletPaths(value = { "/bin/newsportal/service/user-create" })
public class CreateUserServlet extends SlingAllMethodsServlet {

	private static final Logger logger = LoggerFactory.getLogger(CreateUserServlet.class);

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		long phNumber = Long.parseLong(request.getParameter("phNumber"));
		String password = request.getParameter("password");

		ResourceResolver resolver = request.getResourceResolver();
		Resource resource = resolver.getResource("/content/users");

		Map<String, Object> properties = new HashMap<>();
		properties.put("userId", userId);
		properties.put("firstName", firstName);
		properties.put("lastName", lastName);
		properties.put("age", age);
		properties.put("eMail", email);
		properties.put("phNumber", phNumber);
		properties.put("password", password);

		resolver.create(resource, userId, properties);
		resolver.commit();

		logger.info("User created successfully. User ID: {}", userId);
		logger.error("Registration failed for user: {} with error: {}", userId);


	}
}
