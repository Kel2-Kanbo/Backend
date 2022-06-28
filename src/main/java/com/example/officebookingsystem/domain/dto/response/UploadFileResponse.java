package com.example.officebookingsystem.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadFileResponse {
    private String fileName;
    private String fileloadUri;
    private String fileType;
    private long size;

    public UploadFileResponse(String fileName, String fileloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileloadUri = fileloadUri;
        this.fileType = fileType;
        this.size = size;
    }
}
