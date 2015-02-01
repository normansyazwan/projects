package com.bharatonjava.sharedrive.services;

import java.io.IOException;
import java.util.List;

import com.bharatonjava.sharedrive.dao.IFileDao;
import com.bharatonjava.sharedrive.domain.FileDetail;

public class FileService {
	
	private IFileDao fileDao;
	
	
	public void setFileDao(IFileDao fileDao) {
		this.fileDao = fileDao;
	}
	
	public List<FileDetail> getAllFiles(String directoryName) throws IOException {
		return fileDao.getAllFiles(directoryName);
	}
	
	public void deleteSelectedFile(FileDetail fileDetail) throws IOException{
		fileDao.deleteSelectedFile(fileDetail);
	}
}
