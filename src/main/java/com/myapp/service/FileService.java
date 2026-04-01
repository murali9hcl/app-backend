package com.myapp.service;

import com.myapp.Entity.ExcelFile;
import com.myapp.repository.ExcelFileRepository;
import com.myapp.util.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class FileService {

    @Autowired
    ExcelFileRepository repository;

    public FileService() throws Exception {

    }

    public void fileUpload(MultipartFile file, String createdBy) throws Exception {
        ExcelFile excelFile = new ExcelFile();
        byte[] encryptedData = EncryptionUtils.encrypt(file.getBytes());
        excelFile.setFileData(encryptedData);
        excelFile.setFileName(file.getOriginalFilename());
        excelFile.setCreatedBy(createdBy);
        excelFile.setCreatedDate(new java.sql.Date(new Date().getTime()));
        excelFile.setStatus("CREATED");
        repository.save(excelFile);
    }
}
