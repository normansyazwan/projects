package com.bharatonjava.ebroker.web;

import java.util.List;

import com.bharatonjava.ebroker.domain.Executive;
import com.bharatonjava.ebroker.services.ExecutiveService;

public class ExecutiveBean {

	private Executive executive;
	private List<Executive> executives;
	private Executive selectedExecutive;
	private ExecutiveService executiveService;

	public ExecutiveBean() {
		this.executive = new Executive();
	}

	public void setExecutive(Executive executive) {
		this.executive = executive;
	}

	public Executive getExecutive() {
		return executive;
	}

	public List<Executive> getExecutives() {
		return executives;
	}

	public void setExecutives(List<Executive> executives) {
		this.executives = executives;
	}

	public Executive getSelectedExecutive() {
		return selectedExecutive;
	}

	public void setSelectedExecutive(Executive selectedExecutive) {
		this.selectedExecutive = selectedExecutive;
	}

	public void setExecutiveService(ExecutiveService executiveService) {
		this.executiveService = executiveService;
	}

	public void saveExecutive() {
		System.out.println(executive);
		executiveService.saveExecutive(executive);
	}

	public String getListOfExecutives() {
		executives = executiveService.getAllExecutives();
		System.out
				.println("getListOfExecutives called. Size: " + executive != null ? executives
						.size() : 0);
		return "executives";
	}

}
