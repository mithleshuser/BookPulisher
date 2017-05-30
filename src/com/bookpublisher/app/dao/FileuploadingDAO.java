package com.bookpublisher.app.dao;

import java.util.List;

import com.bookpublisher.app.dto.AuthorsDTO;
import com.bookpublisher.app.dto.FilePropertiseDTO;

public interface FileuploadingDAO {
	public void saveFile(FilePropertiseDTO filePropertise);

	public List<FilePropertiseDTO> getFileList();

	public FilePropertiseDTO getFileById(int fileid);

	public boolean doDeleateRow(int id);

	public void getSaveDBtoXlsx();

	public List<AuthorsDTO> getbookDetailsLiat();

}