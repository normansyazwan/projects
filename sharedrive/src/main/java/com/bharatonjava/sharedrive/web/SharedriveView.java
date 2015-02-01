package com.bharatonjava.sharedrive.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bharatonjava.sharedrive.domain.FileDetail;
import com.bharatonjava.sharedrive.services.FileService;

public class SharedriveView {

	private Logger log = LoggerFactory.getLogger(SharedriveView.class);
	private FileService fileService;
	private List<FileDetail> fileDetails;
	private FileDetail selectedFileDetail;

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public List<FileDetail> getFileDetails() {
		return fileDetails;
	}

	public void setFileDetails(List<FileDetail> fileDetails) {
		this.fileDetails = fileDetails;
	}

	public FileDetail getSelectedFileDetail() {
		return selectedFileDetail;
	}

	public void setSelectedFileDetail(FileDetail selectedFileDetail) {
		this.selectedFileDetail = selectedFileDetail;
		System.out
				.println("setSelectedFileDetail : " + this.selectedFileDetail);
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

	public void onRowSelect(SelectEvent event) {
		log.info("onRowSelect called");
		FacesMessage msg = new FacesMessage("File Selected - ",
				((FileDetail) event.getObject()).getFileName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		log.info("onRowUnselect called");
		FacesMessage msg = new FacesMessage("File Unselected - ",
				((FileDetail) event.getObject()).getFileName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * Get list of all file in current directory
	 */
	public void getFileList() {

		log.info("getFileList called.");
		try {
			fileDetails = fileService.getAllFiles("FooDirectory");
		} catch (IOException e) {
			log.error("Error occured while fetching list of all file in current directory.",e);
		}
	}
	
	/**
	 * Deletes selected Item
	 */
	public void deleteSelectedItem(){
		
		try{
		log.info("deleteSelectedItem called : " + selectedFileDetail);
		fileService.deleteSelectedFile(selectedFileDetail);
		fileDetails = fileService.getAllFiles("FooDirectory");
		}catch(IOException e){
			FacesMessage msg = new FacesMessage("Error Occured while deleting file: ",
					selectedFileDetail.getFileName());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		log.error("Error occured while deleting file.", e);
		}
	}
}
