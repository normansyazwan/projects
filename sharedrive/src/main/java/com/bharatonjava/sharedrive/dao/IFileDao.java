package com.bharatonjava.sharedrive.dao;

import java.io.IOException;
import java.util.List;

import com.bharatonjava.sharedrive.domain.FileDetail;

public interface IFileDao {

	public List<FileDetail> getAllFiles(String directoryName) throws IOException;
}
