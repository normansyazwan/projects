package com.bharatonjava.hospital.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

public class GenerateModule {

	private static final Logger log = LoggerFactory
			.getLogger(GenerateModule.class);

	private Metadata init() {
		Metadata m = new Metadata();
		 m.setClassName("Doctor");
		m.setBasePackage("com.bharatonjava.hospial");
		 m.getFields().add(new Field("firstName","String"));
		 m.getFields().add(new Field("lastName","String"));
		m.getFields().add(new Field("age","int"));

//		m.setClassName("Patient");
//		m.setBasePackage("com.bharatonjava.hospial");
//		m.getFields().add(new Field("firstName", "String"));
//		m.getFields().add(new Field("lastName", "String"));
//		m.getFields().add(new Field("age", "int"));
//		m.getFields().add(new Field("address", "String"));

		return m;
	}

	private void doGeneration() {

		log.info("starting module generation");
		Metadata metadata = init();
		// check if module package exists
		String javaCodePackage = "src/test/resources";
		String basePackage = "com/bharatonjava/hosptial";
		String fullPath = javaCodePackage + "/" + basePackage;
		File directory = new File(fullPath);

		if (directory.exists()) {
			log.info("Code directory exists: {}", fullPath);
		} else {
			log.info("Code directory does not exist. Generating: {}", fullPath);
			directory.mkdirs();
			log.info("code directory created");
		}

		// generateDomainClass(fullPath, metadata);

		generateDaoClass(metadata);
	}

	private void generateDomainClass(String filePath, Metadata metadata) {

		log.info("Generating domain class");
		try {
			Configuration cfg = getFreemarkerConfiguration();

			Map<String, Object> dataModel = new HashMap<String, Object>();
			dataModel.put("className", metadata.getClassName());
			dataModel.put("fields", metadata.getFields());

			Template template = null;

			template = cfg.getTemplate("domain.ftl");
			Writer writer = new FileWriter(new File(filePath + "/"
					+ dataModel.get("className") + ".java"));
			template.process(dataModel, writer);
			writer.flush();
			writer.close();
			log.info("domain class generated succssfully: {}",
					dataModel.get("className"));

		} catch (Exception e) {
			log.error("Error while generating domain class. ", e);
		}
	}

	private Configuration getFreemarkerConfiguration() throws IOException {
		Configuration cfg = new Configuration(new Version(2, 3, 22));
		cfg.setDirectoryForTemplateLoading(new File("src/test/resources"));
		TemplateLoader templateLoader = new FileTemplateLoader(new File(
				"src/test/resources"));
		cfg.setTemplateLoader(templateLoader);
		return cfg;
	}

	private void generateDaoClass(Metadata metadata) {
		try {
			Configuration configuration = getFreemarkerConfiguration();
			Template template = configuration.getTemplate("dao-template.ftl");
			
			Map<String, Object> dataModel = new HashMap<String, Object>();
			dataModel.put("m", metadata);
			//javaCodePackage +"/com/bharatonjava/hospital"+ "/"+
			
			String javaCodePackage = "src/test/resources";
			Writer writer = new FileWriter(new File(metadata.getClassName() + "Dao.java"));
			template.process(dataModel, writer);
			writer.flush();
			writer.close();
			log.info("Dao class generated succssfully.");
		} catch (Exception e) {
			log.error("Exception while generating dao class.", e);
		}
	}

	public static void main(String[] args) {

		new GenerateModule().doGeneration();

		log.info("xxxxxxxxx Done xxxxxxxx");
	}

}
