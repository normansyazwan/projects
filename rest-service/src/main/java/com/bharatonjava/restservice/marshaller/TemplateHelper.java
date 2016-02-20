package com.bharatonjava.restservice.marshaller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

public class TemplateHelper {

	private static final Logger log = LoggerFactory
			.getLogger(TemplateHelper.class);
	
	private static Configuration configuration = new Configuration(new Version("2.3.23"));
	
	static{
		ClassTemplateLoader ctl = new ClassTemplateLoader(TemplateHelper.class, "/");
		configuration.setTemplateLoader(ctl);
	}
	
	private TemplateHelper() {
		
	}

	public static Template getTemplate(String templateFileName) {
		Template template = null;
		try {
			template = configuration.getTemplate(templateFileName);
		} catch (IOException e) {
			log.error("Failed to load template file named: {}",
					templateFileName, e);
		}
		return template;
	}
}
