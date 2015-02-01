package com.bharatonjava.sharedrive.domain;

import java.nio.file.attribute.FileTime;

public class FileDetail {
	
	private String fileName;
	private long size;
	private boolean isFile;
	private boolean isDirectory;
	private String pathOnServer;
	private FileTime creationTime;
	private FileTime accessTime;
	private FileTime modifiedTime;
	
	public FileDetail() {
	}

	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		if(size != 0){
			this.size = size / 1024;
		}else{
			this.size = size;
		}
			
	}

	public boolean getIsFile() {
		return isFile;
	}

	public void setIsFile(boolean isFile) {
		this.isFile = isFile;
	}

	public boolean getIsDirectory() {
		return isDirectory;
	}

	public void setIsDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}

	public String getPathOnServer() {
		return pathOnServer;
	}
	
	public void setPathOnServer(String pathOnServer) {
		this.pathOnServer = pathOnServer;
	}
	
	public FileTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(FileTime creationTime) {
		this.creationTime = creationTime;
	}

	public FileTime getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(FileTime accessTime) {
		this.accessTime = accessTime;
	}

	public FileTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(FileTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "FileDetail [fileName="+ fileName +", size=" + size + ", isFile=" + isFile
				+ ", isDirectory=" + isDirectory + ", creationTime="
				+ creationTime + ", accessTime=" + accessTime
				+ ", modifiedTime=" + modifiedTime + "]";
	}
	
}
