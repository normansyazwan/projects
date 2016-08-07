package com.bharatonjava.therapymanager.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.bharatonjava.therapymanager.domain.Assesment;

public class TherapyTagHandler extends SimpleTagSupport {

	private Assesment assessment;
	private int width;
	private int height;
	private int fontSize;

	public Assesment getAssessment() {
		return assessment;
	}
	
	public void setAssessment(Assesment assessment) {
		this.assessment = assessment;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	@Override
	public void doTag() throws JspException, IOException {
		try {
			
			if(width == 0){
				width = 200;
			}
			
			if(height == 0){
				height = 150;
			}
			
			PageContext context = (PageContext) getJspContext();
			//JspWriter out = getJspContext().getOut();
			context.getRequest().setAttribute("a", assessment);
			context.getRequest().setAttribute("width", width);
			context.getRequest().setAttribute("height", height);
			context.getRequest().setAttribute("fontSize", fontSize);
			context.include("/WEB-INF/views/assesment/assessmentTagBlock.jsp", true);
		} catch (Exception e) {

		}
	}

}
