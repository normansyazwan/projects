package com.bharatonjava.pathomanager.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bharatonjava.pathomanager.domain.AppEnum;
import com.bharatonjava.pathomanager.services.AppEnumService;

@Controller
@RequestMapping(value = "/master")
public class AppEnumsController {
	private static final Logger log = LoggerFactory
			.getLogger(AppEnumsController.class);
	private AppEnumService appEnumService;

	@Autowired
	public void setAppEnumService(AppEnumService appEnumService) {
		this.appEnumService = appEnumService;
	}

	@RequestMapping("enums/list")
	public String listAppEnums(Model model) {
		List<AppEnum> tests = appEnumService.getAppEnumsByGroup("TEST");
		AppEnum appEnum = new AppEnum();
		model.addAttribute("appEnum", appEnum);
		model.addAttribute("tests", tests);
		return "enums.listview";
	}

	@RequestMapping("enums/delete/{enumId}")
	public String deleteAppEnum(@PathVariable("enumId") Long enumId, Model model) {

		int count = appEnumService.deleteAppEnum(enumId);
		if (count == 0) {
			log.info("delete enumeration with id: {}, count: {}", enumId, count);
		}else{
			log.info("{} enums deleted", count);
		}
		return "redirect:/master/enums/list";
	}

	@RequestMapping("enums/edit/{enumId}")
	public String editAppEnum(@PathVariable("enumId") Long enumId, Model model) {
		AppEnum appEnum = appEnumService.getAppEnumsById(enumId);
		model.addAttribute("appEnum", appEnum);
		
		List<AppEnum> tests = appEnumService.getAppEnumsByGroup("TEST");
		model.addAttribute("tests", tests);
		
		return "enums.listview";
	}

}
