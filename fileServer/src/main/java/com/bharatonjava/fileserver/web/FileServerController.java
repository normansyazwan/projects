package com.bharatonjava.fileserver.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.fileserver.utils.Constants;

@Controller
public class FileServerController {

	private static final Logger log = LoggerFactory
			.getLogger(FileServerController.class);

	@Value("${repository.path:c:\\file-repo}")
	private String repositoryPath;

	private boolean repoExists = false;

	public void setRepositoryPath(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}

	@RequestMapping(value = { "/", "/home", "/files" })
	public String showHome(
			Model model,
			@RequestParam(value = "status", required = false, defaultValue = "none") String status) {
		log.info("inside showHome method");

		// check if repo exists
		if (!repoExists) {
			File file = new File(repositoryPath);
			if (file.exists() && file.isDirectory()) {
				repoExists = true;
				log.info("repository exists at: " + repositoryPath);
			} else {
				if (file.mkdirs()) {
					log.info("repository created at: " + repositoryPath);
				} else {
					log.error("repository could not be created at: "
							+ repositoryPath);
				}

			}

		}
		
		// list files
		Collection<File> files = FileUtils.listFiles(new File(repositoryPath), null, true);

		List<String[]> fileList = new ArrayList<String[]>();
		
		Iterator<File> fileIterator = files.iterator();
		while(fileIterator.hasNext()){
			String[] arr = new String[5];
			
			
			File f = fileIterator.next();
			arr[0] = f.getName();
			arr[1] = Double.toString(f.length() / 1024) + " Kb";
			arr[2] = new Date(f.lastModified()).toString();
			
			fileList.add(arr);
		}
		
		
		model.addAttribute("fileList", fileList);
		
		return "listFiles";
	}

	@RequestMapping(value = { "/files/upload" })
	public String showSingleFileUpload(Model model) {

		log.info("inside showSingleFileUpload method");
		log.info("repo path " + repositoryPath);

		return "fileUpload";
	}

	@RequestMapping(value = { "/files/upload" }, method = RequestMethod.POST)
	public String processSingleFileUpload(
			@RequestParam("file") MultipartFile file,
			@RequestParam("name") String name, Model model) {
		log.info("inside processSingleFileUpload method");

		
	
		String fileName = null;
		if (!file.isEmpty()) {
			try {
				if(name != null && !name.trim().equals("")){
					String extension = FilenameUtils.getExtension(file.getOriginalFilename());
					fileName = name+"."+ extension;
				}else{
					fileName = file.getOriginalFilename();	
				}
				
				byte[] bytes = file.getBytes();
				
				String fullName = repositoryPath +"\\" + fileName;
				log.info("Storing file to: {}", fullName);
				BufferedOutputStream buffStream = new BufferedOutputStream(
						new FileOutputStream(
								new File(fullName)));
				buffStream.write(bytes);
				buffStream.close();
				model.addAttribute("status", Constants.SUCCESS);
				log.info("File uploaded successfully.");
			} catch (Exception e) {
				log.error("File upload failed " + fileName, e);
				model.addAttribute("status", Constants.FAILURE);
			}
		} else {
			log.info("Unable to upload. File is empty.");
			model.addAttribute("status", Constants.FAILURE);
		}

		return "redirect:/home";
	}
	
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(HttpServletResponse response, @RequestParam("file") String fileName) throws IOException {

		String fullFileName = repositoryPath + "\\"+fileName;
		
		File file = new File(fullFileName);
		InputStream is = new FileInputStream(file);

		// MIME type of the file
		response.setContentType("application/octet-stream");
		// Response header
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ file.getName() + "\"");
		// Read from the file and write into the response
		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		os.flush();
		os.close();
		is.close();
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView search(@RequestParam(value = "q", required = false) String query){
		ModelAndView mav = new ModelAndView();
		log.info("Search query: {}", query);
		mav.setViewName("listFiles");
		mav.addObject("q", query);
		return mav;
	}
	
}
