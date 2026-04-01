package com.myapp.util;

import org.springframework.web.multipart.MultipartFile;


public class FileValidator {

    private static final String[] validExtensions = {".xlsx", ".xls"};

    public static boolean isValidFileExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName != null) {
            for (String extension : validExtensions) {
                if (fileName.toLowerCase().endsWith(extension.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }
}

