package com.gofortrainings.newsportal.core.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;

@Component(service = ArticleService.class)
public class ArticleService {
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

	public List<Page> getPage(Page page) {

		List<Page> pageList = new ArrayList<>();
		Iterator<Page> childPages = page.listChildren();
		while (childPages.hasNext()) {
			Page page2 = (Page) childPages.next();
			pageList.add(page2);

		}

		return pageList;

	}
	/*
	 * public Boolean hasPageTitle(Page page) {
	 * 
	 * if (page.getPageTitle() != null && !ObjectUtils.isEmpty(page.getPageTitle()))
	 * { return true; }
	 * 
	 * return false; }
	 */

	public boolean hasPageTitle(Page page) {

		return (page.getPageTitle() != null) && !(ObjectUtils.isEmpty(page)) ? true : false;

	}

}