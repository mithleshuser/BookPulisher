package com.bookpublisher.app.service;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookpublisher.app.dto.AuthorsDTO;
import com.bookpublisher.app.dto.FilePropertiseDTO;
public interface FileuploadingService {
	public void saveFile(FilePropertiseDTO filePropertise);

	public List<FilePropertiseDTO> getFileList();
	public List<AuthorsDTO> getbookDetailsLiat();

	public FilePropertiseDTO getFileById(int fileid);

	public boolean doDeleateRow(int id);
	public void getSaveDBtoXlsx();
	public void downloadXlsxFill(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
