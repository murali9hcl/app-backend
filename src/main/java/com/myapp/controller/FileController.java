package com.myapp.controller;

import com.myapp.service.FileService;
import com.myapp.util.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/app")
public class FileController {


    @Autowired
    FileService fileService;


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file, @RequestParam("createdBy") String createdBy){
        try {
            boolean result = FileValidator.isValidFileExtension(file);
            if(!result) {
                return new ResponseEntity<>("file type only excel is supported", HttpStatus.BAD_REQUEST);
            }
            fileService.fileUpload(file, createdBy);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("issue encounted during file upload", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("file uploaded successfully", HttpStatus.OK);
    }


}

