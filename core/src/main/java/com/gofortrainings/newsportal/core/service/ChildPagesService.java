package com.gofortrainings.newsportal.core.service;

import java.io.IOException;
import java.util.Iterator;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = ChildPagesService.class)
public class ChildPagesService {

	private static final Logger logger = LoggerFactory.getLogger(ChildPagesService.class);

	@Activate
	public void activate() {
		logger.info("bundle activate");
	}

	@Modified
	public void modified() {
		logger.info("bundle modified");
	}

	@Deactivate
	public void deactivate() {
		logger.info("bundle deactivate");
	}

	public String  getChildPagesService(SlingHttpServletRequest request) throws IOException {
		ResourceResolver resolver = request.getResourceResolver();
		PageManager pageManagericle = resolver.adaptTo(PageManager.class);
		Page gftPage = pageManagericle.getPage("/content/newsportal/us/en");
		Iterator<Page> articlesPage = gftPage.listChildren();
		String title = "";
		if (articlesPage != null) {
			while (articlesPage.hasNext()) {
				Page page = (Page) articlesPage.next();
				  title =title.concat(page.getTitle());
			}
		}
		
		return  title;
	}

}
