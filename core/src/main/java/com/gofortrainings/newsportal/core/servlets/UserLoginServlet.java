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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class)
@SlingServletPaths(value = { "/bin/newsportal/service/user-loing" })
public class UserLoginServlet extends SlingAllMethodsServlet {

	   private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginServlet.class);

	    @Override
	    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
	            throws ServletException, IOException {

	        String userId = request.getParameter("userId");
	        String password = request.getParameter("password");

	        ResourceResolver resolver = request.getResourceResolver();
	        Resource userResource = resolver.getResource("/content/users/" + userId);

	        if (userResource != null) {
	            ValueMap userProperties = userResource.getValueMap();
	            String userPassword = userProperties.get("password", String.class);
	            if (userPassword.equals(password)) {
	                LOGGER.info("Valid user and password for user: {}", userId);
	                response.getWriter().write("valid Password");
	            } else {
	                LOGGER.warn("Invalid password for user: {}", userId);
	                response.getWriter().write("Invalid Password");
	            }
	        } else {
	            LOGGER.warn("Invalid user ID: {}", userId);
	            response.getWriter().write("Invalid UserID");
	        }
	    }
	}