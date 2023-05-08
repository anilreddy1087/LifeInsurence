package com.gofortrainings.newsportal.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class)
@SlingServletPaths(value = { "/bin/newsportal/service/users" })
public class UserCreation extends SlingAllMethodsServlet {

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");

		ResourceResolver resolver = request.getResourceResolver();
		Resource resource = resolver.getResource("/content/users/" + userId);

		if (resource != null) {
			ValueMap valueMap = resource.getValueMap();
			String storedUserId = valueMap.get("userId", String.class);
			String storedFirstName = valueMap.get("firstName", String.class);
			String storedLastName = valueMap.get("lastName", String.class);
			int storedAge = valueMap.get("age", int.class);
			String storedEmail = valueMap.get("email", String.class);
			String storedPhNumber = valueMap.get("phNumber", String.class);
			String nodePassword = valueMap.get("password", String.class);

			response.getWriter()
					.write("userId:" + storedUserId + "storedFirstName:" + storedFirstName + "storedLastName:"
							+ storedLastName + "storedAge:" + storedAge + "storedEmail:" + storedEmail
							+ "storedPhNumber:" + storedPhNumber + "nodePassword:" + nodePassword);

		} else {

			response.getWriter().write("No user node found with ID");

		}
	}

}
