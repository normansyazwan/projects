package com.bharatonjava.restservice.gateway;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bharatonjava.restservice.marshaller.TemplateHelper;
import com.bharatonjava.restservice.service.DefaultDataService;
import com.bharatonjava.restservice.utils.Constants;

import freemarker.template.Template;

/**
 * Servlet implementation class GatewayServlet
 */
public class GatewayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(GatewayServlet.class);

	private static ApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext(
				new String[] { "spring-config.xml" });
	}

	/**
	 * Default constructor.
	 */
	public GatewayServlet() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// output format
		response.setHeader("Content-Type", "text/xml");

		// input stream
		OutputStream outputStream = response.getOutputStream();
		RestRequest restRequest = new SimpleRestRequest(outputStream);

		// request params
		Map<String, String> params = request.getParameterMap();
		restRequest.getRequestMap()
				.put("contextPath", request.getContextPath());

		restRequest.getRequestMap().put("scheme", request.getScheme());

		//
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();

			String[] paramValues = request.getParameterValues(paramName);
			String paramValue = null;
			for (int i = 0; i < paramValues.length; i++) {
				paramValue = paramValues[i];
			}
			restRequest.getRequestMap().put(paramName, paramValue);
		}

		for (String key : params.keySet()) {

			if (key != null && key.equals(Constants.DATA_SCHEMA_VERSION)) {

			} else {
				restRequest.getRequestMap().put(key, params.get(key));
			}
		}

		// path
		log.info("pathInfo: {}", request.getPathInfo());

		// first item in path should be objecttype

		String pathString = request.getPathInfo();
		String objectType = null;
		if (pathString != null) {

			if (pathString.startsWith("/")) {
				// get rid of initial slash
				pathString = pathString.substring(1, pathString.length());
			}

			if (pathString.contains("/")) {

				objectType = pathString.substring(0, pathString.indexOf("/"));
			} else {
				objectType = pathString;
			}

			restRequest.getRequestMap().put(Constants.OBJECT_TYPE,
					objectType.toUpperCase());

			// set schemaVersion in request
			/*
			if (params.containsKey(Constants.DATA_SCHEMA_VERSION)) {
				restRequest.getRequestMap().put(Constants.DATA_SCHEMA_VERSION,
						params.get(Constants.DATA_SCHEMA_VERSION));
			}
			*/

			
			
			restRequest.getRequestMap().put(
					Constants.OBJECTTYPE_WITH_VERSION,
					objectType.toUpperCase()
							+ Constants.COLON
							+ restRequest.getRequestMap().get(
									Constants.DATA_SCHEMA_VERSION));
			
		} else {
			log.error("pathString is null");
		}

		log.info("final request map");
		for (Object key : restRequest.getRequestMap().keySet()) {
			log.info("{} = {}", key, restRequest.getRequestMap().get(key));
		}

		ServiceStatus status = new ServiceStatus();
		// call service for data
		try {
			DefaultDataService dds = new DefaultDataService();
			dds.getData(restRequest, status);
		} catch (ProcessingException pe) {
			log.error("Exception occured in dds.", pe);
			writeErrorToStream(restRequest, status);
		} catch (Exception e) {
			log.error("Exception occured in dds.", e);
			writeErrorToStream(restRequest, status);
		}

	}

	protected void writeErrorToStream(RestRequest request, ServiceStatus status) {
		log.info("Request is not valid.. writing error to stream.");
		Template template = TemplateHelper
				.getTemplate(Constants.ERROR_TEMPLATE);
		OutputStreamWriter writer = new OutputStreamWriter(
				request.getOutputStream());
		Map<Object, Object> rootMap = new HashMap<Object, Object>();
		rootMap.put("status_code", status.getStatusCode());
		rootMap.put("status_message", status.getStatusMessage());
		try {
			template.process(rootMap, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
