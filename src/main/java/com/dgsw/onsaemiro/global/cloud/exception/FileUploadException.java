package com.dgsw.onsaemiro.global.cloud.exception;


import com.dgsw.onsaemiro.global.cloud.exception.error.FileErrorProperty;
import com.dgsw.onsaemiro.global.exception.BusinessException;

public class FileUploadException extends BusinessException {
    public static final FileUploadException EXCEPTION = new FileUploadException();

    private FileUploadException(){
        super(FileErrorProperty.FILE_UPLOAD_ERROR);
    }
}
