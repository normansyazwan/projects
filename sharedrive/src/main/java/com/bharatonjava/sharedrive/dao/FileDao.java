package com.bharatonjava.sharedrive.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bharatonjava.sharedrive.domain.FileDetail;

public class FileDao implements IFileDao {

	private Logger log = LoggerFactory.getLogger(FileDao.class);
	private String driveRoot;

	public FileDao(String driveRoot) {
		this.driveRoot = driveRoot;
		if (driveRoot == null) {
			log.info("driveRoot is null. Creating new driveRoot");
		}
		File file = new File(driveRoot);
		if (file.exists() && file.isDirectory()) {
			log.info(file.getAbsolutePath() + " exists");
		}else{
			file.mkdirs();
			log.info(file.getAbsolutePath() + " created");
		}

	}

	public List<FileDetail> getAllFiles(String directoryName) throws IOException {
		Path dir = Paths.get(driveRoot);
		List<FileDetail> fileDetails = new ArrayList<FileDetail>();
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
			for(Path path : stream){
				log.info("#################################################");
				log.info("FileName "+path.getFileName());
				log.info("Root: "+path.getRoot());
				log.info("URI: "+ path.toUri().getPath());
				
				BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
				FileDetail fd = new FileDetail();
				fd.setFileName(path.getFileName().toString());
				fd.setPathOnServer(path.toAbsolutePath().toString());
				fd.setAccessTime(attrs.lastAccessTime());
				fd.setCreationTime(attrs.creationTime());
				fd.setIsDirectory(attrs.isDirectory());
				fd.setIsFile(attrs.isRegularFile());
				fd.setModifiedTime(attrs.lastModifiedTime());
				fd.setSize(attrs.size());
				fileDetails.add(fd);
			}
		}
		//BasicFileAttributes attrs = Files.readAttributes(dir, BasicFileAttributes.class);
		log.info("--> "+fileDetails);
		return fileDetails;
	}

	@Override
	public void deleteSelectedFile(FileDetail fileDetail) throws IOException{
		Path item = Paths.get(fileDetail.getPathOnServer());
		Files.delete(item);
		log.info("Item deleted: "+ fileDetail.getPathOnServer());
	}
	
}
