package com.gofortrainings.newsportal.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class)
@SlingServletPaths(value = { "/bin/newsportal/user-service/reset-possword" })
public class ResetPasswordServlet extends SlingAllMethodsServlet {

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		ResourceResolver resolver = request.getResourceResolver();
		String userId = request.getParameter("userId");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");

		Resource userResource = resolver.getResource("/content/user/" + userId);
		if (userResource != null) {
			ValueMap userProperties = userResource.getValueMap();
			String nodePassword = userProperties.get("password", String.class);
			if (oldPassword.equals(nodePassword)) {
				ModifiableValueMap mprop = userResource.adaptTo(ModifiableValueMap.class);
				mprop.put("password", newPassword);
				resolver.commit();
				response.getWriter().write("Password updated successfully");
			} else {
				response.getWriter().write("Incorrect password");
			}
		} else {
			response.getWriter().write("Invalid user");
		}
	}
}
