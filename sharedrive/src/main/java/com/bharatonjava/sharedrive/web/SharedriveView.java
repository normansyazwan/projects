package com.bharatonjava.sharedrive.web;

import java.util.List;

import javax.annotation.PostConstruct;

import com.bharatonjava.sharedrive.domain.FileDetail;
import com.bharatonjava.sharedrive.services.FileService;

public class SharedriveView {

	private FileService fileService;
	private List<FileDetail> fileDetails;

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public List<FileDetail> getFileDetails() {
		return fileDetails;
	}
	
	public void setFileDetails(List<FileDetail> fileDetails) {
		this.fileDetails = fileDetails;
	}
	
	public SharedriveView() {
	}

	@PostConstruct
	public void initialize() {
		try {

			fileService.getAllFiles("FooDirectory");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getFileList() {
		System.out.println("getFileList called.");
		try {
			fileDetails = fileService.getAllFiles("FooDirectory");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
