package com.bookpublisher.app.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookpublisher.app.dao.FileuploadingDAO;
import com.bookpublisher.app.dto.AuthorsDTO;
import com.bookpublisher.app.dto.FilePropertiseDTO;
import com.bookpublisher.app.util.FileDownlodUtil;

@Service
public class FileuploadingServiceImp implements FileuploadingService {	
	@Autowired
	public FileuploadingDAO fileuploadingDAO;
	
	@Override
	public void saveFile(FilePropertiseDTO filePropertise) {
		
		fileuploadingDAO.saveFile(filePropertise);
	}

	@Override
	public List<FilePropertiseDTO> getFileList() {
		
		return fileuploadingDAO.getFileList();
	}

	@Override
	public FilePropertiseDTO getFileById(int fileid) {
		
		return fileuploadingDAO.getFileById(fileid);
	}

	@Override
	public boolean doDeleateRow(int id) {
		return fileuploadingDAO.doDeleateRow(id);
	}

	@Override
	public List<AuthorsDTO> getbookDetailsLiat() {
		
		return  fileuploadingDAO.getbookDetailsLiat();
	}
	
	@Override
	public void getSaveDBtoXlsx() {
		fileuploadingDAO.getSaveDBtoXlsx();
	}

	@Override
	public void downloadXlsxFill(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		FileDownlodUtil.downloadXlsxFill(request,response);
	}








}
